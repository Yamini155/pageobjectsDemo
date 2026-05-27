package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;
	static {
		try {
			String path = System.getProperty("user.dir")
                    + "/src/test/resources/config.properties";
			FileInputStream fis = new FileInputStream(path);
			prop = new Properties();
				prop.load(fis);
			
			
		}catch(Exception error) {
			
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	

}
