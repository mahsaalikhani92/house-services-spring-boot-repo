package ir.maktab.houseservicesspringboot.dao;

import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Offer;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mahsa Alikhani m-58
 */
@Repository
public interface OfferDao extends JpaRepository<Offer, Long> {

    @Query(value = "select o from Offer o where o.expert = :expert and o.order = :order")
    List<Offer> findAllOffers(@Param("expert") Expert expert, @Param("order") Order order);

    @Query(value = "select o from Offer o where o.order = :order order by o.proposedPrice desc, o.expert.meanRate desc ")
    List<Offer> findOffersByOrder(@Param("order") Order order);

    Optional<Offer> findByOrder(Order order);
}
