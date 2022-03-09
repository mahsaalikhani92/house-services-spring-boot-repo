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
public class ExpertDto {
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
    @Size(max = 300*1024, message = "The personal image must be utmost 300KB!")
    private byte[] imageData;
    private Double meanRate;
}
