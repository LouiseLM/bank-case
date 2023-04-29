package nl.bankcase.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.bankcase.utils.DoesNotExistException;
import nl.bankcase.utils.IllegalWithdrawalException;
import nl.bankcase.model.Transaction;
import nl.bankcase.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(@Autowired TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/withdrawal")
    public Transaction newWithdrawal(@RequestBody ObjectNode objectNode) {
        return transactionService.newWithdrawal(objectNode.get("iban").asText(), objectNode.get("amount").decimalValue());
    }

    @PostMapping("/deposit")
    public Transaction newDeposit(@RequestBody ObjectNode objectNode) {
        return transactionService.newDeposit(objectNode.get("iban").asText(), objectNode.get("amount").decimalValue());
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/list/{ownerIban}")
    public List<Transaction> listTransactionsByIban(@PathVariable String ownerIban) {
        return transactionService.listTransactions(ownerIban);
    }

    @ExceptionHandler({DoesNotExistException.class, IllegalWithdrawalException.class})
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}