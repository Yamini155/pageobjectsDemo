package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver driver;
	public static WebDriver initDriver(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("chrome"))
			driver= new ChromeDriver();
		return driver;
			
	}
	
	public static  WebDriver getDriver() {
		return driver;
	}
	
	

	public static void quitDriver() {
		driver.quit();
	}

}
