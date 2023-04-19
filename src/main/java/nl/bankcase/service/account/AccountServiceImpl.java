package nl.bankcase.service.account;

import nl.bankcase.model.Transaction;
import nl.bankcase.service.transaction.TransactionService;
import nl.bankcase.utils.DoesNotExistException;
import nl.bankcase.model.Account;
import nl.bankcase.repository.account.JPAAccountRepo;
import nl.bankcase.repository.customer.JPACustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final JPAAccountRepo accountRepo;
    private final JPACustomerRepo customerRepo;
    private final TransactionService transactionService;
    public AccountServiceImpl(@Autowired JPAAccountRepo accountRepo, JPACustomerRepo customerRepo, TransactionService transactionService) {
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
        this.transactionService = transactionService;
    }

    @Override
    public Account newAccount(Long ownerId) {
        if (customerRepo.findById(ownerId).isPresent()) {
            Account account = new Account(customerRepo.findById(ownerId).get());
            accountRepo.save(account);
            return account;
        } else {
            throw new DoesNotExistException();
        }
    }

    @Override
    public List<Account> listAccounts(Long ownerId) {
        if (customerRepo.findById(ownerId).isPresent()) {
            return accountRepo.findAllByCustomer(customerRepo.findById(ownerId).get());
        } else {
            throw new DoesNotExistException();
        }
    }

    @Override
    public Account getAccountByIban(String iban) {
        if(accountRepo.findById(iban).isPresent()) {
            return accountRepo.findById(iban).get();
        } else {
            throw new DoesNotExistException();
        }
    }

    @Transactional
    @Override
    public void deleteAccountByIban(String iban) {
        for (Transaction transaction : transactionService.listTransactions(iban)) {
            transactionService.delete(transaction);
        }
        accountRepo.deleteById(iban);
    }

    @Override
    public void deposit(BigDecimal amount) {

    }

    @Override
    public void withdraw(BigDecimal amount) {

    }
}
