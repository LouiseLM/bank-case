package nl.bankcase.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.bankcase.model.Account;
import nl.bankcase.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/list/{ownerId}")
    public List<Account> listAccounts(@PathVariable Long ownerId) {
        return List.copyOf(accountService.listAccounts(ownerId));
    }

    @GetMapping("/{iban}")
    public Account getAccountByIban(@PathVariable String iban) {
        return accountService.getAccountByIban(iban);
    }

    @DeleteMapping("/{iban}")
    public HttpStatus deleteAccountByIban(@PathVariable String iban) {
        accountService.deleteAccountByIban(iban);
        return HttpStatus.OK;
    }
}
