package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.ClientDao;
import ir.maktab.houseservicesspringboot.dao.OrderDao;
import ir.maktab.houseservicesspringboot.dao.SubCategoryDao;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.exception.ProposedPriceException;
import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;
import ir.maktab.houseservicesspringboot.model.enumaration.OrderStatus;
import ir.maktab.houseservicesspringboot.service.mapper.ExpertMapper;
import ir.maktab.houseservicesspringboot.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderDao orderDao;
    private final ClientDao clientDao;
    private final SubCategoryDao subCategoryDao;
    private final OrderMapper orderMapper;
    private final ExpertMapper expertMapper;

    @Override
    public String addOrder(OrderDto orderDto, String subCategoryTitle, ClientDto clientDto){
        Order order = orderMapper.toOrder(orderDto);
        if(order.getProposedPrice() < order.getSubCategory().getBasePrice())
            throw new ProposedPriceException("the proposed price is less than base price!");
        order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_OFFER);
        Optional<Client> client = clientDao.findByEmail(clientDto.getEmail());
        order.setClient(client.get());
        Optional<SubCategory> subCategory = subCategoryDao.findByTitle(subCategoryTitle);
        order.setSubCategory(subCategory.get());
        String uuid = UUID.randomUUID().toString();
        order.setTrackingCode(uuid);
        Order registeredOrder =  orderDao.save(order);
        return registeredOrder.getTrackingCode();
    }

    @Override
    public void removeOrder(Order order){
        Optional<Order> foundOrder = orderDao.findById(order.getId());
        if(foundOrder.isEmpty())
            throw new NotFoundException("order not found!");
        orderDao.delete(order);
    }

    @Override
    public void update(Order order){
        Optional<Order> foundOrder = orderDao.findById(order.getId());
        if(foundOrder.isEmpty())
            throw new NotFoundException("order not found!");
        orderDao.save(order);
    }

    @Override
    public List<OrderDto> getAllOrders(ClientDto clientDto){
        List<Order> orders = orderDao.findAll();
        if(orders.isEmpty())
            throw new NotFoundException("there is no order!");
        return orders.stream().map(orderMapper::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByExpertEmail(ExpertDto expertDto) {
        List<Order> orders = orderDao.findAllByExpert_Email(expertDto.getEmail());
        return orders.stream().map(orderMapper::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByClientEmail(ClientDto clientDto) {
        List<Order> orders = orderDao.findAllByClient_Email(clientDto.getEmail());
        return orders.stream().map(orderMapper::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public void updateOrderStatusToStart(String code) {
        Order order = orderDao.findOrdersByTrackingCode(code);
        order.setOrderStatus(OrderStatus.STARTED);
        orderDao.save(order);
    }

    @Override
    public void updateOrderStatusToDone(String code) {
        Order order = orderDao.findOrdersByTrackingCode(code);
        order.setOrderStatus(OrderStatus.DONE);
        orderDao.save(order);
    }

    @Override
    public List<String> getOrderTrackingCodeByExpert(ExpertDto expertDto) {
        Expert expert = expertMapper.toExpert(expertDto);
        List<Order> orders = orderDao.findWaitingOrdersByExpert(expert, OrderStatus.WAITING_FOR_THE_EXPERT_TO_ARRIVE_AT_LOCATION);
        List<String> orderTrackingCodes = new ArrayList<>();
        for (Order order: orders) {
            orderTrackingCodes.add(order.getTrackingCode());
        }
        return orderTrackingCodes;
    }
}
