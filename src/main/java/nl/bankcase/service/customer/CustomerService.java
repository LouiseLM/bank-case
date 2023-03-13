package nl.bankcase.service.customer;

import nl.bankcase.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService { //insert business logic
    Customer newCustomer(String name);
    List<Customer> listCustomers();
    Optional<Customer> getCustomerById(Long id);
    void deleteCustomerById(Long id);
    //List<Account> accountsList(Customer customer);
}
