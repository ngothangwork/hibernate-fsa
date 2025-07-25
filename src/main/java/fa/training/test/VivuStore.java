package fa.training.test;

import fa.training.entities.Category;
import fa.training.repositories.CategoryRepository;
import fa.training.repositories.impl.CategoryRepositoryImpl;
import fa.training.services.CategoryService;
import fa.training.services.impl.CategoryServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VivuStore {
    private static final Logger logger = LoggerFactory.getLogger(VivuStore.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        CategoryRepository categoryRepository = new CategoryRepositoryImpl(sessionFactory);
        CategoryService categoryService = new CategoryServiceImpl(categoryRepository);

        try {
            session.beginTransaction();
            categoryService.createCategory("Áo sơ mi", "Các loại áo sơ mi cao cấp");
            Category category = new Category("Áo thun", "Các loại áo thun thời trang");
            session.persist(category);
            session.getTransaction().commit();

            System.out.println("Category saved successfully with ID: " + category.getId());
        } catch (Exception e) {
            logger.error("Lỗi khi lưu category", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
