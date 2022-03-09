package ir.maktab.houseservicesspringboot.model.dto;

import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.enumaration.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
public class TransactionDto {
    private TransactionType transactionType;
    private Client client;
    private Expert expert;
    @NotNull(message = "Amount is required!")
    private Double amount;
    @NotBlank(message = "Card Number is required!")
    private String originCardNumber;
    @NotBlank(message = "ccv2 is required!")
    private String ccv2;
    @NotNull(message = "Expire year is required!")
    private int expireYear;
    @NotNull(message = "Expire month is required!")
    private int expireMonth;
    @NotBlank(message = "Password is required!")
    private String password;
    @NotBlank(message = "Order code is required!")
    private String orderCode;
}
