package nl.bankcase.service.customer;

import nl.bankcase.model.Account;
import nl.bankcase.model.Customer;
import nl.bankcase.repository.customer.JPACustomerRepo;
import nl.bankcase.service.account.AccountService;
import nl.bankcase.utils.DoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final JPACustomerRepo customerRepo;
    private final AccountService accountService;

    public CustomerServiceImpl(@Autowired JPACustomerRepo customerRepo, AccountService accountService) {
        this.customerRepo = customerRepo;
        this.accountService = accountService;
    }

    public Customer newCustomer(String name) {
        return customerRepo.save(new Customer(name));
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElseThrow(DoesNotExistException::new);
    }

    @Transactional
    @Override
    public void deleteCustomerById(Long id) {
        for (Account account : accountService.listAccounts(id)) {
            accountService.deleteAccountByIban(account.getIban());
        }
        customerRepo.deleteById(id);
    }
}
