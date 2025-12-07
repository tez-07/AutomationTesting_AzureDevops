package Academy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserTest {

    @Test
    public void getData() {
        // Set path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the URL
            driver.get("https://tborgohainqa01.azurewebsites.net/webapp/");

            // Get the text from the <h1> element
            String text = driver.findElement(By.cssSelector("h1")).getText();
            System.out.println("Header text: " + text);

            // Assert the text
            Assert.assertEquals("Azure DevOps with Automation", text);

        } finally {
            // Quit the driver to close all sessions
            driver.quit();
        }
    }
}
