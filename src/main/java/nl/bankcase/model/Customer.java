package nl.bankcase.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final Long id = null;
    private String name;

    @OneToMany(mappedBy = "customer")
    private final List<Account> accounts = new ArrayList<>();

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

    public List<Account> getAccounts() {
        return List.copyOf(accounts);
    }
}
