package fa.training.repositories.impl;

import fa.training.entities.Customer;
import fa.training.repositories.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final SessionFactory sessionFactory;

    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(session.contains(customer) ? customer : session.merge(customer));
            session.getTransaction().commit();
        }
    }

    @Override
    public Customer findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Customer.class, id);
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Customer", Customer.class).list();
        }
    }
}
