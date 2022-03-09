package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.*;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderFilterDto;
import ir.maktab.houseservicesspringboot.model.dto.PerformedServicesDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Offer;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.enumaration.OrderStatus;
import ir.maktab.houseservicesspringboot.model.enumaration.Role;
import ir.maktab.houseservicesspringboot.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final OrderDao orderDao;
    private final ExpertDao expertDao;
    private final ClientDao clientDao;
    private final OfferDao offerDao;
    private final OrderMapper orderMapper;

    @Override
    public List<PerformedServicesDto> getAllReceivedClientOrders(String email) {
        List<PerformedServicesDto> completedOrderList = new ArrayList<>();
        Optional<Client> foundClient =  clientDao.findByEmail(email);
        if(foundClient.isEmpty())
            throw new NotFoundException("client not found!");
        Client client = foundClient.get();
        Role role = client.getRole();
        List<Order> orders = orderDao.findAllReceivedOrdersByClient(client, OrderStatus.PAID);
        if(orders.isEmpty())
            throw new NotFoundException("there is no done service for " + client.getEmail());
        return getFilterOrders(email, completedOrderList, role, orders);
    }

    @Override
    public List<PerformedServicesDto> getAllDoneOrdersByExpert(String email) {
        List<PerformedServicesDto> completedOrderList = new ArrayList<>();
        Optional<Expert> foundExpert =  expertDao.findByEmail(email);
        if(foundExpert.isEmpty())
            throw new NotFoundException("expert not found!");
        Expert expert = foundExpert.get();
        Role role = expert.getRole();
        List<Order> orders = orderDao.findAllDoneOrdersByExpert(expert, OrderStatus.PAID);
        if(orders.isEmpty())
            throw new NotFoundException("there is no done service by " + expert.getEmail());
        return getFilterOrders(email, completedOrderList, role, orders);
    }

    private List<PerformedServicesDto> getFilterOrders(String email, List<PerformedServicesDto> completedOrderList, Role role, List<Order> orders) {
        for (Order order: orders) {
            String subCatTitle = order.getSubCategory().getTitle();
            String categoryTitle = order.getSubCategory().getCategory().getTitle();
            Date completionDate = order.getProposedDateToDo();
            String orderCode = order.getTrackingCode();
            Optional<Offer> foundOffer = offerDao.findByOrder(order);
            if(foundOffer.isEmpty())
                throw new NotFoundException("there is no offer for order " + order.getTrackingCode());
            Offer offer = foundOffer.get();
            Double charge = offer.getProposedPrice();
            PerformedServicesDto completedOrder = PerformedServicesDto.builder()
                    .categoryTitle(categoryTitle)
                    .subCatTitle(subCatTitle)
                    .email(email)
                    .role(role)
                    .orderCode(orderCode)
                    .completionDate(completionDate)
                    .charge(charge)
                    .build();
            completedOrderList.add(completedOrder);
        }
        return completedOrderList;
    }

    @Override
    public List<OrderDto> filterOrders(OrderFilterDto orderFilterDto) {
        Sort sort = Sort.by("proposedDateToDo").descending();
        Pageable pageable = PageRequest.of(orderFilterDto.getPageNumber(), orderFilterDto.getPageSize(), sort);
        Specification<Order> specification = OrderSpecifications.filterOrders(orderFilterDto);
        return orderDao
                .findAll(specification, pageable)
                .stream()
                .map(orderMapper::toOrderDto)
                .collect(Collectors.toList());
    }
}
