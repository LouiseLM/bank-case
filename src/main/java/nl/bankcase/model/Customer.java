package nl.bankcase.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final Long id = null;
    private String name = null;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts = new ArrayList<>();

    protected Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

//    public List<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void addAccount(Account account) {
//        accounts.add(account);
//    }
}
