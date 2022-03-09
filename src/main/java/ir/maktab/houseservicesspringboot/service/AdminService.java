package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderFilterDto;
import ir.maktab.houseservicesspringboot.model.dto.PerformedServicesDto;

import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface AdminService {

    List<PerformedServicesDto> getAllReceivedClientOrders(String email);

    List<PerformedServicesDto> getAllDoneOrdersByExpert(String email);

    List<OrderDto> filterOrders(OrderFilterDto orderFilterDto);
}
