package nl.bankcase.repository.customer;

import nl.bankcase.model.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface JPACustomerRepo extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
}
