package ir.maktab.houseservicesspringboot.model.dto;

import ir.maktab.houseservicesspringboot.model.enumaration.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
public class OrderFilterDto extends BaseDto{
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date to;
    private OrderStatus orderStatus;
    private String categoryTitle;
    private String subCategoryTitle;

}
