package nl.bankcase.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.bankcase.model.Customer;
import nl.bankcase.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public HttpStatus createCustomer(@RequestBody ObjectNode objectNode) {
        customerService.newCustomer(objectNode.get("name").asText());
        return HttpStatus.OK;
    }

    @GetMapping
    public List<Customer> listCustomers() {
        return List.copyOf(customerService.listCustomers());
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return HttpStatus.OK;
    }
}
