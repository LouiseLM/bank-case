package nl.bankcase.service.account;

import nl.bankcase.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    Account newAccount(Long ownerId);
    List<Account> listAccounts(Long ownerId);
    Account getAccountByIban(String iban);
    void deleteAccountByIban(String iban);
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
}
