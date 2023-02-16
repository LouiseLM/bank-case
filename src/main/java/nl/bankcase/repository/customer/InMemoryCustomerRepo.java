package nl.bankcase.repository.customer;

import nl.bankcase.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCustomerRepo implements CustomerRepo {
    private Map<String, Customer> customerMap = new HashMap<>();
    private static InMemoryCustomerRepo instance = new InMemoryCustomerRepo();

    public static InMemoryCustomerRepo getInstance() {
        return instance;
    }

    private InMemoryCustomerRepo() {//TODO remove
        customerMap.put("1", new Customer("Test1", "1"));
        customerMap.put("2", new Customer("Test2", "2"));
        customerMap.put("3", new Customer("Test3", "3"));
    }

    @Override
    public void SaveCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomer(Customer customer) {
        return customerMap.get(customer.getId());
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerMap.get(id);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerMap.remove(customer.getId());
    }

    @Override
    public void deleteCustomerById(String id) {
        customerMap.remove(id);
    }
}
