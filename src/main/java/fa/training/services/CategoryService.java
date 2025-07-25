package fa.training.services;

import fa.training.dtos.CategoryDTO;
import fa.training.entities.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(String name, String description);
    CategoryDTO getCategoryById(Long id);
    List<CategoryDTO> getAllCategories();
    void updateCategory(Long id, String name, String description);
    void deleteCategory(Long id);
}
