package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OfferDto;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;

import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface OfferService {

    String addOffer(OfferDto offerDto, String orderTrackingCode, ExpertDto expertDto);

    void removeOffer(OfferDto offerDto);

    void update(OfferDto offerDto);

    List<OfferDto> getAllOffers(Expert expert, Order order);
}
