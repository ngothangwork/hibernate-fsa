package fa.training.repositories;

import fa.training.entities.Supplier;

public interface SupplierRepository {
    void save(Supplier supplier);
    Supplier findById(Long id);
    void update(Supplier supplier);
    void delete(Supplier supplier);
}
