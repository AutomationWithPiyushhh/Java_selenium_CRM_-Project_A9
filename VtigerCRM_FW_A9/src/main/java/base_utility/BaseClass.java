package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import objecgt_repository.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public FileUtility fUtil = new FileUtility();

	@BeforeSuite
	public void dbCon() {
		System.out.println("DB connection + Report Configuration");
	}

	@BeforeTest
	public void preCon() {
		System.out.println("Pre conditions + prior test data");
	}

	@BeforeClass
	public void openBro() throws IOException {
		String BROWSER = fUtil.getDataFromPropFile("bro");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		sdriver = driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod
	public void login() throws IOException {
		String URL = fUtil.getDataFromPropFile("url");
		String USERNAME = fUtil.getDataFromPropFile("un");
		String PASSWORD = fUtil.getDataFromPropFile("pwd");

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void logout() throws InterruptedException {
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")); // Homepage
		wdUtil.hover(profile);
		driver.findElement(By.linkText("Sign Out")).click(); // HomePage
	}

	@AfterClass
	public void closeBro() {
		driver.quit();
	}

	@AfterTest
	public void postCon() {
		System.out.println("Post Conditions");
	}

	@AfterSuite
	public void dbClose() {
		System.out.println("DB close + Report Backup");
	}
}
