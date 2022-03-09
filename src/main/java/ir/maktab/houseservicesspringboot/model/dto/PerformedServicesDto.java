package ir.maktab.houseservicesspringboot.model.dto;

import ir.maktab.houseservicesspringboot.model.enumaration.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Builder
public class PerformedServicesDto {
    private String categoryTitle;
    private String subCatTitle;
    private Role role;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date completionDate;
    private String orderCode;
    private Double charge;
}
