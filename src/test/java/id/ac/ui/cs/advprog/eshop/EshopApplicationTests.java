package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"spring.profiles.active=test", "server.port=0"})
class EshopApplicationTests {

	@Test
	void contextLoads() {
		//Load the app
	}
	@Test
	void mainShouldRunWithoutException() {
		try {
			EshopApplication.main(new String[]{});
		} catch (Exception e) {
			fail("Exception thrown during application startup: " + e.getMessage());
		}
	}
}
