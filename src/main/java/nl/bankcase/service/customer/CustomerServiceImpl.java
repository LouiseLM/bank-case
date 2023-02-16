package nl.bankcase.service;

import nl.bankcase.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
