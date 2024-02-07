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

    void createProduct_setup(ChromeDriver driver) {
        driver.get(String.format(baseUrl+"/product/create"));
        WebElement nameInput=driver.findElement(By.className("productname"));
        nameInput.clear();
        String name="test";
        nameInput.sendKeys(name);

        WebElement quanInput=driver.findElement(By.className("productquantity"));
        quanInput.clear();
        String quant="1";
        quanInput.sendKeys(quant);

        WebElement submitProductButton = driver.findElement(By.className("submitbutton"));
        submitProductButton.click();
    }

    void deleteProduct_setup(ChromeDriver driver) {
        driver.get(baseUrl + "/product/list");

        List<WebElement> deleteButtons = driver.findElements(By.className("deletebutton"));

        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }
    }

    @Test
    void createProduct_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement listButton = driver.findElement(By.className("listbutton"));
        listButton.click();

        WebElement createProductButton = driver.findElement(By.className("createbutton"));
        createProductButton.click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/create", currentUrl);

        WebElement nameInput=driver.findElement(By.className("productname"));
        nameInput.clear();
        String name="test";
        nameInput.sendKeys(name);

        WebElement quanInput=driver.findElement(By.className("productquantity"));
        quanInput.clear();
        String quant="1";
        quanInput.sendKeys(quant);

        WebElement submitProductButton = driver.findElement(By.className("submitbutton"));
        submitProductButton.click();

        currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/list", currentUrl);

        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));

        String productName = columns.get(0).getText();
        assertEquals("test", productName);

        String productQuant = columns.get(1).getText();
        assertEquals("1", productQuant);

        deleteProduct_setup(driver);
    }

    @Test
    void editProduct_isCorrect(ChromeDriver driver) {
        driver.get(baseUrl);
        WebElement listButton = driver.findElement(By.className("listbutton"));
        listButton.click();

        createProduct_setup(driver);
        assertEquals(baseUrl + "/product/list", driver.getCurrentUrl());

        WebElement editProductButton = driver.findElement(By.className("editbutton"));
        editProductButton.click();
        String currentUrl = driver.getCurrentUrl();

        WebElement nameInput = driver.findElement(By.id("productName"));
        nameInput.clear();
        String newName = "Edited Test";
        nameInput.sendKeys(newName);

        WebElement quantityInput = driver.findElement(By.id("productQuantity"));
        quantityInput.clear();
        String newQuantity = "1";
        quantityInput.sendKeys(newQuantity);

        WebElement submitButton = driver.findElement(By.className("btn-primary"));
        submitButton.click();

        currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/list", currentUrl);

        WebElement editedProductRow = driver.findElement(By.xpath("//tr[contains(.,'" + newName + "') and contains(.,'" + newQuantity + "')]"));
        String productName = editedProductRow.findElement(By.xpath(".//td[1]")).getText();
        String productQuantity = editedProductRow.findElement(By.xpath(".//td[2]")).getText();

        assertEquals(newName, productName);
        assertEquals(newQuantity, productQuantity);

        deleteProduct_setup(driver);
    }

    @Test
    void deleteProduct_isCorrect(ChromeDriver driver) {
        driver.get(baseUrl);
        WebElement listButton = driver.findElement(By.className("listbutton"));
        listButton.click();

        createProduct_setup(driver);
        assertEquals(baseUrl + "/product/list", driver.getCurrentUrl());

        WebElement deleteProductButton = driver.findElement(By.className("deletebutton"));
        deleteProductButton.click();

        assertEquals(baseUrl + "/product/list", driver.getCurrentUrl());

        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        boolean productFound = false;
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() > 0 && columns.get(0).getText().equals("Product Name")) {
                continue;
            }
            if (columns.size() > 0 && columns.get(0).getText().equals("Edited Product")) {
                productFound = true;
                break;
            }
        }
        assertEquals(false, productFound);

        deleteProduct_setup(driver);
    }
}
