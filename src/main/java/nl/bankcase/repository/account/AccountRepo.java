package nl.bankcase.repository.account;

import nl.bankcase.model.Account;

import java.util.List;

public interface AccountRepo {
    void SaveAccount(Account account);
    List<Account> listAccounts();
    Account getAccountByIban(String iban);
    Account getAccount(Account account);
    void deleteAccountByIban(String iban);
    void deleteAccount(Account account);
}
