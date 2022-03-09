package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.config.LastViewInterceptor;
import ir.maktab.houseservicesspringboot.dao.ClientDao;
import ir.maktab.houseservicesspringboot.exception.DuplicateException;
import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.OfferDto;
import ir.maktab.houseservicesspringboot.model.dto.OrderDto;
import ir.maktab.houseservicesspringboot.model.dto.TransactionDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.service.ClientService;
import ir.maktab.houseservicesspringboot.service.OrderService;
import ir.maktab.houseservicesspringboot.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Mahsa Alikhani m-58
 */
@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final TransactionService transactionService;
    private final OrderService orderService;
    private final ClientDao clientDao;

    @GetMapping("/showClientForm")
    public ModelAndView showClientForm() {
        return new ModelAndView("clientSignUp", "client", new ClientDto());
    }

    /*@PostMapping("/clientSignUp")
    public String signUp(@ModelAttribute("client") @Validated ClientDto clientDto, HttpSession session){
        clientService.add(clientDto);
        session.setAttribute("user",clientDto);
        return "redirect:/showClientPage";
    }*/

    @PostMapping("/clientSignUp")
    public String processSignUp(@ModelAttribute("client") @Validated ClientDto clientDto, HttpServletRequest request) {
        try {
            clientService.add(clientDto, getSiteURL(request));
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "signUpSuccess";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verifyClient")
    public String verifyClient(@Param("code") String code) {
        if (clientService.verifyClient(code)) {
            return "verifySuccess";
        } else {
            return "verifyFail";
        }
    }

    /*@GetMapping("/showClientPage")
    public String showClientPage(Principal principal, Model model) {
        Optional<Client> byEmail = clientDao.findByEmail(principal.getName());
        model.addAttribute("credit", byEmail.get().getCredit());
        return "clientPanelHome";
    }*/

    @GetMapping("/showClientPage")
    public String showClientPage() {
        return "clientPanelHome";
    }

    @GetMapping("/orderOffers")
    public ModelAndView showOrderOffers(@RequestParam("orderCode") String orderTrackingCode) {
        List<OfferDto> orderOfferList = clientService.getClientOrderOffersOrderByProposedPriceAndExpertRate(orderTrackingCode);
        return new ModelAndView("orderOfferList", "orderOfferList", orderOfferList);
    }

    @GetMapping("/clientCredit")
    public ModelAndView showClientCredit(@AuthenticationPrincipal ClientDto clientDto) {
        Double credit = clientService.getClientCreditByEmail(clientDto);
        return new ModelAndView("client", "credit", credit);
    }

    @GetMapping("/payment")
    public String showPaymentPage(){
        return "payment";
    }

    @GetMapping("/creditPayment")
    public ModelAndView paymentUsingCredit(@AuthenticationPrincipal ClientDto clientDto,
                                           @RequestParam String code, @RequestParam String charge) {
        clientService.payUsingCredit(clientDto, code, Double.parseDouble(charge));
        String message = "Payment was successfully.";
        return new ModelAndView("payment", "message", message);
    }

    @GetMapping("/showOnlinePaymentForm")
    public ModelAndView showOnlinePaymentForm() {
        return new ModelAndView("onlinePayment", "transaction", new TransactionDto());
    }

    @GetMapping("/onlinePayment")
    public String paymentOnline(@ModelAttribute("transaction") TransactionDto transactionDto,
                                @AuthenticationPrincipal ClientDto clientDto) {
        transactionService.addNewTransaction(transactionDto, clientDto);
        return "payment";
    }

    @GetMapping("/clientOrderList")
    public ModelAndView showOrderList(@AuthenticationPrincipal ClientDto clientDto){
        List<OrderDto> orderList = orderService.getOrdersByClientEmail(clientDto);
        return new ModelAndView("orderList", "orderList", orderList);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = DuplicateException.class)
    public ModelAndView clientSignUpExceptionHandler(DuplicateException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("client", new ClientDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("clientSignUp", model);
    }
}
