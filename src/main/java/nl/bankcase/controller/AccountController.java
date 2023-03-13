package nl.bankcase.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.bankcase.model.Account;
import nl.bankcase.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(@Autowired AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody ObjectNode objectNode) {
        return accountService.newAccount(objectNode.get("ownerId").asLong());
    }

    @GetMapping
    public List<Account> listAccount() {
        return accountService.listAccounts();
    }

    @GetMapping("/{iban}")
    public Optional<Account> getAccountByIban(@PathVariable String iban) {
        return accountService.getAccountByIban(iban);
    }

    @DeleteMapping
    public HttpStatus deleteCustomerById(@RequestBody String iban) {
        accountService.deleteAccountByIban(iban);
        return HttpStatus.OK;
    }
}
