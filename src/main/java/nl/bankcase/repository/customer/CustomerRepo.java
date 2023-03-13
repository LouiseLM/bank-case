package nl.bankcase.repository.customer;

import nl.bankcase.model.Customer;

import java.util.List;

public interface CustomerRepo {
    Customer saveCustomer(Customer customer);
    List<Customer> listCustomers();
    Customer getCustomerById(Long id);
    void deleteCustomerById(Long id);
}
