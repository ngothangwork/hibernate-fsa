package fa.training.test;

import fa.training.services.ProductService;

public class ProductTest {

    public void testAddProduct(ProductService productService) {
        try {
            String name = "Nike Air Max";
            double price = 150.0;
            int stock = 100;
            Long categoryId = 1L;
            Long supplierId = 1L;

            productService.createProduct(name, price, stock, categoryId, supplierId);

            String secondName = "Adidas Boost";
            double secondPrice = 180.0;
            int secondStock = 50;
            categoryId = 4L;
            supplierId = 1L;

            productService.createProduct(secondName, secondPrice, secondStock, categoryId, supplierId);

            System.out.println("Product creation test passed.");
        } catch (Exception e) {
            System.err.println("Product creation test failed: " + e.getMessage());
        }
    }
}
