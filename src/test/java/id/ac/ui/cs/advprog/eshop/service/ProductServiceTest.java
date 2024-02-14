package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateShouldReturnCreatedProduct() {
        // Arrange
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductId("1");
        product.setProductQuantity(10);
        when(productRepository.create(product)).thenReturn(product);

        // Act
        Product createdProduct = productService.create(product);

        // Assert
        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAllShouldReturnAllProducts() {
        // Arrange
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductName("Product 1");
        product1.setProductId("1");
        product1.setProductQuantity(10);

        productList.add(product1);

        Product product2 = new Product();
        product1.setProductName("Product 2");
        product1.setProductId("2");
        product1.setProductQuantity(10);

        productList.add(product2);
        when(productRepository.findAll()).thenReturn(productList.iterator());

        // Act
        List<Product> allProducts = productService.findAll();

        // Assert
        assertEquals(productList, allProducts);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdShouldReturnProductById() {
        // Arrange
        String productId = "1";
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductId(productId);
        product.setProductQuantity(10);
        when(productRepository.findById(productId)).thenReturn(product);

        // Act
        Product foundProduct = productService.findById(productId);

        // Assert
        assertEquals(product, foundProduct);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testUpdateShouldReturnUpdatedProduct() {
        // Arrange
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductId("1");
        product.setProductQuantity(10);
        when(productRepository.update(product)).thenReturn(product);

        // Act
        Product updatedProduct = productService.update(product);

        // Assert
        assertEquals(product, updatedProduct);
        verify(productRepository, times(1)).update(product);
    }

    @Test
    void testDeleteShouldReturnDeletedProduct() {
        // Arrange
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductId("1");
        product.setProductQuantity(10);
        when(productRepository.delete(product)).thenReturn(product);

        // Act
        Product deletedProduct = productService.delete(product);

        // Assert
        assertEquals(product, deletedProduct);
        verify(productRepository, times(1)).delete(product);
    }
}
