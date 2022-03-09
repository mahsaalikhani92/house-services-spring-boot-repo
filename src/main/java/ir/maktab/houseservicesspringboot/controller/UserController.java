package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.config.LastViewInterceptor;
import ir.maktab.houseservicesspringboot.exception.NotFoundException;
import ir.maktab.houseservicesspringboot.model.dto.UserDto;
import ir.maktab.houseservicesspringboot.model.dto.UserFilterDto;
import ir.maktab.houseservicesspringboot.model.dto.UserSignInDto;
import ir.maktab.houseservicesspringboot.model.entity.User;
import ir.maktab.houseservicesspringboot.model.enumaration.Role;
import ir.maktab.houseservicesspringboot.service.UserService;
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
public class UserController {
    private final UserService userService;

    @GetMapping("/showLogin")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login", "UserSignInDto", new UserSignInDto());
    }

    /*@PostMapping("/signIn")
    public String signInUser(@ModelAttribute("UserSignInDto") @Validated UserSignInDto userSignInDto) {
       User foundUser = userService.signIn(userSignInDto);
        if(foundUser.getRole().equals(Role.EXPERT)){
            return "redirect:/showExpertPage";
        }
        else {
            return "redirect:/showClientPage";
        }
    }*/

    @PostMapping("/successLogin")
    public String signInUser(@ModelAttribute("UserSignInDto") @Validated UserSignInDto userSignInDto) {
        return "successLogin";
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ModelAndView signInExceptionHandler(NotFoundException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("user", new UserSignInDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("login", model);
    }
}
