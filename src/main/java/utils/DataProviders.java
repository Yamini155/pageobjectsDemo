package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="userInput")
	public Object loginData() throws IOException {
		return ExcelReader.getExcelData("Sheet1");
		
		
	}
	@DataProvider(name="userCheckout")
	public Object checkOutPage() throws IOException {
		return ExcelReader.getExcelData("Sheet2");
		
		
	}

}
