package fa.training.test;

import fa.training.entities.Category;
import fa.training.services.CategoryService;
import org.hibernate.Session;

public class CategoryTest {
    public void testAddCategory(Session session, CategoryService categoryService) {
        categoryService.createCategory("Áo sơ mi", "Các loại áo sơ mi cao cấp");
        Category category = new Category("Áo vai tho", "Các loại áo thun thời trang");
        session.persist(category);
    }


}
