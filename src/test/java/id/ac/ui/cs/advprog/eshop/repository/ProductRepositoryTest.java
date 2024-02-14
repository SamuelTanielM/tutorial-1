package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;
    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af7af73bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af7af73bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0721dde9096");
        product2.setProductName("Sampo Cap Bambang");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
    }

    @Test
    void testEdit(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af7af73bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        product.setProductName("Sampo Cap Bango");
        product.setProductQuantity(500);
        productRepository.update(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testDelete() {
        // Create a product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af7af73bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());

        // Delete the product
        productRepository.delete(product);

        productIterator = productRepository.findAll();
        // Verify that the product is deleted by checking if it can be found
        assertFalse(productIterator.hasNext(), "Product should be deleted");
    }

    @Test
    void testDeleteException() {
        // Create a product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af7af73bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        // Create another product to delete (not added to the repository)
        Product productToDelete = new Product();
        productToDelete.setProductId("123456");
        productToDelete.setProductName("Product to delete");
        productToDelete.setProductQuantity(50);

        // Attempt to delete the product that does not exist
        assertThrows(ProductRepository.ProductNotFoundException.class, () -> {
            productRepository.delete(productToDelete);
        });

        // Verify that the product was not deleted
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testEditException() {
        // Create a product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af7af73bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        // Create another product to update (not added to the repository)
        Product productToUpdate = new Product();
        productToUpdate.setProductId("123456");
        productToUpdate.setProductName("Product to update");
        productToUpdate.setProductQuantity(50);

        // Attempt to update the product that does not exist
        assertThrows(ProductRepository.ProductNotFoundException.class, () -> {
            productRepository.update(productToUpdate);
        });

        // Verify that the product was not updated
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }


    @Test
    void testFindByIdException() {
        // Attempt to find a product with an ID that does not exist
        String nonExistentId = "123456";
        assertThrows(ProductRepository.ProductNotFoundException.class, () -> {
            productRepository.findById(nonExistentId);
        });
    }

    @Test
    void testFindByIdValid() {
        // Create a product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af7af73bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        // Find the product by ID
        Product foundProduct = productRepository.findById(product.getProductId());

        // Verify that the correct product is found
        assertEquals(product, foundProduct);
    }

    @Test
    void testFindByIdInvalid() {
        // Create a product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af7af73bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        assertThrows(ProductRepository.ProductNotFoundException.class, () -> {
            productRepository.findById("123456");
        });
    }
}
