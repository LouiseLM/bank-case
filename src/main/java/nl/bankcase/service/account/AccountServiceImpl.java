package nl.bankcase.service.account;

import nl.bankcase.model.Account;
import nl.bankcase.repository.account.JPAAccountRepo;
import nl.bankcase.repository.customer.JPACustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final JPAAccountRepo accountRepo;
    private final JPACustomerRepo customerRepo;
    public AccountServiceImpl(@Autowired JPAAccountRepo accountRepo, JPACustomerRepo customerRepo) {
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public Account newAccount(Long ownerId) {
        if (customerRepo.findById(ownerId).isPresent()) {
            Account account = new Account(customerRepo.findById(ownerId).get());
            accountRepo.save(account);
            return account;
        } else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Optional<Account> getAccountByIban(String iban) {
        return accountRepo.findById(iban);
    }

    @Override
    public void deleteAccountByIban(String iban) {
        accountRepo.deleteById(iban);
    }
}
