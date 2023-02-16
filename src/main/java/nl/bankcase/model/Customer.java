package nl.bankcase.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final String id;
    private List<Account> accounts = new ArrayList<>();

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
