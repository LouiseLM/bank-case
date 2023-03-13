package nl.bankcase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class Transaction {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private Category category;
    private double c02Footprint; //TODO Find out how to do this
    private BigDecimal amount = BigDecimal.valueOf(0);

    protected Transaction() {}

    public Transaction(Category category, double c02Footprint, BigDecimal amount) {
        this.category = category;
        this.c02Footprint = c02Footprint;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }
}
