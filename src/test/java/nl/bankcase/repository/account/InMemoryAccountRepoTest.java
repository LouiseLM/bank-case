package nl.bankcase.repository.account;

import nl.bankcase.model.Account;
import nl.bankcase.model.Customer;
import nl.bankcase.repository.customer.CustomerRepo;
import nl.bankcase.repository.customer.InMemoryCustomerRepo;
import nl.bankcase.service.account.AccountService;
import nl.bankcase.service.account.AccountServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryAccountRepoTest {
    private AccountRepo accountRepo = InMemoryAccountRepo.getInstance();
    private CustomerRepo customerRepo = InMemoryCustomerRepo.getInstance();
    private AccountService accountService = new AccountServiceImpl(accountRepo);

    private Account account = accountService.newAccount(customerRepo.getCustomerById("1"));

    @Test
    void saveAccount() {
        //Arrange
        //Act
        Account accountSave = accountService.newAccount(customerRepo.getCustomerById("1"));

        //Assert
        assertNotNull(accountRepo.getAccountByIban(accountSave.getIban()));
    }

    @Test
    void listAccounts() {
        //Arrange
        //Act
        //Assert
        assertEquals(1, accountRepo.listAccounts().size());
    }

    @Test
    void getAccountByIban() {
        //Arrange
        //Act
        //Assert
        assertNotNull(accountRepo.getAccountByIban(account.getIban()));
    }

    @Test
    void getAccount() {
        //Arrange
        //Act
        //Assert
        assertNotNull(accountRepo.getAccount(account));
    }

    @Test
    void deleteAccountByIban() {
        //Arrange
        Account accountDelete = accountService.newAccount(customerRepo.getCustomerById("1"));
        int listSize = accountRepo.listAccounts().size();

        //Act
        accountRepo.deleteAccountByIban(accountDelete.getIban());

        //Assert
        assertNotEquals(listSize, accountRepo.listAccounts().size());
    }

    @Test
    void deleteAccount() {
        //Arrange
        Account accountDelete = accountService.newAccount(customerRepo.getCustomerById("1"));
        int listSize = accountRepo.listAccounts().size();

        //Act
        accountRepo.deleteAccount(accountDelete);

        //Assert
        assertNotEquals(listSize, accountRepo.listAccounts().size());
    }
}