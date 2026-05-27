package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPageClass;
import pages.ProductPageClass;
import utils.ConfigReader;
import utils.DataProviders;

public class LoginTest extends BaseTest {
	
	@Test(dataProvider="userInput",dataProviderClass=DataProviders.class)
  public void loginValidation(String username,String password,String result){
	  LoginPageClass lp = new LoginPageClass(driver);
//	  lp.loginPage(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
	  lp.loginPage(username,password);
	  if(result.equals("inValid")) {
		  String expectedErrorMsg = "Epic sadface: Sorry, this user has been locked out.";
		  String actualErrorMsg= lp.getErrorMsg();
		  System.out.println("actualErrorMsg is:" + actualErrorMsg);
		  Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
		  
	  }
	  }
 
 @Test
 public void assertValidLgn() {
	 ProductPageClass pp = new ProductPageClass(driver);
//		Assertion for valid login  
		  String expectedTitle = "Swag Labs";
		  String actualTitle= pp.pageTitle();
		  System.out.println("actualTitle is :" + actualTitle);
		  Assert.assertEquals(expectedTitle,actualTitle);
	 
 }
 
// @Test
// public void inValidLogin() throws InterruptedException {
//	  LoginPageClass lp = new LoginPageClass(driver);
//	  Thread.sleep(2000);
//	  lp.loginPage(ConfigReader.getProperty("invalidUsername"),ConfigReader.getProperty("invalidPassword"));
////	Assertion for inValid login  
//	  String expectedErrorMsg = "Epic sadface: Sorry, this user has been locked out.";
//	  String actualErrorMsg= lp.getErrorMsg();
//	  System.out.println("actualErrorMsg is:" + actualErrorMsg);
//	  Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
//	  
//	  
// }
 

 
  
  
}
