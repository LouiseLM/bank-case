package nl.bankcase.service.transaction;

import nl.bankcase.repository.transaction.TransactionRepo;

public class TransactionServiceImpl implements TransactionService{
    private TransactionRepo transactionRepo;

    public TransactionServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }
}
