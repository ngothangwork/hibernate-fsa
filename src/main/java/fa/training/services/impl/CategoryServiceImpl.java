package fa.training.services.impl;

import fa.training.dtos.CategoryDTO;
import fa.training.entities.Category;
import fa.training.repositories.CategoryRepository;
import fa.training.services.CategoryService;
import fa.training.utils.ModelMapperUtil;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper = ModelMapperUtil.getModelMapper();

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(String name, String description) {
        Category category = new Category(name, description);
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id);
        if (category != null) {
            return modelMapper.map(category, CategoryDTO.class);
        }
        return null;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(cat -> modelMapper.map(cat, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateCategory(Long id, String name, String description) {
        Category category = categoryRepository.findById(id);
        if (category != null) {
            category.setName(name);
            category.setDescription(description);
            categoryRepository.update(category);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }
}
