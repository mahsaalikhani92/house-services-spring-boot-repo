package ir.maktab.houseservicesspringboot.dao;

import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.enumaration.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
@Repository
public interface OrderDao extends JpaRepository<Order,Long>, JpaSpecificationExecutor<Order> {

    List<Order> findAllByExpert_Email(String email);

    List<Order> findAllByClient_Email(String email);

    List<Order> findOrdersBySubCategoryTitle(String title);

    Order findOrdersByTrackingCode(String code);

    Order findOrdersByExpertEmail(String email);

    @Query(value = "select o from Order o where o.expert = :expert and o.orderStatus = :orderStatus")
    List<Order> findWaitingOrdersByExpert(@Param("expert") Expert expert, @Param("orderStatus") OrderStatus orderStatus);

    @Query(value = "select o from Order o where o.client = :client and o.orderStatus = :orderStatus")
    List<Order> findAllReceivedOrdersByClient(@Param("client") Client client, @Param("orderStatus") OrderStatus orderStatus);

    @Query(value = "select o from Order o where o.expert = :expert and o.orderStatus = :orderStatus")
    List<Order> findAllDoneOrdersByExpert(@Param("expert") Expert expert, @Param("orderStatus") OrderStatus orderStatus);

    @Query(value = "select o from Order o where o.trackingCode = :code")
    Order findOrderByOrderTrackingCode(@Param(("code")) String code);

}
