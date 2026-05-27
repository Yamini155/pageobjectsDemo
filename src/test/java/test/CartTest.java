package test;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPageClass;
import pages.LoginPageClass;
import pages.ProductPageClass;
import utils.ConfigReader;


public class CartTest extends BaseTest{
	  
	 @BeforeMethod
	  public void LoginPage() {
		  LoginPageClass lp = new LoginPageClass(driver);
		  lp.loginPage(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		  
	 }
	 
	
	 @Test
	 public void checkOutBtn() {
		 ProductPageClass pp = new ProductPageClass(driver);
		 pp.clickAddToCart();
		 pp.clickCartIcon();
	 CartPageClass cp = new CartPageClass(driver);
		
//		  Assertion for check out button
		  String expectedName = "Checkout";
		  String actualName= cp.checkOutButtonText();;
		  System.out.println("actualName is :" + actualName);
		  Assert.assertEquals(expectedName,actualName);
		  cp.checkOutBtnClick();
		  System.out.println("check out button clicked");
		  
	 }
	 
	 @Test
	 public void removeButton() {
	 ProductPageClass pp = new ProductPageClass(driver);
		 pp.clickAddToCart();
		 pp.clickCartIcon();
	 CartPageClass cp = new CartPageClass(driver);
		 
		 cp.clickRemoveButtton();
	 }
	 
	 @Test
	 public void continueShopBtn() {
		 ProductPageClass pp = new ProductPageClass(driver);
		 pp.clickAddToCart();
		 pp.clickCartIcon();
	     CartPageClass cp = new CartPageClass(driver); 
		 cp.continueShopButton();
		//Assertion for continue shopping button
		  String expectedButton = "Continue Shopping";
		  String actualButton= cp.continueShopButton();;
		  System.out.println("actualButton is :" + actualButton);
		  Assert.assertEquals(expectedButton,actualButton);
	
		  
}
	 
	
}
