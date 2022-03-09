package ir.maktab.houseservicesspringboot.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
public class BaseDto {
    private int pageNumber = 0;
    private int pageSize = 10;
}
