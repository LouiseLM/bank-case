package nl.bankcase.service.transaction;

import nl.bankcase.utils.exceptions.DoesNotExistException;
import nl.bankcase.model.Account;
import nl.bankcase.model.Transaction;
import nl.bankcase.repository.account.JPAAccountRepo;
import nl.bankcase.repository.transaction.JPATransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    private final JPATransactionRepo transactionRepo;
    private final JPAAccountRepo accountRepo;

    public TransactionServiceImpl(@Autowired JPATransactionRepo transactionRepo, JPAAccountRepo accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public Transaction newWithdrawal(String iban, BigDecimal amount, String category) {
        if (accountRepo.findById(iban).isPresent()) {
            Account account = accountRepo.findById(iban).get();
            account.withdrawal(amount);
            Transaction transaction = new Transaction(accountRepo.findById(iban).get(), amount, category);
            transactionRepo.save(transaction);
            return transaction;
        } else {
            throw new DoesNotExistException("The account does not exist or could not be found.");
        }
    }

    @Override
    public Transaction newDeposit(String iban, BigDecimal amount, String category) {
        if (accountRepo.findById(iban).isPresent()) {
            Account account = accountRepo.findById(iban).get();
            Transaction transaction = new Transaction(accountRepo.findById(iban).get(), amount, category);
            account.deposit(amount);
            transactionRepo.save(transaction);
            return transaction;
        } else {
            throw new DoesNotExistException("The account does not exist or could not be found.");
        }
    }

    @Override
    public List<Transaction> listTransactions(String iban) {
        if (accountRepo.findById(iban).isPresent()) {
            return transactionRepo.findAllByAccountIban(iban);
        } else {
            throw new DoesNotExistException("The account does not exist or could not be found.");
        }
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepo.findById(id)
                .orElseThrow(() -> new DoesNotExistException("The transaction does not exist or could not be found."));
    }

    @Override
    public void delete(Transaction transaction) {
        transactionRepo.delete(transaction);
    }

    @Override
    public void setCategory(Long id, String category) {
        Transaction transaction = getTransactionById(id);
        transaction.setCategory(category);
        transactionRepo.save(transaction);
    }
}
