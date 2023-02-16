package nl.bankcase.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    String iban = "0";
    BigDecimal balance;
    List<Transaction> transactions = new ArrayList<>();

    public Account() {
        this.iban = this.iban + 1;
    }

    public String getIban() {
        return iban;
    }
}
