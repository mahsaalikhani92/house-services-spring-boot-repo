package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.ClientDao;
import ir.maktab.houseservicesspringboot.dao.ExpertDao;
import ir.maktab.houseservicesspringboot.dao.OfferDao;
import ir.maktab.houseservicesspringboot.dao.OrderDao;
import ir.maktab.houseservicesspringboot.exception.DuplicateException;
import ir.maktab.houseservicesspringboot.exception.NotEnoughCreditException;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.OfferDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Offer;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.enumaration.OrderStatus;
import ir.maktab.houseservicesspringboot.model.enumaration.Role;
import ir.maktab.houseservicesspringboot.model.enumaration.UserStatus;
import ir.maktab.houseservicesspringboot.service.mapper.ClientMapper;
import ir.maktab.houseservicesspringboot.service.mapper.OfferMapper;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientDao clientDao;
    private final ClientMapper clientMapper;
    private final OfferDao offerDao;
    private final OrderDao orderDao;
    private final ExpertDao expertDao;
    private final OfferMapper offerMapper;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;

    @Override
    public void add(ClientDto clientDto, String siteUrl) throws MessagingException, UnsupportedEncodingException {
        Client client = clientMapper.toClient(clientDto);
        Optional<Client> found = clientDao.findByEmail(client.getEmail());
        if(found.isPresent())
            throw new DuplicateException("Duplicate client!");
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setRole(Role.CLIENT);
        client.setUserStatus(UserStatus.NEW);
        String randomCode = RandomString.make(64);
        client.setVerificationCode(randomCode);
        client.setEnabled(false);
        clientDao.save(client);
        sendVerificationEmail(client, siteUrl);
    }

    private void sendVerificationEmail(Client client, String siteUrl) throws MessagingException, UnsupportedEncodingException {
        String toAddress = client.getEmail();
        String fromAddress = "Your email address";
        String senderName = "Your company name";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", client.getName());
        String verifyURL = siteUrl + "/verify?code=" + client.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);
    }

    public boolean verifyClient(String verificationCode) {
        Client client = clientDao.findByVerificationCode(verificationCode);
        if (client == null || client.isEnabled()) {
            return false;
        } else {
            client.setVerificationCode(null);
            client.setEnabled(true);
            client.setUserStatus(UserStatus.CONFIRMED);
            clientDao.save(client);
            return true;
        }
    }

    @Override
    public void update(Client client){
        Optional<Client> found = clientDao.findByEmail(client.getEmail());
        if(found.isEmpty())
            throw new NotFoundException("client not found!");
        clientDao.save(client);
    }

    @Override
    public List<ClientDto> getAllClients(){
        List<Client> clients = clientDao.findAll();
        if(clients.isEmpty())
            throw new NotFoundException("there is no client!");
        return clients.stream().map(clientMapper::toClientDto).collect(Collectors.toList());
    }

    @Override
     public void remove(Client client){
         Optional<Client> found = clientDao.findByEmail(client.getEmail());
         if(found.isEmpty())
             throw new NotFoundException("client not found!");
         clientDao.delete(client);
     }

    @Override
    public List<OfferDto> getClientOrderOffersOrderByProposedPriceAndExpertRate(String orderTrackingCode) {
        Order order = orderDao.findOrdersByTrackingCode(orderTrackingCode);
        List<Offer> offers = offerDao.findOffersByOrder(order);
        if(offers.isEmpty())
            throw new NotFoundException("there is no offers!");
        return offers.stream().map(offerMapper::toOfferDto).collect(Collectors.toList());
    }

    @Override
    public Expert chooseAnExpertForOrder(Order order, Expert expert) {
        order.setOrderStatus(OrderStatus.WAITING_FOR_THE_EXPERT_TO_ARRIVE_AT_LOCATION);
        order.setExpert(expert);
        Order updatedOrder = orderDao.save(order);
        return updatedOrder.getExpert();
    }

    @Override
    public Double getClientCreditByEmail(ClientDto clientDto) {
        return clientDao.findClientCreditByEmail(clientDto.getEmail());
    }

    @Override
    @Transactional
    public void payUsingCredit(ClientDto clientDto, String code, double charge) {
        Client client = clientMapper.toClient(clientDto);
        double clientCredit = clientDao.findClientCreditByEmail(client.getEmail());
        if(clientCredit < charge)
            throw new NotEnoughCreditException("Your credit is not enough!");
        double newClientCredit = clientCredit - charge;
        client.setCredit(newClientCredit);
        clientDao.save(client);
        Order order = orderDao.findOrdersByTrackingCode(code);
        Expert expert = order.getExpert();
        double expertCredit = expertDao.findExpertCreditByEmail(expert.getEmail());
        double newExpertCredit = expertCredit + (charge * 0.7);
        expert.setCredit(newExpertCredit);
        expertDao.save(expert);
        order.setOrderStatus(OrderStatus.PAID);
        orderDao.save(order);
    }
}
