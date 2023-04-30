package nl.bankcase.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.bankcase.model.Transaction;
import nl.bankcase.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return transactionService.newWithdrawal(objectNode.get("iban").asText(), objectNode.get("amount").decimalValue(), objectNode.get("category").asText());
    }

    @PostMapping("/deposit")
    public Transaction newDeposit(@RequestBody ObjectNode objectNode) {
        return transactionService.newDeposit(objectNode.get("iban").asText(), objectNode.get("amount").decimalValue(), objectNode.get("category").asText());
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/list/{ownerIban}")
    public List<Transaction> listTransactionsByIban(@PathVariable String ownerIban) {
        return transactionService.listTransactions(ownerIban);
    }

    @PutMapping("/{id}")
    public Transaction setCategory(@PathVariable Long id, @RequestBody ObjectNode objectNode) {
        transactionService.setCategory(id, objectNode.get("category").asText());
        return transactionService.getTransactionById(id);
    }
}