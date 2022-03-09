package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.CategoryDto;

import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public interface CategoryService {

    void add(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    void update(CategoryDto categoryDto);

    void remove(CategoryDto categoryDto);

}
