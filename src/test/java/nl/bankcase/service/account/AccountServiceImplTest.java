package nl.bankcase.service.account;

import nl.bankcase.model.Customer;
import nl.bankcase.repository.account.AccountRepo;
import nl.bankcase.repository.account.InMemoryAccountRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {
    private AccountRepo accountRepo = InMemoryAccountRepo.getInstance();
    private AccountServiceImpl accountService = new AccountServiceImpl(accountRepo);

    @Test
    void shouldSucceedAddNewAccount() {
        //Arrange
        Customer customer = new Customer("Test Name", "1234");

        //Act
        accountService.newAccount(customer);

        //Assert
        assertEquals("01", customer.getAccounts().get(0).getIban());
    }
}