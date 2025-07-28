package fa.training.repositories.impl;

import fa.training.entities.Supplier;
import fa.training.repositories.SupplierRepository;
import org.hibernate.Session;

public class SupplierRepositoryImpl implements SupplierRepository {

    private final Session session;

    public SupplierRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Supplier supplier) {
        session.persist(supplier);
    }

    @Override
    public Supplier findById(Long id) {
        return session.find(Supplier.class, id);
    }

    @Override
    public void update(Supplier supplier) {
        session.merge(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        session.remove(supplier);
    }
}
