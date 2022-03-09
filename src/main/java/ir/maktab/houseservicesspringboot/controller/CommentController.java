package ir.maktab.houseservicesspringboot.controller;

import ir.maktab.houseservicesspringboot.config.LastViewInterceptor;
import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.CommentDto;
import ir.maktab.houseservicesspringboot.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mahsa Alikhani m-58
 */
@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/showCommentForm")
    public ModelAndView showCommentForm(){
        return new ModelAndView("addRateAndComment", "comment", new CommentDto());
    }

    @PostMapping("/addComment")
    public String saveComment(@ModelAttribute("comment") @Validated CommentDto commentDto,
                              @RequestParam String orderTrackingCode, @AuthenticationPrincipal ClientDto clientDto){
        commentService.addComment(clientDto, commentDto, orderTrackingCode);
        return "redirect:/showClientPage";
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }
}
