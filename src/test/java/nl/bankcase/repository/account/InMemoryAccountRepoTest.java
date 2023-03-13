package nl.bankcase.repository.account;

import nl.bankcase.model.Account;
import nl.bankcase.repository.customer.CustomerRepo;
import nl.bankcase.repository.customer.InMemoryCustomerRepo;
import nl.bankcase.service.account.AccountService;
import nl.bankcase.service.account.AccountServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryAccountRepoTest {

//    private AccountService accountService;
//    private CustomerRepo customerRepo;
//    private AccountRepo accountRepo;
//
//    private final Account account = accountService.newAccount(customerRepo.getCustomerById(1L));
//
//    @Test
//    void saveAccount() {
//        //Arrange
//        //Act
//        Account accountSave = accountService.newAccount(customerRepo.getCustomerById(1L));
//
//        //Assert
//        assertNotNull(accountRepo.getAccountByIban(accountSave.getIban()));
//    }
//
//    @Test
//    void listAccounts() {
//        //Arrange
//        //Act
//        //Assert
//        assertEquals(1, accountRepo.listAccounts().size());
//    }
//
//    @Test
//    void getAccountByIban() {
//        //Arrange
//        //Act
//        //Assert
//        assertNotNull(accountRepo.getAccountByIban(account.getIban()));
//    }
//
//    @Test
//    void deleteAccountByIban() {
//        //Arrange
//        Account accountDelete = accountService.newAccount(customerRepo.getCustomerById(1L));
//        int listSize = accountRepo.listAccounts().size();
//
//        //Act
//        accountRepo.deleteAccountByIban(accountDelete.getIban());
//
//        //Assert
//        assertNotEquals(listSize, accountRepo.listAccounts().size());
//    }
}