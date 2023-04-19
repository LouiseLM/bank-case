package nl.bankcase.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.bankcase.utils.DoesNotExistException;
import nl.bankcase.model.Account;
import nl.bankcase.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/list/{ownerId}")
    public List<Account> listAccounts(@PathVariable Long ownerId) {
        return accountService.listAccounts(ownerId);
    }

    @GetMapping("/{iban}")
    public Account getAccountByIban(@PathVariable String iban) {
        return accountService.getAccountByIban(iban);
    }

    @DeleteMapping
    public HttpStatus deleteAccountByIban(@RequestBody String iban) {
        accountService.deleteAccountByIban(iban);
        return HttpStatus.OK;
    }

    @ExceptionHandler(DoesNotExistException.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
