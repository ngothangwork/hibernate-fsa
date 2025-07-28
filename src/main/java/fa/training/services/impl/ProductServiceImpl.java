package fa.training.services.impl;

import fa.training.dtos.ProductDTO;
import fa.training.entities.Category;
import fa.training.entities.Product;
import fa.training.entities.Supplier;
import fa.training.repositories.CategoryRepository;
import fa.training.repositories.ProductRepository;
import fa.training.repositories.SupplierRepository;
import fa.training.services.ProductService;
import fa.training.utils.ModelMapperUtil;
import org.modelmapper.ModelMapper;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper = ModelMapperUtil.getModelMapper();

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void createProduct(String name, Double price, int stock, Long categoryId, Long supplierId) {
        Category category = categoryRepository.findById(categoryId);
        Supplier supplier = supplierRepository.findById(supplierId);

        if (category == null || supplier == null) {
            throw new IllegalArgumentException("Invalid category or supplier ID");
        }

        Product product = new Product(name, price, stock, category, supplier);
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, String name, Double price, int stock, Long categoryId, Long supplierId) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }

        Category category = categoryRepository.findById(categoryId);
        Supplier supplier = supplierRepository.findById(supplierId);

        if (category == null || supplier == null) {
            throw new IllegalArgumentException("Invalid category or supplier ID");
        }

        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setCategory(category);
        product.setSupplier(supplier);

        productRepository.update(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
        productRepository.delete(id);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id);
        return product != null ? modelMapper.map(product, ProductDTO.class) : null;
    }
}
