package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	public static String takeScreenShot(WebDriver driver, String testName) {

	    File folder = new File("Screenshots");

	    if(!folder.exists()) {
	        folder.mkdir();
	    }

	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    String path = "Screenshots/" + testName + ".png";

	    File dest = new File(path);

	    try {
	        FileUtils.copyFile(src, dest);
	    } 
	    catch(IOException error) {
	        error.printStackTrace();
	    }

	    return path;
	}
	}
	
	
	


