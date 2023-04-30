package nl.bankcase.service.account;

import nl.bankcase.model.Account;
import nl.bankcase.utils.exceptions.DoesNotExistException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplTest {
    private static final Long customer_id = 1L;
    private static String iban;

    @Autowired
    private AccountService accountService;

    @BeforeAll
    static void setup(@Autowired AccountService accountService) {
        Account account = accountService.newAccount(customer_id);
        iban = account.getIban();
    }

    @Test
    void newAccount() {
        //Arrange
        //Act
        Account account = accountService.newAccount(customer_id);

        //Assert
        assertNotNull(account);
    }

    @Test
    void listAccounts() {
        //Arrange
        //Act
        //Assert
        assertFalse(accountService.listAccounts(customer_id).isEmpty());
    }

    @Test
    void getAccountByIban() {
        //Arrange
        //Act
        //Assert
        assertNotNull(accountService.getAccountByIban(iban));
    }

    @Test
    void deleteAccountByIban() {
        //Arrange
        //Act
        accountService.deleteAccountByIban(iban);

        //Assert
        assertThrows(DoesNotExistException.class,
                () -> accountService.getAccountByIban(iban));
    }

    @Test
    void deposit() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void withdraw() {
        //Arrange
        //Act
        //Assert
    }
}