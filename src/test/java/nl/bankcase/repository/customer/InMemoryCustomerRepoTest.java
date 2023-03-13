package nl.bankcase.repository.customer;

import nl.bankcase.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerRepoTest {
    private CustomerRepo customerRepo;

    @Test
    void saveCustomer() {
        //Arrange
        Customer customer = new Customer("TestCase", 123L);

        //Act
        customerRepo.saveCustomer(customer);

        //Assert
        assertNotNull(customerRepo.getCustomerById(123L));
    }

    @Test
    void listCustomers() {
        //Arrange
        //Act
        //Assert
        assertEquals(3, customerRepo.listCustomers().size());
    }

    @Test
    void getCustomerById() {
        //Arrange
        //Act
        //Assert
        assertNotNull(customerRepo.getCustomerById(1L));
    }

    @Test
    void deleteCustomerById() {
        //Arrange
        int listSize = customerRepo.listCustomers().size();

        //Act
        customerRepo.deleteCustomerById(3L);

        //Assert
        assertNotEquals(listSize, customerRepo.listCustomers().size());
    }
}