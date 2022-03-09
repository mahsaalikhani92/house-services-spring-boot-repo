package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.ExpertDao;
import ir.maktab.houseservicesspringboot.dao.OrderDao;
import ir.maktab.houseservicesspringboot.exception.DuplicateException;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;
import ir.maktab.houseservicesspringboot.model.enumaration.OrderStatus;
import ir.maktab.houseservicesspringboot.model.enumaration.Role;
import ir.maktab.houseservicesspringboot.model.enumaration.UserStatus;
import ir.maktab.houseservicesspringboot.service.mapper.ExpertMapper;
import ir.maktab.houseservicesspringboot.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class ExpertServiceImpl implements ExpertService {
    private final ExpertDao expertDao;
    private final ExpertMapper expertMapper;
    private final OrderDao orderDao;
    private final OrderMapper orderMapper;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;

    @Override
    public void add(ExpertDto expertDto, String siteUrl) throws MessagingException, UnsupportedEncodingException {
        Expert expert = expertMapper.toExpert(expertDto);
        Optional<Expert> found = expertDao.findByEmail(expert.getEmail());
        if (found.isPresent())
            throw new DuplicateException("Duplicate expert!");
        expert.setPassword(passwordEncoder.encode(expert.getPassword()));
        expert.setRole(Role.EXPERT);
        expert.setUserStatus(UserStatus.NEW);
        String randomCode = RandomString.make(64);
        expert.setVerificationCode(randomCode);
        expert.setEnabled(false);
        expertDao.save(expert);
        sendVerificationEmail(expert, siteUrl);
    }

    private void sendVerificationEmail(Expert expert, String siteUrl) throws MessagingException, UnsupportedEncodingException {
        String toAddress = expert.getEmail();
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

        content = content.replace("[[name]]", expert.getName());
        String verifyURL = siteUrl + "/verify?code=" + expert.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @Override
    public boolean verifyExpert(String verificationCode) {
        Expert expert = expertDao.findByVerificationCode(verificationCode);
        if (expert == null || expert.isEnabled()) {
            return false;
        } else {
            expert.setVerificationCode(null);
            expert.setEnabled(true);
            expert.setUserStatus(UserStatus.WAITING);
            expertDao.save(expert);
            return true;
        }
    }

    @Override
    public void update(Expert expert) {
        Optional<Expert> found = expertDao.findByEmail(expert.getEmail());
        if (found.isEmpty())
            throw new NotFoundException("expert not found!");
        expertDao.save(expert);
    }

    @Override
    public List<ExpertDto> getAllExperts() {
        List<Expert> experts = expertDao.findAll();
        if (experts.isEmpty())
            throw new NotFoundException("there is no expert!");
        return experts.stream().map(expertMapper::toExpertDto).collect(Collectors.toList());
    }

    @Override
    public void remove(Expert expert) {
        Optional<Expert> found = expertDao.findByEmail(expert.getEmail());
        if (found.isEmpty())
            throw new NotFoundException("expert not found!");
        expertDao.delete(expert);
    }

    @Override
    public Map<String, List<OrderDto>> getExpertSubCategoryOrdersList(ExpertDto expertDto) {
        Map<String, List<OrderDto>> orderSubCategoryMap = new HashMap<>();
        List<SubCategory> subCategories = expertDao.findExpertSubCategoryList(expertDto.getEmail());
        if (subCategories.isEmpty())
            throw new NotFoundException("there is no sub category list");
        for (SubCategory subCategory : subCategories) {
            List<Order> orders = orderDao.findOrdersBySubCategoryTitle(subCategory.getTitle());
            if (!orders.isEmpty()) {
                List<OrderDto> customOrders = orders
                        .stream()
                        .filter(order -> order.getOrderStatus().equals(OrderStatus.WAITING_FOR_EXPERT_OFFER))
                        .map(orderMapper::toOrderDto)
                        .collect(Collectors.toList());
                orderSubCategoryMap.put(subCategory.getTitle(), customOrders);
            }
        }
        if (orderSubCategoryMap.isEmpty())
            throw new NotFoundException("there is no order!");
        return orderSubCategoryMap;
    }

    @Override
    public Double getExpertCreditByEmail(ExpertDto expertDto) {
        return expertDao.findExpertCreditByEmail(expertDto.getEmail());
    }
}
