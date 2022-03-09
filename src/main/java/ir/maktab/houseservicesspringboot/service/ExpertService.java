package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.model.entity.Expert;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @author Mahsa Alikhani m-58
 */
public interface ExpertService {

    void add(ExpertDto expertDto, String siteUrl) throws MessagingException, UnsupportedEncodingException;

    boolean verifyExpert(String verificationCode);

    void update(Expert expert);

    List<ExpertDto> getAllExperts();

    void remove(Expert expert);

    Map<String, List<OrderDto>> getExpertSubCategoryOrdersList(ExpertDto expertDto);

    Double getExpertCreditByEmail(ExpertDto expertDto);
}
