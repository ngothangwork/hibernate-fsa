package fa.training.services;

import fa.training.dtos.ProductDTO;


public interface ProductService {
    void createProduct(String name, Double price, int stock, Long categoryId, Long supplierId);
    void updateProduct(Long id, String name, Double price, int stock, Long categoryId, Long supplierId);
    void deleteProduct(Long id);
    ProductDTO getProductById(Long id);
}
