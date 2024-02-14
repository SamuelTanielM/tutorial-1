package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            model.addAttribute("error", "Name is required");
            return "createProduct";
        }
        if (product.getProductQuantity() <= 0) {
            model.addAttribute("error", "Quantity must be a positive integer");
            return "createProduct";
        }

        service.create(product);
        return "redirect:/list";
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = service.findById(productId);
        model.addAttribute("product", product);
        return "editProduct"; // Assuming you have a separate view for editing
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product, Model model) {
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            model.addAttribute("error", "Name is required");
            return "editProduct";
        }
        if (product.getProductQuantity() <= 0) {
            model.addAttribute("error", "Quantity must be a positive integer");
            return "editProduct";
        }

        service.update(product);
        return "redirect:/list";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        Product product = service.findById(productId);
        service.delete(product);
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }
}