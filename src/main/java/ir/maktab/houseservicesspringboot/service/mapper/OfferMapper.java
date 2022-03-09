package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.OfferDto;
import ir.maktab.houseservicesspringboot.model.entity.Offer;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class OfferMapper {

    public Offer toOffer(OfferDto offerDto){
        return Offer.builder()
                .proposedPrice(offerDto.getProposedPrice())
                .workDuration(offerDto.getWorkDuration())
                .startTime(offerDto.getStartTime())
                .order(offerDto.getOrder())
                .expert(offerDto.getExpert())
                .build();
    }

    public OfferDto toOfferDto(Offer offer){
        return OfferDto.builder()
                .proposedPrice(offer.getProposedPrice())
                .workDuration(offer.getWorkDuration())
                .startTime(offer.getStartTime())
                .order(offer.getOrder())
                .expert(offer.getExpert())
                .build();
    }
}
