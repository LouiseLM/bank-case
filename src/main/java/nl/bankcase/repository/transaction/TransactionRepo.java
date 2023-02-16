package nl.bankcase.repository.transaction;

import nl.bankcase.model.Transaction;

import java.util.List;

public interface TransactionRepo {
    void saveTransaction(Transaction transaction);
    List<Transaction> listTransactions();
    Transaction getTransactionById(String id);
    Transaction getTransaction(Transaction transaction);
    void deleteTransactionById(String id);
    void deleteTransaction(Transaction transaction);
}
