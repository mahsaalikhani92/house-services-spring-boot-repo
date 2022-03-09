package ir.maktab.houseservicesspringboot.dao;

import ir.maktab.houseservicesspringboot.model.entity.Category;
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
public interface SubCategoryDao extends JpaRepository<SubCategory, Integer> {

    Optional<SubCategory> findByTitle(String title);

    @Query(value = "select s from SubCategory s where s.category = :category")
    List<SubCategory> findSubCategoriesByCategory(@Param("category") Category category);

    Double findSubCategoryById(int id);
}
