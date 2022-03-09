package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.dao.OrderDao;
import ir.maktab.houseservicesspringboot.dao.TransactionDao;
import ir.maktab.houseservicesspringboot.model.dto.ClientDto;
import ir.maktab.houseservicesspringboot.model.dto.TransactionDto;
import ir.maktab.houseservicesspringboot.model.entity.Client;
import ir.maktab.houseservicesspringboot.model.entity.Expert;
import ir.maktab.houseservicesspringboot.model.entity.Order;
import ir.maktab.houseservicesspringboot.model.entity.Transaction;
import ir.maktab.houseservicesspringboot.model.enumaration.TransactionType;
import ir.maktab.houseservicesspringboot.service.mapper.ClientMapper;
import ir.maktab.houseservicesspringboot.service.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mahsa Alikhani m-58
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionMapper transactionMapper;
    private final TransactionDao transactionDao;
    private final OrderDao orderDao;
    private final ClientMapper clientMapper;

    @Override
    public void addNewTransaction(TransactionDto transactionDto, ClientDto clientDto) {
        Client client = clientMapper.toClient(clientDto);
        String code = transactionDto.getOrderCode();
        Order order = orderDao.findOrdersByTrackingCode(code);
        Expert expert = order.getExpert();
        Transaction transaction = transactionMapper.toTransaction(transactionDto);
        transaction.setTransactionType(TransactionType.SUCCESS);
        transaction.setClient(client);
        transaction.setExpert(expert);
        transactionDao.save(transaction);
    }
}
