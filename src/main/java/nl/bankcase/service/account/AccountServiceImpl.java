package nl.bankcase.service.account;

import nl.bankcase.model.Account;
import nl.bankcase.model.Customer;
import nl.bankcase.repository.account.AccountRepo;

public class AccountServiceImpl implements AccountService {
    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account newAccount(Customer customer) {
        Account account = new Account();

        customer.addAccount(account);
        accountRepo.SaveAccount(account);
        return account;
    }
}
