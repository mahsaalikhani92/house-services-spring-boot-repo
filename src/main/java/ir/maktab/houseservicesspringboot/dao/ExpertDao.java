package ir.maktab.houseservicesspringboot.dao;

import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;
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
public interface ExpertDao extends JpaRepository<Expert, Long> {

    Optional<Expert> findByEmail(String email);

    @Query(value = "select e.subCategories from Expert e where e.email = :email")
    List<SubCategory> findExpertSubCategoryList(@Param("email") String email);

    @Query(value = "select e from Expert e where e.email = :email")
    Double findExpertCreditByEmail(@Param("email") String email);

    @Query("select e from Expert e WHERE e.verificationCode = ?1")
    Expert findByVerificationCode(String code);
}
