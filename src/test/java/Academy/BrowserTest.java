package Academy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class BrowserTest {

	
	@Test
	public void getData()
	{
		
		ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		driver.get("https://tborgohainqa01.azurewebsites.net/webapp/");
		String text =driver.findElement(By.cssSelector("h1")).getText();
		System.out.println(text);
		Assert.assertTrue(text.equalsIgnoreCase("Azure DevOps with Automation || Updated"));
		driver.close();
		
		//Comments Updated
		
	}
}
