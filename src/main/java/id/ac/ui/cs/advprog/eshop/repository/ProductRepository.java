package id.ac.ui.cs.advprog.eshop.repository;

import java.util.Iterator;
import id.ac.ui.cs.advprog.eshop.model.Product;

public interface ProductRepository {
    Product create(Product product);
    Iterator<Product> findAll();
    Product findById(String productId);
    Product update(Product productToUpdate);
    Product delete(String productId);
    Product delete(Product product);
}