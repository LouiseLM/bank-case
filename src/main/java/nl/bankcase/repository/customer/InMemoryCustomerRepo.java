package nl.bankcase.repository;

import nl.bankcase.model.Customer;

import java.util.List;

public class InMemoryCustomerRepository implements CustomerRepository {
    @Override
    public void SaveCustomer(Customer customer) {

    }

    @Override
    public List<Customer> listCustomers(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomer(String id) {
        return null;
    }

    @Override
    public void deleteCustomer(Customer customer) {

    }
}
