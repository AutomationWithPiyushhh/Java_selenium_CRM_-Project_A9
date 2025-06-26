package listeners_utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base_utility.BaseClass;
import generic_utility.JavaUtility;

public class List_Imp implements ISuiteListener, ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String mehtodName = result.getMethod().getMethodName();
		Reporter.log(mehtodName + " started executing....");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String mehtodName = result.getMethod().getMethodName();
		Reporter.log(mehtodName + " got Passed....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String mehtodName = result.getMethod().getMethodName();
		Reporter.log(mehtodName + " got Failed....");

		JavaUtility jUtil = new JavaUtility();

		String time = jUtil.getCurrentDateTime();

		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:/Users/User/git/ProjectA9/VtigerCRM_FW_A9/errorShots/" + time + ".png");

		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String mehtodName = result.getMethod().getMethodName();
		Reporter.log(mehtodName + " got Skipped....");
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("DB connection + Report Configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("DB connection + Report Backup");
	}

}
