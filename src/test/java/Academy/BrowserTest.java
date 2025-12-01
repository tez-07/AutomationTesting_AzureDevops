package Academy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BrowserTest {

	
	@Test
	public void getData()
	{
		System.out.println("Hello Guys");
		 
		WebDriver driver =new ChromeDriver();
		driver.get("https://tezborgohain11-gyd0b0a0aaehfsc9.canadacentral-01.azurewebsites.net/webapp/");
		String text =driver.findElement(By.cssSelector("h1")).getText();
		System.out.println(text);
		Assert.assertTrue(text.equalsIgnoreCase("Azure Devops with Automation"));
		driver.close();
	
		
		
	}
}
