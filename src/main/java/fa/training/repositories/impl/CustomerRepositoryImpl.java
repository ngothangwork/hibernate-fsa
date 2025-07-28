package fa.training.repositories.impl;

import fa.training.entities.Customer;
import fa.training.repositories.CustomerRepository;
import org.hibernate.Session;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final Session session;

    public CustomerRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Customer customer) {
        session.persist(customer);
    }

    @Override
    public void update(Customer customer) {
        session.merge(customer);

    }

    @Override
    public void delete(Customer customer) {
        session.remove(customer);

    }

    @Override
    public Customer findById(Long id) {
        return session.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        return session.createQuery("FROM Customer", Customer.class).list();
    }
}
