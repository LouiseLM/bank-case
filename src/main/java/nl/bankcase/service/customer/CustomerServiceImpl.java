package nl.bankcase.service.customer;

import nl.bankcase.model.Account;
import nl.bankcase.model.Customer;
import nl.bankcase.repository.customer.CustomerRepo;
import nl.bankcase.repository.customer.InMemoryCustomerRepo;
import nl.bankcase.service.customer.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo = InMemoryCustomerRepo.getInstance();

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void newCustomer(String name, String id) {
        customerRepo.SaveCustomer(new Customer(name, id));
    }

    @Override
    public List<Account> accountsList(Customer customer) {
        return new ArrayList<>(customer.getAccounts());
    }
}
