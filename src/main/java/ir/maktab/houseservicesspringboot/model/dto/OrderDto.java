package ir.maktab.houseservicesspringboot.model.dto;

import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Offer;
import ir.maktab.houseservicesspringboot.model.entity.SubCategory;
import ir.maktab.houseservicesspringboot.model.enumaration.OrderStatus;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    @NotNull(message = "Proposed price is required!")
    private Double proposedPrice;
    @NotBlank(message = "Description is required!")
    private String description;
    private Date orderPlacingDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Proposed date is required!")
    private Date proposedDateToDo;
    @NotBlank(message = "Address is required!")
    private String address;
    private String trackingCode;
    private OrderStatus orderStatus;
    private Client client;
    private Expert expert;
    private SubCategory subCategory;
    private List<Offer> offers;
}
