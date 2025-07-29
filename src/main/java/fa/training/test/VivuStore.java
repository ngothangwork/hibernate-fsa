package fa.training.test;

import fa.training.repositories.*;
import fa.training.repositories.impl.*;
import fa.training.services.CustomerService;
import fa.training.services.ProductService;
import fa.training.services.impl.CustomerServiceImpl;
import fa.training.services.impl.ProductServiceImpl;
import fa.training.utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VivuStore {
    private static final Logger logger = LoggerFactory.getLogger(VivuStore.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        SupplierRepository supplierRepository = new SupplierRepositoryImpl(sessionFactory);
        CategoryRepository categoryRepository = new CategoryRepositoryImpl(sessionFactory);
        ProductRepository productRepository = new ProductRepositoryImpl(sessionFactory);

        ProductService productService = new ProductServiceImpl(productRepository, categoryRepository, supplierRepository);

        try {

            ProductTest productTest = new ProductTest();
            productTest.testAddProduct(productService);

        } catch (Exception e) {
            logger.error("Exception occurred during execution: ", e);
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
