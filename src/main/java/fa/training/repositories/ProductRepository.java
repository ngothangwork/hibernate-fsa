package fa.training.repositories;

import fa.training.entities.Product;

public interface ProductRepository {
    void save(Product product);
    Product findById(Long id);
    void update(Product product);
    void delete(Long id);
}
