package nl.bankcase.repository.customer;

import nl.bankcase.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerRepoTest {
    private CustomerRepo customerRepo = InMemoryCustomerRepo.getInstance();

    @Test
    void saveCustomer() {
        //Arrange
        Customer customer = new Customer("TestCase", "123");

        //Act
        customerRepo.SaveCustomer(customer);

        //Assert
        assertNotNull(customerRepo.getCustomerById("123"));
    }

    @Test
    void listCustomers() {
        //Arrange
        //Act
        //Assert
        assertEquals(3, customerRepo.listCustomers().size());
    }

    @Test
    void getCustomer() {
        //Arrange
        Customer customer = new Customer("TestCase", "123");

        //Act
        customerRepo.SaveCustomer(customer);

        //Assert
        assertEquals(customer, customerRepo.getCustomer(customer));
    }

    @Test
    void getCustomerById() {
        //Arrange
        //Act
        //Assert
        assertNotNull(customerRepo.getCustomerById("1"));
    }

    @Test
    void deleteCustomer() {
        //Arrange
        int listSize = customerRepo.listCustomers().size();

        //Act
        customerRepo.deleteCustomer(customerRepo.getCustomerById("3"));

        //Assert
        assertNotEquals(listSize, customerRepo.listCustomers().size());
    }

    @Test
    void deleteCustomerById() {
        //Arrange
        int listSize = customerRepo.listCustomers().size();

        //Act
        customerRepo.deleteCustomerById("3");

        //Assert
        assertNotEquals(listSize, customerRepo.listCustomers().size());
    }
}