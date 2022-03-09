package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class OrderMapper {

    public Order toOrder(OrderDto orderDto){
        return Order.builder()
                .proposedPrice(orderDto.getProposedPrice())
                .description(orderDto.getDescription())
                .proposedDateToDo(orderDto.getProposedDateToDo())
                .address(orderDto.getAddress())
                .build();
    }

    public OrderDto toOrderDto(Order order){
        return OrderDto.builder()
                .trackingCode(order.getTrackingCode())
                .proposedPrice(order.getProposedPrice())
                .description(order.getDescription())
                .orderPlacingDate(order.getOrderPlacingDate())
                .proposedDateToDo(order.getProposedDateToDo())
                .address(order.getAddress())
                .orderStatus(order.getOrderStatus())
                .client(order.getClient())
                .subCategory(order.getSubCategory())
                .expert(order.getExpert())
                .offers(order.getOffers())
                .build();
    }
}
