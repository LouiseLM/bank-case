package nl.bankcase.service.customer;

import nl.bankcase.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    private final CustomerService customerService;

    CustomerServiceImplTest(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    void newCustomer() {
        //Arrange
        //Act
        customerService.newCustomer("Tester Test");

        //Assert
        assertNotNull(customerService.getCustomerById(0L));
    }

    @Test
    void listCustomers() {
        //Arrange
        //Act
        //Assert
        assertEquals(3, customerService.listCustomers().size());
    }

    @Test
    void getCustomerById() {
        //Arrange
        //Act
        Customer customer = customerService.newCustomer("Tester Test");

        //Assert
        assertEquals(customer, customerService.getCustomerById(0L));
    }

    @Test
    void deleteCustomerById() {
        //Arrange
        Customer customer = customerService.newCustomer("Tester Test");

        //Act
        customerService.deleteCustomerById(customer.getId());

        //Assert
        assertNull(customerService.getCustomerById(0L));
    }

    //@Test
    void accountsList() {
        //Arrange
        //Act
        //Assert
    }
}