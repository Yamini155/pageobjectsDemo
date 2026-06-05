package test;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPageClass;
import pages.ProductPageClass;
import utils.ConfigReader;
import utils.DataProviders;

public class ProductsTest extends BaseTest {
	ProductPageClass pp;
	
	 @BeforeMethod
	  public void LoginPage() {
		  LoginPageClass lp = new LoginPageClass(driver);
		  lp.loginPage(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		  pp = new ProductPageClass(driver);
		  
	 }
	  
	 @Test(dataProvider = "labelName", dataProviderClass = DataProviders.class)
	 public void validatePageLabel(String ProductList,String labelName) {
	  Assert.assertEquals(pp.titleOfProducts(), labelName);
	 }
	 @Test(dataProvider = "productName", dataProviderClass = DataProviders.class)
	 public void validateProductName(String ProductList,String productName) {
		 Assert.assertEquals(pp.singlePdtName(), productName);

		 }
	       
	   @Test 
	   public void removeButton() {
		  Assert.assertTrue(pp.clickAddToCart());
		  Assert.assertTrue(pp.clickRemoveButton());
	   }
	   
	
	   @Test
	   public void cartIconDisplay() {
		  pp.isCartIconDisplayed();
		  
	   }
	   
	   @Test
		 public void cartItems() {
		     pp.addProducts(1);
		 Assert.assertEquals(pp.cartCount(), 1);
		 
		 }
	   
         @Test
		 public void cartIcon() {
			 pp.clickAddToCart();
			 pp.clickCartIcon();
		 }
		 
		 
//		  validation for filter
		  
		  @Test(dataProvider="filterDec",dataProviderClass=DataProviders.class)
		  public void pdtDesending(String ProductList,String productDecending) {
			 pp.selectFilterOptions("Name (Z to A)");
			 List <String> productList = pp.allProducts();
			 Assert.assertEquals(productList.getFirst(),productDecending);
			    
		  }
  
		  @Test (dataProvider="filterAsc",dataProviderClass=DataProviders.class)
		  public void PdtAscending(String ProductList,String prdouctAscending) {
			 pp.selectFilterOptions("Name (A to Z)");
			 List <String> productList = pp.allProducts();
			 Assert.assertEquals(productList.get(0),prdouctAscending);
			    
		  }

		  @Test (dataProvider="filterLtoH",dataProviderClass=DataProviders.class)
		  public void PdtHightoLow(String ProductList,String lowToHighPrice) {
			 pp.selectFilterOptions("Price (low to high)");
			 List<Double> priceList = pp.allPrices();
			 Double expectedLow = Double.parseDouble(lowToHighPrice);
		     Assert.assertEquals(priceList.getFirst(), expectedLow);
			    
		  }
	  
		  @Test (dataProvider="filterHtoL",dataProviderClass=DataProviders.class)
		  public void pdtLowtoHigh(String ProductList,String highToLowPrice ) {
			 pp.selectFilterOptions("Price (high to low)");
			 List<Double> priceList = pp.allPrices();
			 Double expectedHigh = Double.parseDouble(highToLowPrice);
		     Assert.assertEquals(priceList.getFirst(), expectedHigh);
			    
		  }
	 
	 
	 
}
