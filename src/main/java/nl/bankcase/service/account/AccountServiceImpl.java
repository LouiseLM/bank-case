package nl.bankcase.service.account;

import nl.bankcase.model.Transaction;
import nl.bankcase.service.transaction.TransactionService;
import nl.bankcase.utils.exceptions.DoesNotExistException;
import nl.bankcase.model.Account;
import nl.bankcase.repository.account.JPAAccountRepo;
import nl.bankcase.repository.customer.JPACustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            throw new DoesNotExistException("The customer does not exist or could not be found.");
        }
    }

    @Override
    public List<Account> listAccounts(Long ownerId) {
        if (customerRepo.findById(ownerId).isPresent()) {
            return accountRepo.findAllByCustomer(customerRepo.findById(ownerId).get());
        } else {
            throw new DoesNotExistException("The customer does not exist or could not be found.");
        }
    }

    @Override
    public Account getAccountByIban(String iban) {
        return  accountRepo.findById(iban)
                .orElseThrow(() -> new DoesNotExistException("The account does not exist or could not be found."));
    }

    @Transactional
    @Override
    public void deleteAccountByIban(String iban) {
        for (Transaction transaction : transactionService.listTransactions(iban)) {
            transactionService.delete(transaction);
        }
        accountRepo.deleteById(iban);
    }
}
