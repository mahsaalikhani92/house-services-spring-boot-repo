package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.model.dto.ExpertDto;
import ir.maktab.houseservicesspringboot.model.dto.OfferDto;
import ir.maktab.houseservicesspringboot.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Mahsa Alikhani m-58
 */
@Controller
@RequiredArgsConstructor

public class OfferController {
    private final OfferService offerService;

    @GetMapping("/offerForm")
    public ModelAndView showOfferForm(){
        return new ModelAndView("offer", "offer", new OfferDto());
    }

    @PostMapping("/saveOffer")
    public ModelAndView saveNewOffer(@ModelAttribute("offer") @Validated OfferDto offerDto,
                               @RequestParam String trackingCode, @AuthenticationPrincipal ExpertDto expertDto){
        String orderTrCode = offerService.addOffer(offerDto, trackingCode, expertDto);
        return new ModelAndView("offer", "orderTrCode", orderTrCode);
    }
}
