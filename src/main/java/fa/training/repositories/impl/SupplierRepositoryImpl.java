package fa.training.repositories.impl;

import fa.training.entities.Supplier;
import fa.training.repositories.SupplierRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SupplierRepositoryImpl implements SupplierRepository {

    private final SessionFactory sessionFactory;

    public SupplierRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Supplier supplier) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(supplier);
            session.getTransaction().commit();
        }
    }

    @Override
    public Supplier findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Supplier.class, id);
        }
    }

    @Override
    public void update(Supplier supplier) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(supplier);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Supplier supplier) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Supplier managedSupplier = session.contains(supplier)
                    ? supplier
                    : session.merge(supplier);
            session.remove(managedSupplier);
            session.getTransaction().commit();
        }
    }
}
