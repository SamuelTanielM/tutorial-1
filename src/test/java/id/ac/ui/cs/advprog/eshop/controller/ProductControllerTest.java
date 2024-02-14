package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createProductPageShouldReturnCreateProductPage() {
        // Arrange

        // Act
        String viewName = productController.createProductPage(model);

        // Assert
        assertEquals("createProduct", viewName);
        verify(model).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    void createProductPostWithValidProduct_ShouldRedirectToListPage() {
        // Arrange
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductQuantity(10);

        // Act
        String viewName = productController.createProductPost(product, model);

        // Assert
        assertEquals("redirect:/list", viewName);
        verify(productService).create(product); // Changed 'service' to 'productService'
    }
    @Test
    void createProductPostWithNullProductName_ShouldReturnCreateProductPageWithError() {
        // Arrange
        Product product = new Product();
        product.setProductName(null);
        product.setProductQuantity(10);

        // Act
        String viewName = productController.createProductPost(product, model);

        // Assert
        assertEquals("createProduct", viewName);
        verify(model).addAttribute(eq("error"), eq("Name is required"));
        verify(productService, never()).create(product); // Changed 'service' to 'productService'
    }
    @Test
    void createProductPostWithEmptyProductName_ShouldReturnCreateProductPageWithError() {
        // Arrange
        Product product = new Product();
        product.setProductName("");
        product.setProductQuantity(10);

        // Act
        String viewName = productController.createProductPost(product, model);

        // Assert
        assertEquals("createProduct", viewName);
        verify(model).addAttribute(eq("error"), eq("Name is required"));
        verify(productService, never()).create(product); // Changed 'service' to 'productService'
    }

    @Test
    void createProductPostWithNegativeQuantity_ShouldReturnCreateProductPageWithError() {
        // Arrange
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductQuantity(-10);

        // Act
        String viewName = productController.createProductPost(product, model);

        // Assert
        assertEquals("createProduct", viewName);
        verify(model).addAttribute(eq("error"), eq("Quantity must be a positive integer"));
        verify(productService, never()).create(product); // Changed 'service' to 'productService'
    }

    // Similar tests for editProductPage, editProductPost, deleteProduct, productListPage methods

    @Test
    void editProductPostWithValidProduct_ShouldRedirectToListPage() {
        // Arrange
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductQuantity(10);

        // Act
        String viewName = productController.editProductPost(product, model);

        // Assert
        assertEquals("redirect:/list", viewName);
        verify(productService).update(product);
    }

    @Test
    void editProductPostWithEmptyProductName_ShouldReturnEditProductPageWithError() {
        // Arrange
        Product product = new Product();
        product.setProductName("");
        product.setProductQuantity(10);

        // Act
        String viewName = productController.editProductPost(product, model);

        // Assert
        assertEquals("editProduct", viewName);
        verify(model).addAttribute(eq("error"), eq("Name is required"));
        verify(productService, never()).update(product);
    }

    @Test
    void editProductPostWithNullProductName_ShouldReturnEditProductPageWithError() {
        // Arrange
        Product product = new Product();
        product.setProductName(null);
        product.setProductQuantity(10);

        // Act
        String viewName = productController.editProductPost(product, model);

        // Assert
        assertEquals("editProduct", viewName);
        verify(model).addAttribute(eq("error"), eq("Name is required"));
        verify(productService, never()).update(product);
    }

    @Test
    void editProductPostWithNegativeQuantity_ShouldReturnEditProductPageWithError() {
        // Arrange
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductQuantity(-10);

        // Act
        String viewName = productController.editProductPost(product, model);

        // Assert
        assertEquals("editProduct", viewName);
        verify(model).addAttribute(eq("error"), eq("Quantity must be a positive integer"));
        verify(productService, never()).update(product);
    }

    @Test
    void editProductPageShouldReturnEditProductPage() {
        // Arrange
        String productId = "1";
        Product mockProduct = new Product(); // Mock a product
        when(productService.findById(productId)).thenReturn(mockProduct); // Stub the service method

        // Act
        String viewName = productController.editProductPage(productId, model);

        // Assert
        assertEquals("editProduct", viewName);
        verify(model).addAttribute("product", mockProduct); // Verify that the product attribute is set with the mocked product
    }

    @Test
    void deleteProductShouldRedirectToListPage() {
        // Arrange
        String productId = "1";

        // Act
        String viewName = productController.deleteProduct(productId);

        // Assert
        assertEquals("redirect:/product/list", viewName);
        verify(productService).delete(productService.findById(productId));
    }

    @Test
    void productListPageShouldReturnProductListPage() {
        // Arrange
        List<Product> products = Collections.singletonList(new Product());
        when(productService.findAll()).thenReturn(products);

        // Act
        String viewName = productController.productListPage(model);

        // Assert
        assertEquals("productList", viewName);
        verify(model).addAttribute("products", products);
    }
}
