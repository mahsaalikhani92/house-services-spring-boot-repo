package ir.maktab.houseservicesspringboot.dao;

import ir.maktab.houseservicesspringboot.model.dto.UserFilterDto;
import ir.maktab.houseservicesspringboot.model.entity.*;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface UserSpecifications {

    static Specification<User> filterUsers(UserFilterDto userFilterDto) {
        return (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            CriteriaQuery<User> resultCriteria = cb.createQuery(User.class);
            if (userFilterDto.getRole() != null) {
                predicates.add(cb.equal(root.get("role"), userFilterDto.getRole()));
            }
            if (userFilterDto.getName() != null) {
                predicates.add(cb.equal(root.get("name"), userFilterDto.getName()));
            }
            if (userFilterDto.getLastName() != null) {
                predicates.add(cb.equal(root.get("lastName"), userFilterDto.getLastName()));
            }
            if (userFilterDto.getEmail() != null) {
                predicates.add(cb.equal(root.get("email"), userFilterDto.getEmail()));
            }
            if (userFilterDto.getSpeciality() != null) {
                Root<Expert> fromExperts = cq.from(Expert.class);
                Join<Expert, SubCategory> expertSubCategoryJoin = fromExperts.join("subCategories");
                Join<SubCategory, Category> subCategoryCategoryJoin = expertSubCategoryJoin.join("category");
                predicates.add(cb.equal(subCategoryCategoryJoin.get("title"), userFilterDto.getSpeciality()));
            }
            if(userFilterDto.getRate() != null){
                Root<Expert> expert = cq.from(Expert.class);
                predicates.add(cb.equal(expert.get("meanRate"), userFilterDto.getRate()));
            }
            if(userFilterDto.getRegistrationDate() != null){
                predicates.add(cb.equal(root.get("registrationDate"), userFilterDto.getRegistrationDate()));
            }
            if(userFilterDto.getOrderNumber() != null){
                Root<Client> client = cq.from(Client.class);
                Join<Client, Order> clientOrderJoin = client.join("orders");

                CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
                cqCount.select(cb.countDistinct(clientOrderJoin.get("client")));
                /*cq.groupBy(clientOrderJoin.get("client"));
                cq.select(cb.count(clientOrderJoin));*/
                //predicates.add()
            }
            if(userFilterDto.getDoneOrderNumber() != null){
                Root<Expert> expert = cq.from(Expert.class);
                Join<Order, Expert> orderExpertJoin = expert.join("expert");
                CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
                cqCount.select(cb.countDistinct(orderExpertJoin.get("expert")));
                //todo
            }
            resultCriteria.select(root).where(predicates.toArray(new Predicate[0]));
            return resultCriteria.getRestriction();
        };
    }
}
