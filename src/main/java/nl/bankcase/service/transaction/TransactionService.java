package nl.bankcase.service.transaction;

import nl.bankcase.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    Transaction newWithdrawal(String iban, BigDecimal amount);
    Transaction newDeposit (String iban, BigDecimal amount);
    List<Transaction> listTransactions(String iban);
    Transaction getTransactionById(Long id);
    void delete(Transaction transaction);
}
