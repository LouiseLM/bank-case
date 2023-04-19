package nl.bankcase.repository.transaction;

import nl.bankcase.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JPATransactionRepo extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllByAccountIban(String iban);
}
