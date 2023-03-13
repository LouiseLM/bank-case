package nl.bankcase.repository.account;

import nl.bankcase.model.Account;

import java.util.List;

public interface AccountRepo {
    void SaveAccount(Account account);
    List<Account> listAccounts();
    Account getAccountByIban(String iban);
    void deleteAccountByIban(String iban);
}
