package nl.bankcase.repository.customer;

import nl.bankcase.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryCustomerRepo implements CustomerRepo {

    private Map<Long, Customer> customerMap = new HashMap<>();

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerMap.put(customer.getId(), customer);
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerMap.get(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerMap.remove(id);
    }
}
