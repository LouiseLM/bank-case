package nl.bankcase.service.account;

import nl.bankcase.model.Account;
import nl.bankcase.model.Customer;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account newAccount(Long ownerId);
    List<Account> listAccounts();
    Optional<Account> getAccountByIban(String iban);
    void deleteAccountByIban(String iban);
}
