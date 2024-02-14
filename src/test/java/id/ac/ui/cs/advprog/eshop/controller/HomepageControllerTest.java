package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomepageControllerTest {

    @Mock
    private Model model;

    @InjectMocks
    private HomepageController homepageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void homePage_ShouldReturnHomePage() {
        // Act
        String viewName = homepageController.homePage(model);

        // Assert
        assertEquals("homepage", viewName);
    }

    @Test
    void productListPage_ShouldRedirectToListPage() {
        // Act
        String viewName = homepageController.productListPage(model);

        // Assert
        assertEquals("redirect:/product/list", viewName);
    }
}
