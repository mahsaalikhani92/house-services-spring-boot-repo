package ir.maktab.houseservicesspringboot.model.dto;

import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    @NotNull(message = "rate is required!")
    private Double rate;
    private String comment;
    private Client client;
    private Expert expert;
}
