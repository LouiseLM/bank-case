package nl.bankcase.model;

import java.math.BigDecimal;

public class Transaction {
    private String id;
    private Category category;
    private double c02Footprint; //TODO Find out how to do this
    private final BigDecimal amount;

    public Transaction(Category category, double c02Footprint, BigDecimal amount) {
        this.category = category;
        this.c02Footprint = c02Footprint;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }
}
