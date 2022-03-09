package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.OfferDao;
import ir.maktab.houseservicesspringboot.dao.OrderDao;
import ir.maktab.houseservicesspringboot.dao.SubCategoryDao;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.exception.OfferException;
import ir.maktab.houseservicesspringboot.exception.ProposedPriceException;
import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OfferDto;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Offer;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;
import ir.maktab.houseservicesspringboot.model.enumaration.OrderStatus;
import ir.maktab.houseservicesspringboot.service.mapper.ExpertMapper;
import ir.maktab.houseservicesspringboot.service.mapper.OfferMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService{
    private final OfferDao offerDao;
    private final OfferMapper offerMapper;
    private final OrderDao orderDao;
    private final SubCategoryDao subCategoryDao;
    private final ExpertMapper expertMapper;

    @Override
    public String addOffer(OfferDto offerDto, String orderTrackingCode, ExpertDto expertDto){
        Order order = orderDao.findOrdersByTrackingCode(orderTrackingCode);
        if(!order.getOrderStatus().equals(OrderStatus.WAITING_FOR_EXPERT_OFFER))
            throw new OfferException("the order status is not match!");
        SubCategory subCategory = order.getSubCategory();
        Double basePrice = subCategoryDao.findSubCategoryById(subCategory.getId());
        if(offerDto.getProposedPrice() < basePrice)
            throw new ProposedPriceException("the proposed price is less than base price!");
        Offer offer = offerMapper.toOffer(offerDto);
        Expert expert = expertMapper.toExpert(expertDto);
        offer.setExpert(expert);
        offer.setOrder(order);
        Offer registeredOffer = offerDao.save(offer);
        Order markedOrder = offer.getOrder();
        markedOrder.setOrderStatus(OrderStatus.WAITING_TO_CHOOSE_AN_EXPERT);
        orderDao.save(markedOrder);
        return registeredOffer.getOrder().getTrackingCode();
    }

    @Override
    public void removeOffer(OfferDto offerDto){
        Offer offer = offerMapper.toOffer(offerDto);
        Optional<Offer> foundOffer = offerDao.findById(offer.getId());
        if(foundOffer.isEmpty())
            throw new NotFoundException("offer not found!");
        offerDao.delete(offer);
    }

    @Override
    public void update(OfferDto offerDto){
        Offer offer = offerMapper.toOffer(offerDto);
        Optional<Offer> foundOffer = offerDao.findById(offer.getId());
        if(foundOffer.isEmpty())
            throw new NotFoundException("offer not found!");
        offerDao.save(offer);
    }

    @Override
    public List<OfferDto> getAllOffers(Expert expert, Order order){
        List<Offer> offers = offerDao.findAllOffers(expert, order);
        if(offers.isEmpty())
            throw new NotFoundException("there is no offer!");
        return offers.stream().map(offerMapper::toOfferDto).collect(Collectors.toList());
    }
}
