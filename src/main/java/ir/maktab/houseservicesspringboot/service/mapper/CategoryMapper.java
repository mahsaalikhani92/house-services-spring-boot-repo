package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.CategoryDto;
import ir.maktab.houseservicesspringboot.model.entity.Category;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class CategoryMapper {

    public Category toCategory(CategoryDto categoryDto){
        return Category.builder()
                .title(categoryDto.getTitle())
                .build();
    }

    public CategoryDto toCategoryDto(Category category){
        return CategoryDto.builder()
                .title(category.getTitle())
                .build();
    }
}
