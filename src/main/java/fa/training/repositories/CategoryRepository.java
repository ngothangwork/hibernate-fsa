package fa.training.repositories;

import fa.training.entities.Category;

import java.util.List;

public interface CategoryRepository {
    void save(Category category);
    Category findById(Long id);
    List<Category> findAll();
    void update(Category category);
    void delete(Long id);
}
