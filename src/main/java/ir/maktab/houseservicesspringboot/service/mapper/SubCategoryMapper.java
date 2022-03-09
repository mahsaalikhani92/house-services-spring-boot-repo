package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.SubCategoryDto;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class SubCategoryMapper {

    public SubCategory toSubCategory(SubCategoryDto subCategoryDto){
        return SubCategory.builder()
                .title(subCategoryDto.getTitle())
                .basePrice(subCategoryDto.getBasePrice())
                .description(subCategoryDto.getDescription())
                .build();
    }

    public SubCategoryDto toSubCategoryDto(SubCategory subCategory){
        return SubCategoryDto.builder()
                .title(subCategory.getTitle())
                .basePrice(subCategory.getBasePrice())
                .description(subCategory.getDescription())
                .build();
    }
}
