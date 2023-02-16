package nl.bankcase.repository.transaction;

import nl.bankcase.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTransactionRepo implements TransactionRepo {
    private Map<String, Transaction> transactionMap = new HashMap<>();
    private static InMemoryTransactionRepo instance = new InMemoryTransactionRepo();

    public static InMemoryTransactionRepo getInstance() {
        return instance;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionMap.put(transaction.getId(), transaction);
    }

    @Override
    public List<Transaction> listTransactions() {
        return new ArrayList<>(transactionMap.values());
    }

    @Override
    public Transaction getTransactionById(String id) {
        return transactionMap.get(id);
    }

    @Override
    public Transaction getTransaction(Transaction transaction) {
        return transactionMap.get(transaction.getId());
    }

    @Override
    public void deleteTransactionById(String id) {
        transactionMap.remove(id);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        transactionMap.remove(transaction.getId());
    }
}
