package nl.bankcase.repository.account;

import nl.bankcase.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAccountRepo implements AccountRepo {
    private final Map<String, Account> accountMap = new HashMap<>();
    private static final InMemoryAccountRepo instance = new InMemoryAccountRepo();

    public static InMemoryAccountRepo getInstance() {
        return instance;
    }

    @Override
    public void SaveAccount(Account account) {
        accountMap.put(account.getIban(), account);
    }

    @Override
    public List<Account> listAccounts() {
        return new ArrayList<>(accountMap.values());
    }

    @Override
    public Account getAccountByIban(String iban) {
        return accountMap.get(iban);
    }

    @Override
    public void deleteAccountByIban(String iban) {
        accountMap.remove(iban);
    }
}
