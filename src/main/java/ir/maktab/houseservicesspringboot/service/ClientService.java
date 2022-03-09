package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.OfferDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface ClientService {

    void add(ClientDto clientDto, String siteUrl) throws MessagingException, UnsupportedEncodingException;

    boolean verifyClient(String verificationCode);

    void update(Client client);

    List<ClientDto> getAllClients();

    void remove(Client client);

    List<OfferDto> getClientOrderOffersOrderByProposedPriceAndExpertRate(String orderTrackingCode);

    Expert chooseAnExpertForOrder(Order order, Expert expert);

    Double getClientCreditByEmail(ClientDto clientDto);

    void payUsingCredit(ClientDto clientDto, String code, double amount);

}
