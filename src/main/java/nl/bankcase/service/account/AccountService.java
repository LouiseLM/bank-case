package nl.bankcase.service.account;

import nl.bankcase.model.Account;
import nl.bankcase.model.Customer;

public interface AccountService {
    Account newAccount(Customer customer);
}
