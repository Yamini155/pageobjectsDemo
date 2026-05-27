package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPageClass;
import pages.CheckoutPageClass;
import pages.LoginPageClass;
import pages.ProductPageClass;
import utils.ConfigReader;
import utils.DataProviders;

public class CheckoutTest extends BaseTest{

	 @BeforeMethod
	  public void loginPage() throws InterruptedException {
		  LoginPageClass lp = new LoginPageClass(driver);
		  lp.loginPage(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		  
		  ProductPageClass pp =new ProductPageClass(driver);
		     pp.clickAddToCart();
		     pp.clickCartIcon();
		     CartPageClass cp = new CartPageClass(driver);
		     Thread.sleep(2000);
		     cp.checkOutBtnClick();
		     
	 }
	 
	 @Test(dataProvider="userCheckout",dataProviderClass=DataProviders.class)
	 public void checkoutModule(String fName, String lName, String pinCode,String result) {
	     CheckoutPageClass chp = new CheckoutPageClass(driver);

	     // assertion
	     Assert.assertEquals( chp.checkOutInfo(),"Checkout: Your Information");
         
	     System.out.println("information printed");
        

	     // enter details
         
	     chp.enterFirstname(fName);
	     chp.enterLastname(lName);
	     chp.postalCode(pinCode);
	     
	     // continue
	     chp.continueButton();
	     
	     if(result.equals("firstNameError")) {
	    	String actualErrorMsg = chp.errFirstname();
	    	String expectedErrorMsg= "Error: First Name is required";
	    	Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
	     }
	     else if(result.equals("lastNameError")){
	    	 String actualErrorMsg = chp.errLastname();
		    	String expectedErrorMsg= "Error: Last Name is required";
		    	Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
	     }
	     
	     else if(result.equals("pinError")){
	    	 String actualErrorMsg = chp.errPin();
		    	String expectedErrorMsg= "Error: Postal Code is required";
		    	Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
	     }
	    
	     else if(result.equals("valid")) {

	         // assertion for checkout overview
	         Assert.assertEquals(chp.checkOutOverview(),"Checkout: Overview");

	         // assertion for quantity
	         Assert.assertEquals(chp.qunatity(),"QTY");

	         // assertion for cart quantity
	         Assert.assertEquals(chp.cartQuantity(), "1");

	         // assertion for product name
	         Assert.assertEquals(chp.getProductName(), "Sauce Labs Backpack");

	         // assertion for product price
	         Assert.assertEquals(chp.getProductPrice(), "$29.99");

	         // clicking finish button
	         chp.finishButton();
	     }
	 }

 
}

