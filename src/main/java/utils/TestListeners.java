package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;

public class TestListeners implements ITestListener{
	ExtentReports extent= ExtentManager.getInstance();
	ExtentTest test;
	
	@Override
	public void onTestStart(org.testng.ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		test.info("Test Started");
	}
	
	@Override
	public void onTestSuccess(org.testng.ITestResult result) {
		test.pass("Test passed");
		
	}
	
	@Override
	public void onTestFailure(org.testng.ITestResult result) {
		test.fail("Test failed");
		test.fail(result.getThrowable());
		WebDriver driver= BaseTest.driver;
		String path= ScreenShots.takeScreenShot(driver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(path);
		
	}
	
	@Override
	public void onTestSkipped(org.testng.ITestResult result) {
		test.skip("Test skipped");
		test.skip(result.getThrowable());
		
	}
	
	
	@Override
	public void onFinish(org.testng.ITestContext context) {
		extent.flush();
		
	}
	
	
	

}
