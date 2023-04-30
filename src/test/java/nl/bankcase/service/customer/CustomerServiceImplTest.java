package nl.bankcase.service.customer;

import nl.bankcase.model.Customer;
import nl.bankcase.utils.exceptions.DoesNotExistException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {
    private final static Long customer_id = 1L;
    private final static String customer_name = "Test Customer";

    @Autowired
    private CustomerService customerService;

    @Test
    void newCustomer() {
        //Arrange
        //Act
        Customer customer = customerService.newCustomer(customer_name);

        //Assert
        assertEquals(customer_name, customer.getName());
    }

    @Test
    void listCustomers() {
        //Arrange
        customerService.newCustomer(customer_name);

        //Act
        //Assert
        assertFalse(customerService.listCustomers().isEmpty());
    }

    @Test
    void getCustomerById() {
        //Arrange
        //Act
        Customer customer = customerService.getCustomerById(customer_id);

        //Assert
        assertEquals(customer.getId(), customer_id);
    }

    @Test
    void deleteCustomerById() {
        //Arrange
        //Act
        customerService.deleteCustomerById(customer_id);

        //Assert
        assertThrows(DoesNotExistException.class,
                () -> customerService.getCustomerById(customer_id));
    }
}