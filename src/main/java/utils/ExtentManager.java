package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	public static ExtentReports getInstance() {
		ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
		spark.config().setReportName("SauceDemo Automation Result");
		spark.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Test","Yamini");
		extent.setSystemInfo("Env","production");
		extent.setSystemInfo("Browser","chrome");
		
		return extent;
		
	}

}
