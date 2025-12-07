import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

    @Test
    public void getData() {
        WebDriverManager.chromedriver().setup(); // automatically downloads correct driver

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://tborgohainqa01.azurewebsites.net/webapp/");

        String text = driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals("-- Azure DevOps with Automation --", text);

        driver.quit();
    }
}
