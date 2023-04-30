package nl.bankcase.model;

import jakarta.persistence.*;
import nl.bankcase.utils.AccountUtils;
import nl.bankcase.utils.IllegalWithdrawalException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    private String iban = "";
    private BigDecimal balance = BigDecimal.valueOf(0);
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "account")
    private final List<Transaction> transactions = new ArrayList<>();

    protected Account() {}

    public Account(Customer customer) {
        AccountUtils accountUtils = new AccountUtils();

        this.iban = accountUtils.makeIban();
        this.customer = customer;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return List.copyOf(transactions);
    }

    public void withdrawal(BigDecimal amount) {
        if (balance.compareTo(amount) == -1) {
            throw new IllegalWithdrawalException("Amount exceeds available funds.");
        } else {
            balance = balance.subtract(amount);
        }
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}