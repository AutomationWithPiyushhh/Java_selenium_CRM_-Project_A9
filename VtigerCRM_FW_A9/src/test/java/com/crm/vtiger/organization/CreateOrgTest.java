package com.crm.vtiger.organization;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import objecgt_repository.LoginPage;

public class CreateOrgTest {


	public static void main(String[] args) throws InterruptedException, IOException {

//		Getting data from properties file
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromPropFile("bro");
		String URL = fUtil.getDataFromPropFile("url");
		String USERNAME = fUtil.getDataFromPropFile("un");
		String PASSWORD = fUtil.getDataFromPropFile("pwd");

//		Getting data from excel file

		String orgName = fUtil.getDataFromExcelFile("org", 6, 0);

		WebDriver driver = null;

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

//		Login in vtiger crm

		LoginPage lp = new LoginPage(driver);

		lp.getUn().sendKeys("admin"); 	//loginpage
		lp.getPwd().sendKeys("admin"); //loginpage
		lp.getLoginBtn().click(); 		//loginpage

		Thread.sleep(3000);

//		Creating Organization
		driver.findElement(By.linkText("Organizations")).click();// Homepage		

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(); //OrgPage

//		Hardcoded Organization name
//		String orgName = "qsp_" + (int) (Math.random() * 1000);
		WebElement orgField = driver.findElement(By.name("accountname")); // Orgpage
		orgField.sendKeys(orgName + JavaUtility.getRandomNumber());

		WebElement saveBtn = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")); //OrgPage
		saveBtn.click();

//		Verification 
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText(); //VerifyOrgPage
		if (actualOrgName.equals(orgName)) {
			System.out.println("Organization Created successfully!!!");
		} else {
			System.out.println("Couldn't create Organization!!!!");
		}

//		Logout

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")); //Homepage

//		Actions act = new Actions(driver);
//		act.moveToElement(profile).perform();

		Thread.sleep(4000);
		wdUtil.hover(profile);

		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign Out")).click(); //HomePage

		driver.quit();

	}

}
