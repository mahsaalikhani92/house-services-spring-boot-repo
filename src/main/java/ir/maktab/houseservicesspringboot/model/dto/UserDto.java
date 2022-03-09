package ir.maktab.houseservicesspringboot.model.dto;

import ir.maktab.houseservicesspringboot.model.enumaration.Role;
import ir.maktab.houseservicesspringboot.model.enumaration.UserStatus;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "Name is required!")
    @Pattern(regexp = "[a-zA-Z]+", message = "The name must be consist of letters!")
    private String name;
    @NotBlank(message = "Last name is required!")
    @Pattern(regexp = "[a-zA-Z]+", message = "The last name must be consist of letters!")
    private String lastName;
    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email!")
    private String email;
    @NotBlank(message = "Password is required!")
    @Size(min = 8, max = 500, message = "The password must be at least 8 and utmost 32 characters!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,500}$",
            message = " The password must have at least one letter, one number and one special character!")
    private String password;
    private Date registrationDate;
    private UserStatus userStatus;
    private Role role;
}
