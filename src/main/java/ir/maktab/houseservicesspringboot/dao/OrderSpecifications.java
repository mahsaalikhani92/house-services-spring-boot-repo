package ir.maktab.houseservicesspringboot.dao;

import ir.maktab.houseservicesspringboot.model.dto.OrderFilterDto;
import ir.maktab.houseservicesspringboot.model.entity.Category;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface OrderSpecifications {

    static Specification<Order> filterOrders(OrderFilterDto orderFilterDto){
        return (root, criteriaQuery, criteriaBuilder) -> {
            CriteriaQuery<Order> resultCriteria = criteriaBuilder.createQuery(Order.class);
            List<Predicate> predicates = new ArrayList<>();
            if(orderFilterDto.getCategoryTitle() != null){
                Join<Order, SubCategory> orderSubCategoryJoin = root.join("subCategory");
                Join<SubCategory, Category> subCategoryCategoryJoin = orderSubCategoryJoin.join("category");
                predicates.add(criteriaBuilder.equal(subCategoryCategoryJoin.get("title"), orderFilterDto.getCategoryTitle()));
            }
            if(orderFilterDto.getSubCategoryTitle() != null){
                Join<Order, SubCategory> orderSubCategoryJoin = root.join("subCategory");
                predicates.add(criteriaBuilder.equal(orderSubCategoryJoin.get("title"), orderFilterDto.getCategoryTitle()));
            }
            if(orderFilterDto.getFrom() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("proposedDateToDo"), orderFilterDto.getOrderStatus()));
            }
            if(orderFilterDto.getTo() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("proposedDateToDo"), orderFilterDto.getTo()));
            }
            if(orderFilterDto.getOrderStatus() != null){
                predicates.add(criteriaBuilder.equal(root.get("orderStatus"), orderFilterDto.getOrderStatus()));
            }
            resultCriteria.select(root).where(predicates.toArray(new Predicate[0]));
            return resultCriteria.getRestriction();
        };
    }
}
