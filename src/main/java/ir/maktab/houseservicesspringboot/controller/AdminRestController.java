package ir.maktab.houseservicesspringboot.controller;

import io.swagger.annotations.Api;
import ir.maktab.houseservicesspringboot.model.dto.*;
import ir.maktab.houseservicesspringboot.service.AdminService;
import ir.maktab.houseservicesspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
@RequestMapping("/rest")
@RestController
@RequiredArgsConstructor
public class AdminRestController {
    private final AdminService adminService;
    private final UserService userService;

    @GetMapping(value = "/clientServiceHistory/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PerformedServicesDto> showClientServices(@PathVariable String email){
        return adminService.getAllReceivedClientOrders(email);
    }

    @GetMapping(value = "/expertServiceHistory/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PerformedServicesDto> showExpertServices(@PathVariable String email){
        return adminService.getAllDoneOrdersByExpert(email);
    }

    @PostMapping(value = "/filterOrders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> showFilterOrders(@RequestBody OrderFilterDto orderFilterDto){
        return adminService.filterOrders(orderFilterDto);
    }

    @PostMapping(value = "/filterUsers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> showFilterUsers(@RequestBody UserFilterDto userFilterDto){
        return userService.getUsersByFilter(userFilterDto);
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<?> bindExceptionHandler(BindException ex) {
        List<String> validationErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            validationErrors.add(error.getField() + " : " + error.getDefaultMessage());
        });
        ApiErrorDto apiErrorDto = new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getClass().getName(), validationErrors);
        return new ResponseEntity<>(apiErrorDto, apiErrorDto.getStatus());
    }
}
