package nl.bankcase.service.account;

import nl.bankcase.model.Account;
import java.util.List;

public interface AccountService {
    Account newAccount(Long ownerId);
    List<Account> listAccounts(Long ownerId);
    Account getAccountByIban(String iban);
    void deleteAccountByIban(String iban);
}
