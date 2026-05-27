package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
	public static WebDriver driver;
//	public static ExtentTest test;
	  @BeforeMethod
	  public void browserLaunch() {
		  driver= DriverFactory.initDriver(ConfigReader.getProperty("browser"));
		  driver.get(ConfigReader.getProperty("url"));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
		  
		  
	  }
	  
	  @AfterMethod
	  public void closeBrowser() {
		 driver.quit();
	 }

}

