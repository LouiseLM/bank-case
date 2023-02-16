package nl.bankcase.repository;

import nl.bankcase.model.Customer;

import java.util.List;

public interface CustomerRepository { //TODO insert DB logic & CRUD
    void SaveCustomer(Customer customer);
    List<Customer> listCustomers(Customer customer);
    Customer getCustomer(String id);
    void deleteCustomer(Customer customer);
}
