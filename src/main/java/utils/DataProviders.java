package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="userInput")
	public Object loginData() throws IOException {
//		return ExcelReader.getExcelData("Sheet1","loginTest");
		Object []data = ExcelReader.getExcelData("Sheet1","loginValidation");
		return new Object[][] {data};
		
		
	}
	@DataProvider(name="userCheckout")
	public Object checkOutPage() throws IOException {
		Object []data = ExcelReader.getExcelData("Sheet2","checkOutTest");
		return new Object[][] {data};
		
	}
	
	@DataProvider(name="titleName")
	public Object titleName() throws IOException { 
	    Object []data = ExcelReader.getExcelData("products","ValidateTitle");
	    return new Object[][] {data};
	}
	
	@DataProvider(name="labelName")
	public Object labelName() throws IOException { 
	    Object []data = ExcelReader.getExcelData("products","ValidateLabel");
	    return new Object[][] {data};
	}

	@DataProvider(name="productName")
	public Object productName() throws IOException {
		Object []data =  ExcelReader.getExcelData("products","ValidateProduct");
		return new Object[][] {data};
	}

	@DataProvider(name="filterDec")
	public Object filterDec() throws IOException {
		Object []data = ExcelReader.getExcelData("products","ValidateFilterDec");
		return new Object[][] {data};
	}

	@DataProvider(name="filterAsc")
	public Object filterAsc() throws IOException {
		Object []data = ExcelReader.getExcelData("products","ValidateFilterAsc");
		return new Object[][] {data};
	}

	@DataProvider(name="filterLtoH")
	public Object filterLtoH() throws IOException {
		Object []data = ExcelReader.getExcelData("products","ValidateFilterLtoH");
		return new Object[][] {data};
	}

	@DataProvider(name="filterHtoL")
	public Object filterHtoL() throws IOException {
		Object []data = ExcelReader.getExcelData("products","ValidateFilterHtoL");
		return new Object[][] {data};
	}
	
	@DataProvider(name="cartlabel")
	public Object cartlabel() throws IOException { 
	    Object []data = ExcelReader.getExcelData("cart","ValidateCartLabel");
	    return new Object[][] {data};
	}
	
	@DataProvider(name="cartQty")
	public Object cartQty() throws IOException { 
	    Object []data = ExcelReader.getExcelData("cart","ValidateCartQty");
	    return new Object[][] {data};
	}

	@DataProvider(name="cartRemove")
	public Object cartRemove() throws IOException {
		Object []data =  ExcelReader.getExcelData("cart","ValidateCartRemove");
		return new Object[][] {data};
	}

	@DataProvider(name="cartProduct")
	public Object cartProduct() throws IOException {
		Object []data = ExcelReader.getExcelData("cart","ValidateCartPdt");
		return new Object[][] {data};
	}

	@DataProvider(name="cartcheckout")
	public Object cartcheckout() throws IOException {
		Object []data = ExcelReader.getExcelData("cart","ValidateCartCheckout");
		return new Object[][] {data};
	}

	@DataProvider(name="cartContinueShop")
	public Object cartContinueShop() throws IOException {
		Object []data = ExcelReader.getExcelData("cart","ValidateCartContinue");
		return new Object[][] {data};
	}

	
	
	



}
