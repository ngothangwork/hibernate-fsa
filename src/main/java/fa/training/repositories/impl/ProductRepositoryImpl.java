package fa.training.repositories.impl;

import fa.training.entities.Product;
import fa.training.repositories.ProductRepository;
import org.hibernate.Session;

public class ProductRepositoryImpl implements ProductRepository {

    private final Session session;

    public ProductRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Product product) {
        session.persist(product);
    }

    @Override
    public Product findById(Long id) {
        return session.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        session.merge(product);
    }

    @Override
    public void delete(Long id) {
        session.remove(findById(id));
    }
}
