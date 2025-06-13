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

public class CreateOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {

//		Getting data from properties file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Basic_Selenium\\VtigerCRM_FW_A9\\src\\test\\resources\\commonData.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

		
//		Getting data from excel file
		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\git\\ProjectA9\\VtigerCRM_FW_A9\\src\\test\\resources\\testScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);// Create method will not create anything
												  // It will open the workbook in read-mode
	
		Sheet sh = wb.getSheet("org");
		
		Row row = sh.getRow(4);
		
		Cell cell = row.getCell(0);
		
		String orgName = cell.getStringCellValue() + (int) (Math.random() * 1000);
		
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
		orgField.sendKeys(orgName);

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
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

}
