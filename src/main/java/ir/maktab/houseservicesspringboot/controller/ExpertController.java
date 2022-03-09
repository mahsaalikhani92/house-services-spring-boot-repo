package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.config.LastViewInterceptor;
import ir.maktab.houseservicesspringboot.exception.DuplicateException;
import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.service.ExpertService;
import ir.maktab.houseservicesspringboot.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mahsa Alikhani m-58
 */
@Controller
@RequiredArgsConstructor
public class ExpertController {
    private final ExpertService expertService;
    private final OrderService orderService;

    @GetMapping("/showExpertForm")
    public ModelAndView showExpertForm(){
        return new ModelAndView("expertSignUp", "expert", new ExpertDto());
    }

    @GetMapping("/showExpertPage")
    public String showExpertPage(){
        return "/expertPanelHome";
    }

    /*@PostMapping("/expertSignUp")
    public String signUp(@ModelAttribute("expert") @Validated ExpertDto expertDto,
                         @RequestParam("personalImage") MultipartFile personalImage, HttpSession session){
        try {
            expertDto.setImageData(personalImage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        expertService.add(expertDto);
        session.setAttribute("user",expertDto);
        return "redirect:/showExpertPage";
    }*/

    @PostMapping("/expertSignUp")
    public String processSignUp(@ModelAttribute("expert") @Validated ExpertDto expertDto,
                                @RequestParam("personalImage") MultipartFile personalImage,
                                HttpServletRequest request) {
        try {
            expertDto.setImageData(personalImage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            expertService.add(expertDto, getSiteURL(request));
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "signUpSuccess";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verifyExpert")
    public String verifyExpert(@Param("code") String code) {
        if (expertService.verifyExpert(code)) {
            return "verifySuccess";
        } else {
            return "verifyFail";
        }
    }

    @GetMapping("/expertOrders")
    public ModelAndView showExpertSubCategoryOrders(@AuthenticationPrincipal ExpertDto expertDto){
        Map<String, List<OrderDto>> subCategoryOrderMap = expertService.getExpertSubCategoryOrdersList(expertDto);
        return new ModelAndView("expertOrders", "subCategoryOrderMap", subCategoryOrderMap);
    }

    @GetMapping("/expertCredit")
    public ModelAndView showExpertCredit(@AuthenticationPrincipal ExpertDto expertDto){
        Double credit = expertService.getExpertCreditByEmail(expertDto);
        return new ModelAndView("expertPanelHome", "credit", credit);
    }

    @GetMapping("/expertOrderList")
    public ModelAndView showOrderList(@AuthenticationPrincipal ExpertDto expertDto){
        List<OrderDto> orderList = orderService.getOrdersByExpertEmail(expertDto);
        return new ModelAndView("orderList", "orderList", orderList);
    }

    @GetMapping("/startOrder")
    public String startOrder(@RequestParam String trackingCode){
        orderService.updateOrderStatusToStart(trackingCode);
        return "expertWorkManagement";
    }

    @GetMapping("/doneOrder")
    public String doneOrder(@RequestParam String trackingCode){
        orderService.updateOrderStatusToDone(trackingCode);
        return "expertWorkManagement";
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = DuplicateException.class)
    public ModelAndView expertSignUpExceptionHandler(DuplicateException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("expert", new ExpertDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("expertSignUp", model);
    }
}
