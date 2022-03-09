package ir.maktab.houseservicesspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Mahsa Alikhani m-58
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }
}
