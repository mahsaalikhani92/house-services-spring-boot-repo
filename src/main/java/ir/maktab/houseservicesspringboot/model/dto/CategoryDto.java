package ir.maktab.houseservicesspringboot.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    @NotBlank(message = "Category title is required")
    @Pattern(regexp = "[a-zA-Z]+", message = "The title must be consist of letters!")
    private String title;
}
