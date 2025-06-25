package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoingFBWithDP {
	@Test(dataProvider = "getData")
	public void login(String un, String pwd) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.id("pass")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.close();
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] users = new Object[5][2];
//										[row][column]
//										row -> number of executions
//										col -> number of parameters
		users[0][0] = "unknown";
		users[0][1] = "dontknow";

		users[1][0] = "kallu kaliya";
		users[1][1] = "Banrakas";

		users[2][0] = "manjudevi";
		users[2][1] = "admin@123";

		return users;
	}
}
