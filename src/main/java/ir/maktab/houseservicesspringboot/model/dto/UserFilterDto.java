package ir.maktab.houseservicesspringboot.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
public class UserFilterDto extends BaseDto{

    @Pattern(regexp = "[a-zA-Z]+", message = "The name must be consist of letters!")
    private String name;
    @Pattern(regexp = "[a-zA-Z]+", message = "The last name must be consist of letters!")
    private String lastName;
    @Email(message = "Invalid email!")
    private String email;
    @Pattern(regexp = "CLIENT|EXPERT|client|expert", message = "Role: client or expert")
    private String role;
    @Pattern(regexp = "[a-zA-Z]+", message = "The speciality must be consist of letters!")
    private String speciality;
    private Double rate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;
    private Integer orderNumber;
    private Integer doneOrderNumber;
}
