package nl.bankcase.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private Category category;
    //private double c02Footprint; //TODO Find out how to do this
    private BigDecimal amount = BigDecimal.valueOf(0);

    protected Transaction() {}

    public Transaction(Account account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public Optional<BigDecimal> getCo2Footprint() {
        if (category == null) {
            return Optional.empty();
        } else {
            return Optional.of(amount.multiply(category.getCoefficient()));
        }
    }
}
