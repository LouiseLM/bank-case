package nl.bankcase.repository.customer;

import nl.bankcase.model.Customer;

import java.util.List;

public interface CustomerRepo { //TODO insert DB logic & CRUD
    void SaveCustomer(Customer customer);
    List<Customer> listCustomers();
    Customer getCustomerById(String id);
    Customer getCustomer(Customer customer);
    void deleteCustomerById(String id);
    void deleteCustomer(Customer customer);
}
