package nl.bankcase.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Account {
    @Id
    private String iban = "";
    private BigDecimal balance = BigDecimal.valueOf(0);
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<>();

    protected Account() {}

    public Account(Customer customer) {
        BankNumber bankNumber = new BankNumber();

        this.iban = bankNumber.makeIban();
        this.customer = customer;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}

class BankNumber {
    public String makeIban() {
        String start = "NL";
        Random value = new Random();

        int r1 = value.nextInt(10);
        int r2 = value.nextInt(10);
        start += r1 + Integer.toString(r2) + " ";

        int count = 0;
        int n = 0;
        for(int i =0; i < 12;i++)
        {
            if(count == 4)
            {
                start += " ";
                count =0;
            }
            else
                n = value.nextInt(10);
            start += Integer.toString(n);
            count++;

        }
        return start;
    }
}
