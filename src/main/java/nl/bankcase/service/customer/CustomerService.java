package nl.bankcase.service.customer;

import nl.bankcase.model.Customer;

import java.util.List;

public interface CustomerService { //insert business logic
    Customer newCustomer(String name);
    List<Customer> listCustomers();
    Customer getCustomerById(Long id);
    void deleteCustomerById(Long id);
}
