import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

    @Test
    public void getData() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // automatically downloads correct driver

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        boolean ready = false;
        int attempts = 0;
        while(attempts < 20) { // max 5 minutes
            try {
                driver.get("https://tborgohainqa01.azurewebsites.net/webapp/");
                String text = driver.findElement(By.cssSelector("h1")).getText();
                
                if(text.equals("-- Azure DevOps with Automation --")) {
                    ready = true;
                    System.out.println("QA Environment ready!");
                    break;
                }
            } catch(Exception e) {
                // element not found yet, retry
            }
            Thread.sleep(15000); // wait 15s before retry
            attempts++;
        }

        if(!ready) {
            System.out.println("QA environment not ready after 5 minutes. Aborting test.");
            driver.quit();
            return;
        }

        // actual test
        String finalText = driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals("-- Azure DevOps with Automation --", finalText);

        driver.quit();
    }
}
