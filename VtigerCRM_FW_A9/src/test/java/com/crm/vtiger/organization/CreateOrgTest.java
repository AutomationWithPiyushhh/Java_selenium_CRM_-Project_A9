package com.crm.vtiger.organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;

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
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(USERNAME);

		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys(PASSWORD);

		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();

		Thread.sleep(3000);

//		Creating Organization
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//		Hardcoded Organization name
//		String orgName = "qsp_" + (int) (Math.random() * 1000);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName + JavaUtility.getRandomNumber());

		WebElement saveBtn = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		saveBtn.click();

//		Verification 
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actualOrgName.equals(orgName)) {
			System.out.println("Organization Created successfully!!!");
		} else {
			System.out.println("Couldn't create Organization!!!!");
		}

//		Logout

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

//		Actions act = new Actions(driver);
//		act.moveToElement(profile).perform();

		Thread.sleep(4000);
		wdUtil.hover(profile);

		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

}
