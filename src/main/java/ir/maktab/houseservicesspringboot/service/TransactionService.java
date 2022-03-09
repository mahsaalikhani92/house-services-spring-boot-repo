package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.TransactionDto;

/**
 * @author Mahsa Alikhani m-58
 */
public interface TransactionService {

    void addNewTransaction(TransactionDto transactionDto, ClientDto clientDto);
}
