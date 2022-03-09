package ir.maktab.houseservicesspringboot.dao;

import ir.maktab.houseservicesspringboot.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mahsa Alikhani m-58
 */
@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    @Query(value = "select c from Client c where c.email = :email")
    Double findClientCreditByEmail(@Param("email") String email);

    @Query("select c from Client c WHERE c.verificationCode = ?1")
    Client findByVerificationCode(String code);

}
