package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.config.LastViewInterceptor;
import ir.maktab.houseservicesspringboot.exception.ProposedPriceException;
import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
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
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orderForm")
    public ModelAndView showOrderForm(){
        return new ModelAndView("orders", "order", new OrderDto());
    }

    @PostMapping("/saveOrder")
    public ModelAndView saveNewOrder(@ModelAttribute("order") @Validated OrderDto orderDto,
                               @RequestParam String subCategoryTitle, @AuthenticationPrincipal ClientDto clientDto){
        String trackingCode = orderService.addOrder(orderDto, subCategoryTitle, clientDto);
        return new ModelAndView("orders", "trackingCode", trackingCode);
    }

    @GetMapping("/waitingOrderList")
    public ModelAndView showWaitingOrderList(@AuthenticationPrincipal ExpertDto expertDto){
        List<String> ordersTrackingCodeList = orderService.getOrderTrackingCodeByExpert(expertDto);
        return new ModelAndView("expertWorkManagement", "ordersTrackingCodeList", ordersTrackingCodeList);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = ProposedPriceException.class)
    public ModelAndView orderExceptionHandler(ProposedPriceException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("order", new OrderDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("orders", model);
    }
}
