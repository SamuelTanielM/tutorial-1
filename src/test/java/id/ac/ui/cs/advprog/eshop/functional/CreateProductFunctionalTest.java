package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By; // Note: Corrected import statement
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // Note: Corrected import statement
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals; // Note: Corrected import statement
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

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
    void createProduct_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);
        WebElement listButton = driver.findElement(By.className("listbutton"));
        listButton.click();

        WebElement createProductButton = driver.findElement(By.className("createbutton"));
        createProductButton.click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/create", currentUrl);

        WebElement nameInput=driver.findElement(By.className("productname"));
        nameInput.clear();
        //Enter Text
        String name="test";
        nameInput.sendKeys(name);

        WebElement quanInput=driver.findElement(By.className("productquantity"));
        quanInput.clear();
        //Enter Text
        String quant="1";
        quanInput.sendKeys(quant);

        WebElement submitProductButton = driver.findElement(By.className("submitbutton"));
        submitProductButton.click();

        currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/list", currentUrl);

        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));

        // Assuming the product name is in the first column (index 0)
        String productName = columns.get(0).getText();
        assertEquals("test", productName);

        String productQuant = columns.get(1).getText();
        assertEquals("1", productQuant);
        // Print or use the product name as needed
    }
}
