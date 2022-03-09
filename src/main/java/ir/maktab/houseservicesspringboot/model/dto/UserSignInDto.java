package ir.maktab.houseservicesspringboot.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
public class UserSignInDto {

    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email!")
    private String email;
    @NotBlank(message = "Password is required!")
    @Size(min = 8, max = 32, message = "The password must be at least 8 and utmost 32 characters!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,32}$",
            message = " The password must have at least one letter, one number and one special character!")
    private String password;
}
