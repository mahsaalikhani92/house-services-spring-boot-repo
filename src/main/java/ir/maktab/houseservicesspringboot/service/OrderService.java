package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.model.entity.Order;

import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface OrderService {

    String addOrder(OrderDto orderDto, String subCategoryTitle, ClientDto clientDto);

    void removeOrder(Order order);

    void update(Order order);

    List<OrderDto> getAllOrders(ClientDto clientDto);

    List<OrderDto> getOrdersByExpertEmail(ExpertDto expertDto);

    List<OrderDto> getOrdersByClientEmail(ClientDto clientDto);

    void updateOrderStatusToStart(String code);

    void updateOrderStatusToDone(String code);

    List<String> getOrderTrackingCodeByExpert(ExpertDto expertDto);
}
