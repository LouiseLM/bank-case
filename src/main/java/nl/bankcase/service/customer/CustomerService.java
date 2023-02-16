package nl.bankcase.service.customer;

import nl.bankcase.model.Account;
import nl.bankcase.model.Customer;

import java.util.List;

public interface CustomerService { //insert business logic
    void newCustomer(String name, String id);
    List<Account> accountsList(Customer customer);
}
