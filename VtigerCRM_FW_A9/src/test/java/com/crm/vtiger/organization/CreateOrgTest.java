package com.crm.vtiger.organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.JavaUtility;

@Listeners(listeners_utility.List_Imp.class)
public class CreateOrgTest extends BaseClass{

	@Test
	public void createOrgTest() throws IOException, InterruptedException {	
//		Creating Organization
		String orgName = fUtil.getDataFromExcelFile("org", 6, 0)  + JavaUtility.getRandomNumber() ;
		driver.findElement(By.linkText("Organizations")).click();// Homepage		

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(); //OrgPage

		WebElement orgField = driver.findElement(By.name("accountname")); // Orgpage
		orgField.sendKeys(orgName);

		WebElement saveBtn = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")); //OrgPage
		saveBtn.click();

//		Verification 
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText(); //VerifyOrgPage
		boolean status = actualOrgName.equals(orgName + "123");
//		if (status) {
//			System.out.println("Organization Created successfully!!!");
//		} else {
//			System.out.println("Couldn't create Organization!!!!");
//		}
		Assert.assertTrue(status);
		System.out.println("it should get executed...");
	}
	
}
