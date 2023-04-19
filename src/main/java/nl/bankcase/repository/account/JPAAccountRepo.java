package nl.bankcase.repository.account;

import nl.bankcase.model.Account;
import nl.bankcase.model.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface JPAAccountRepo extends CrudRepository<Account, String> {
    List<Account> findAllByCustomer(Customer customer);
}
