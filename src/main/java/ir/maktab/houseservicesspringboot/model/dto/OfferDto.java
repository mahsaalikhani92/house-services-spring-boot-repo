package ir.maktab.houseservicesspringboot.model.dto;

import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private Date offerSubmissionDate;
    @NotBlank(message = "Proposed price is required!")
    private Double proposedPrice;
    @NotBlank(message = "Work duration is required!")
    private String workDuration;
    @NotBlank(message = "Start time is required!")
    @DateTimeFormat(pattern = "HH-mm")
    @NotNull(message = "Start time is required!")
    private Date startTime;
    private Order order;
    private Expert expert;
}
