package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.config.LastViewInterceptor;
import ir.maktab.houseservicesspringboot.exception.DuplicateException;
import ir.maktab.houseservicesspringboot.model.dto.CategoryDto;
import ir.maktab.houseservicesspringboot.service.CategoryService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/categories")
@SessionAttributes("categoryList")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ModelAndView showCategoryPage(){
        return new ModelAndView("category", "category", new CategoryDto());
    }

    @PostMapping("/add")
    public String saveNewCategory(@ModelAttribute("category") @Validated CategoryDto categoryDto){
        categoryService.add(categoryDto);
        return "category";
    }

    @GetMapping("/list")
    public String showCategoryList(Model model){
        List<CategoryDto> categoryList = categoryService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "categoryAndSubCategoryList";
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = DuplicateException.class)
    public ModelAndView categoryAddExceptionHandler(DuplicateException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("category", new CategoryDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("category", model);
    }

}
