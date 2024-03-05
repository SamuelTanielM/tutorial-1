package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orderData = new ArrayList<>();

    public Order save(Order order) {
        // Implementation goes here
        return order;
    }

    public Order findById(String id) {
        // Implementation goes here
        return null;
    }

    public List<Order> findAllByAuthor(String author) {
        // Implementation goes here
        return null;
    }
}

