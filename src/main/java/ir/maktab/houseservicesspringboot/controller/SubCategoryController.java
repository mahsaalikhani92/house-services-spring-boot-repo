package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.config.LastViewInterceptor;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.model.dto.CategoryDto;
import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.SubCategoryDto;
import ir.maktab.houseservicesspringboot.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mahsa Alikhani m-58
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/subCategory")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;

    @GetMapping
    public ModelAndView showSubCategoryPage(){
        return new ModelAndView("subCategory", "subCategory", new SubCategoryDto());
    }

    @PostMapping("/add")
    public String saveNewSubCategory(@ModelAttribute("subCategory") @Validated SubCategoryDto subCategoryDto,
                                     @RequestParam String categoryTitle){
        subCategoryService.add(categoryTitle, subCategoryDto);
        return "subCategory";
    }

    @GetMapping("/list")
    public ModelAndView showSubCategoryList(){
        List<SubCategoryDto> subCategoryList = subCategoryService.getAllSubCategories();
        return new ModelAndView("subCategoryList", "subCategoryList", subCategoryList);
    }

    /*@GetMapping("/customList")
    public ModelAndView showCustomSubCategoryList(@RequestParam String categoryTitle, @SessionAttribute("categoryList") List<CategoryDto> categoryList,
                                                  HttpServletRequest request){
        List<SubCategoryDto> customSubCategoryList = subCategoryService.getCustomSubCategories(categoryTitle);
        request.getSession(false).setAttribute("cs", customSubCategoryList);
        Map<String, Object> map = new HashMap<>();
        map.put("cs", customSubCategoryList);
        map.put("categoryList", new ArrayList<CategoryDto>());
        ModelAndView modelAndView = new ModelAndView("categoryList");
        modelAndView.getModel().putAll(map);
        return modelAndView;
    }*/

    @GetMapping("/customList")
    public @ResponseBody String showCustomSubCategoryList(@RequestParam String categoryTitle, Model model){
        List<SubCategoryDto> customSubCategoryList = subCategoryService.getCustomSubCategories(categoryTitle);
        //*Map<String, Object> map = new HashMap<>();
        //map.put("cs", customSubCategoryList);*//*
        model.addAttribute("cs", customSubCategoryList);
        //model.mergeAttributes(map);
        return "categoryList";
    }
/*
    @GetMapping("/customList")
    public ModelAndView showCustomSubCategoryList(@RequestParam String categoryTitle, ModelMap modelMap){
        List<SubCategoryDto> customSubCategoryList = subCategoryService.getCustomSubCategories(categoryTitle);
        //Map<String, List<SubCategoryDto>> map = new HashMap<>();
        modelMap.put("customSubCategoryList", customSubCategoryList);
        return new ModelAndView("categoryList", modelMap);
    }*/

    @PostMapping("/addExpert")
    public String saveExpertInSubCategory(@RequestParam String subCategoryTitle, @AuthenticationPrincipal ExpertDto expertDto){
        subCategoryService.addExpertToSubCategory(subCategoryTitle, expertDto);
        return "redirect:/expert";
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ModelAndView categoryAddExceptionHandler(NotFoundException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("category", new CategoryDto());
        model.put("subCategory", new SubCategoryDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("subCategory", model);
    }
}
