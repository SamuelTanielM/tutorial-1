package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private int productIdCounter = 0; // Initialize the ID counter

    public Product create(Product product) {
        product.setProductId(String.valueOf(productIdCounter++));
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    public Product findById(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        throw new ProductNotFoundException("Product with ID " + productId + " not found");
    }

    public Product update(Product productToUpdate) {
        for (Product product : productData) {
            if (product.getProductId().equals(productToUpdate.getProductId())) {
                // Update the product's details
                product.setProductName(productToUpdate.getProductName());
                product.setProductQuantity(productToUpdate.getProductQuantity());
                // You can update other fields as needed
                return product; // Return the updated product
            }
        }
        throw new ProductNotFoundException("Product with ID " + productToUpdate.getProductId() + " not found");
    }

    public Product delete(Product productToDelete) {
        Iterator<Product> iterator = productData.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId().equals(productToDelete.getProductId())) {
                iterator.remove();
                return product; // Return the deleted product
            }
        }
        throw new ProductNotFoundException("Product with ID " + productToDelete.getProductId() + " not found");
    }

}