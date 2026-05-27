package test;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPageClass;
import pages.LoginPageClass;
import pages.ProductPageClass;
import utils.ConfigReader;

public class ProductsTest extends BaseTest {
	
	 @BeforeMethod
	  public void LoginPage() {
		  LoginPageClass lp = new LoginPageClass(driver);
		  lp.loginPage(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		  
	 }
	   @Test 
	   public void productPage() {
		   
		  ProductPageClass pp = new ProductPageClass(driver);
		  pp.allProducts();
	   }
	   
	   @Test 
	   public void productPrice() {
		   
		  ProductPageClass pp = new ProductPageClass(driver);
		  pp.allPrices();
	   }
	   @ Test 
	   public void productTitle() {
		  ProductPageClass pp = new ProductPageClass(driver);
		  pp.titleOfProducts();
//		  Assertion for label visibility
		  String expectedLabel = "Products";
		  String actualLabel= pp.titleOfProducts();;
		  System.out.println("actualLabel is :" + actualLabel);
		  Assert.assertEquals(expectedLabel,actualLabel);
	   }
	   
	   @Test 
	   public void productName() {
		  ProductPageClass pp = new ProductPageClass(driver);
		  pp.singlePdtName();
//		  Assertion for product visibility
		  String expectedProduct = "Sauce Labs Backpack";
		  String actualProduct= pp.singlePdtName();;
		  System.out.println("actualProduct is :" + actualProduct);
		  Assert.assertEquals(expectedProduct,actualProduct);
	   }
	   
	   
	   @Test 
	   public void removeButton() {
		  ProductPageClass pp = new ProductPageClass(driver);
		  pp.clickAddToCart();
		  pp.clickRemoveButton();
	   }
	   
	
	   @Test
	   public void cartIconDisplay() {
		  ProductPageClass pp = new ProductPageClass(driver);
		  pp.isCartIconDisplayed();
		  
	   }
	   
	   @Test
		 public void cartItems() {

 ProductPageClass pp = new ProductPageClass(driver);

		     pp.addProducts(1);
		   int actualCount = pp.cartCount();
		   int expectedCount = 1;
		 Assert.assertEquals(actualCount, expectedCount);
		 }
	   
         @Test
		 public void cartIcon() {
		 ProductPageClass pp = new ProductPageClass(driver);
			 pp.clickAddToCart();
			 pp.clickCartIcon();
		 }
		 
		 
//		  validation for filter
		  
		  @Test
		  public void verifyPdtFtrngAssending() {
			  ProductPageClass pp = new ProductPageClass(driver);
			 pp.selectFilterOptions("Name (Z to A)");
			 
			 List <String> productList = pp.allProducts();
			 Assert.assertEquals(productList.getFirst(),"Test.allTheThings() T-Shirt (Red)");
			    
		  }
		  
		  @Test 
		  public void verifyPdtFtrngDescending() {
			  ProductPageClass pp = new ProductPageClass(driver);
			 pp.selectFilterOptions("Name (A to Z)");
			 
			 List <String> productList = pp.allProducts();
			 Assert.assertEquals(productList.get(0),"Sauce Labs Backpack");
			    
		  }
		  
		  @Test
		  public void verifyPdtFtrngHl() {
			  ProductPageClass pp = new ProductPageClass(driver);
			 pp.selectFilterOptions("Price (low to high)");
			 
			 List<Double> priceList = pp.allPrices();
			 Assert.assertEquals(priceList.getFirst(),Double.valueOf(7.99) );
			    
		  }
		  
		  @Test
		  public void verifyPdtFtrngLh() {
			  ProductPageClass pp = new ProductPageClass(driver);
			 pp.selectFilterOptions("Price (high to low)");
			 
			 List<Double> priceList = pp.allPrices();
			 Assert.assertEquals(priceList.getFirst(),Double.valueOf(49.99));
			    
		  }
	   
	 
	 
	 
}
