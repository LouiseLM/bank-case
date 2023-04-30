package nl.bankcase.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private BigDecimal amount;
    private LocalDateTime date;
    private Category category;
    private BigDecimal c02Footprint;

    protected Transaction() {}

    public Transaction(Account account, BigDecimal amount, String category) {
        this.account = account;
        this.amount = amount;
        this.date = LocalDateTime.now();
        setCategory(category);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return date.format(dateFormatter);
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getC02Footprint() {
        return c02Footprint;
    }

    public void setCategory(String category) {
        this.category = Category.valueOf(category);
        this.c02Footprint = setCo2Footprint();
    }

    private BigDecimal setCo2Footprint() {
        return amount.multiply(category.getCoefficient());
    }
}
