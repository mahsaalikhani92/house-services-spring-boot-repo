package ir.maktab.houseservicesspringboot.dao;

import ir.maktab.houseservicesspringboot.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mahsa Alikhani m-58
 */
@Repository
public interface TransactionDao extends JpaRepository<Transaction, Long> {
}
