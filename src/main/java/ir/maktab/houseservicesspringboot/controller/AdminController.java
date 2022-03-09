package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.config.LastViewInterceptor;
import ir.maktab.houseservicesspringboot.model.dto.UserDto;
import ir.maktab.houseservicesspringboot.model.dto.UserFilterDto;
import ir.maktab.houseservicesspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @GetMapping("/showAdmintPage")
    public String showClientPage() {
        return "adminPanelHome";
    }

    @PostMapping("/searchUsers")
    public ModelAndView searchUsers(@ModelAttribute("userDto") UserFilterDto userFilterDto){
        List<UserDto> userDtoList = userService.getUsersByFilter(userFilterDto);
        return new ModelAndView("userListAjax", "userList", userDtoList);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }
}
