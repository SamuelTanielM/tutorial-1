package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By; // Note: Corrected import statement
import org.openqa.selenium.chrome.ChromeDriver; // Note: Corrected import statement
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals; // Note: Corrected import statement
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class NewHomePageFunctionalTest {

    @LocalServerPort
    private int port;

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private  String baseUrl;

    @BeforeEach
    void setupTest() {
        // Set up Selenium WebDriver
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void pageTitleIsCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();
        // Verify
        assertEquals("ADV Shop", pageTitle);
    }

    @Test
    void welcomeMessageIsCorrect(ChromeDriver driver) throws Exception{
        // Exercise
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();
        // Verify
        assertEquals("Welcome", welcomeMessage);
    }

}
