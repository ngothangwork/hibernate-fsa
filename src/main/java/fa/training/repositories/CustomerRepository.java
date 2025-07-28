package fa.training.repositories;

import fa.training.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    Customer findById(Long id);
    List<Customer> findAll();
}
