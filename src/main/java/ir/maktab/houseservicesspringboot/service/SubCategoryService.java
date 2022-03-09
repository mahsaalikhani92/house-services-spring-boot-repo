package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.SubCategoryDto;
import ir.maktab.houseservicesspringboot.model.entity.Category;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;

import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface SubCategoryService {

    void add(String categoryTitle, SubCategoryDto subCategoryDto);

    List<SubCategoryDto> getAllSubCategories();

    List<SubCategoryDto> getCustomSubCategories(String categoryTitle);

    void update(Category category, SubCategory subCategory);

    void remove(Category category, SubCategory subCategory);

    void addExpertToSubCategory(String subCategoryTitle, ExpertDto expertDto);

    public void removeExpertFromSubCategory(Category category, SubCategory subCategory, Expert expert);
}
