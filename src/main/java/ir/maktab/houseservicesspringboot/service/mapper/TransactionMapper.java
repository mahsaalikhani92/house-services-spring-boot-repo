package ir.maktab.houseservicesspringboot.service.mapper;

import ir.maktab.houseservicesspringboot.model.dto.TransactionDto;
import ir.maktab.houseservicesspringboot.model.entity.Transaction;
import org.springframework.stereotype.Component;

/**
 * @author Mahsa Alikhani m-58
 */
@Component
public class TransactionMapper {

    public Transaction toTransaction(TransactionDto transactionDto){
        Transaction transaction = new Transaction();
        transaction.setTransactionType(transactionDto.getTransactionType());
        transaction.setClient(transactionDto.getClient());
        transaction.setExpert(transactionDto.getExpert());
        transaction.setOrderCode(transactionDto.getOrderCode());
        transaction.setOriginCardNumber(transactionDto.getOriginCardNumber());
        return transaction;
    }

    public TransactionDto toTransactionDto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setTransactionType(transaction.getTransactionType());
        transactionDto.setClient(transaction.getClient());
        transactionDto.setExpert(transaction.getExpert());
        transactionDto.setOrderCode(transaction.getOrderCode());
        transactionDto.setOriginCardNumber(transaction.getOriginCardNumber());
        return transactionDto;
    }
}
