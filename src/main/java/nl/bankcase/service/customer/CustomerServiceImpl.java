package nl.bankcase.service.customer;

import nl.bankcase.model.Customer;
import nl.bankcase.repository.customer.JPACustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final JPACustomerRepo customerRepo;

    public CustomerServiceImpl(@Autowired JPACustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer newCustomer(String name) {
        return customerRepo.save(new Customer(name));
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }

//    @Override
//    public List<Account> accountsList(Customer customer) {
//        return new ArrayList<>(customer.getAccounts());
//    }
}
