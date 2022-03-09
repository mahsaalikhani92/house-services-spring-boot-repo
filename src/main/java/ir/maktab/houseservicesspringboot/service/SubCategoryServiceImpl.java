package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.CategoryDao;
import ir.maktab.houseservicesspringboot.dao.ExpertDao;
import ir.maktab.houseservicesspringboot.dao.SubCategoryDao;
import ir.maktab.houseservicesspringboot.exception.DuplicateException;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.exception.UserStatusException;
import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.SubCategoryDto;
import ir.maktab.houseservicesspringboot.model.entity.Category;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;
import ir.maktab.houseservicesspringboot.model.enumaration.UserStatus;
import ir.maktab.houseservicesspringboot.service.mapper.SubCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService{
    private final SubCategoryDao subCategoryDao;
    private final CategoryDao categoryDao;
    private final ExpertDao expertDao;
    private final SubCategoryMapper subCategoryMapper;

    @Override
    public void add(String categoryTitle, SubCategoryDto subCategoryDto){
        SubCategory subCategory = subCategoryMapper.toSubCategory(subCategoryDto);
        Optional<Category> foundCategory = categoryDao.findByTitle(categoryTitle);
        if(foundCategory.isEmpty())
            throw new NotFoundException("Category not found!");
        Optional<SubCategory> foundSubCategory = subCategoryDao.findByTitle(subCategory.getTitle());
        if(foundSubCategory.isPresent())
            throw new DuplicateException("Duplicate sub category!");
        Category category = foundCategory.get();
        List<SubCategory> subCategories = category.getSubCategories();
        if(subCategories == null)
            subCategories = new ArrayList<>();
        subCategories.add(subCategory);
        category.setSubCategories(subCategories);
        categoryDao.save(category);
    }

    @Override
    public List<SubCategoryDto> getAllSubCategories(){
        List<SubCategory> subCategories = subCategoryDao.findAll();
        if(subCategories.isEmpty())
            throw new NotFoundException("there is no sub category!");
        return subCategories.stream().map(subCategoryMapper::toSubCategoryDto).collect(Collectors.toList());
    }

    @Override
    public List<SubCategoryDto> getCustomSubCategories(String categoryTitle) {
        Optional<Category> foundCategory = categoryDao.findByTitle(categoryTitle);
        Category category = foundCategory.get();
        List<SubCategory> subCategories = subCategoryDao.findSubCategoriesByCategory(category);
        if(subCategories.isEmpty())
            throw new NotFoundException("there is no sub category!");
        return subCategories.stream().map(subCategoryMapper::toSubCategoryDto).collect(Collectors.toList());
    }

    @Override
    public void update(Category category, SubCategory subCategory){
        checkExistenceOfCategoryAndSubCategory(category.getTitle(), subCategory.getTitle());
        List<SubCategory> subCategories = category.getSubCategories();
        subCategories.add(subCategory);
        category.setSubCategories(subCategories);
        categoryDao.save(category);
    }

    @Override
    public void remove(Category category, SubCategory subCategory){
        checkExistenceOfCategoryAndSubCategory(category.getTitle(), subCategory.getTitle());
        List<SubCategory> subCategories = category.getSubCategories();
        subCategories.remove(subCategory);
        category.setSubCategories(subCategories);
        categoryDao.save(category);
    }

    private SubCategory checkExistenceOfCategoryAndSubCategory(String categoryTitle, String subCategoryTitle) {
        Optional<Category> foundCategory = categoryDao.findByTitle(categoryTitle);
        if(foundCategory.isEmpty())
            throw new NotFoundException("Category not found!");
        Optional<SubCategory> foundSubCategory = subCategoryDao.findByTitle(subCategoryTitle);
        if(foundSubCategory.isEmpty())
            throw new NotFoundException("Sub category not found!");
        return foundSubCategory.get();
    }

    @Override
    public void addExpertToSubCategory(String subCategoryTitle, ExpertDto expertDto){
        Optional<SubCategory> foundSubCategory = subCategoryDao.findByTitle(subCategoryTitle);
        if(foundSubCategory.isEmpty())
            throw new NotFoundException("Sub category not found!");
        SubCategory subCategory = foundSubCategory.get();
        Optional<Expert> foundExpert = expertDao.findByEmail(expertDto.getEmail());
        if (foundExpert.isEmpty())
            throw new NotFoundException("Expert not found!");
        Expert expert = foundExpert.get();
        if(!(expert.getUserStatus().equals(UserStatus.CONFIRMED)))
            throw new UserStatusException("The expert not confirmed!");
        List<Expert> experts = subCategory.getExperts();
        experts.add(expert);
        subCategory.setExperts(experts);
        subCategoryDao.save(subCategory);
    }

    @Override
    public void removeExpertFromSubCategory(Category category, SubCategory subCategory, Expert expert){
        checkExistenceOfCategoryAndSubCategory(category.getTitle(), subCategory.getTitle());
        List<Expert> experts = subCategory.getExperts();
        experts.remove(expert);
        subCategory.setExperts(experts);
        subCategoryDao.save(subCategory);
    }
}
