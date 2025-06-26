package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listeners_utility.List_Imp.class)
public class WorkingWithListeners {
	WebDriver driver = null;
	public static WebDriver sdriver;
	
	@BeforeClass
	public void openBro() {
		driver = new ChromeDriver();
		sdriver = driver;
	}
	
	
	@Test
	public void createOrgTest() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		Assert.assertFalse(false);
		
		driver.quit();
		
	}
	
	@Test
	public void createContactTest() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		Assert.assertFalse(true);
		
		driver.quit();
	}
	
	@Test
	public void createLeadsTest() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		Assert.assertFalse(true);
		
		driver.quit();
	}
}
