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
import utils.DataProviders;


public class CartTest extends BaseTest{
	ProductPageClass pp;
	CartPageClass cp;
	 @BeforeMethod
	  public void LoginPage() {
		  LoginPageClass lp = new LoginPageClass(driver);
		  lp.loginPage(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		  pp = new ProductPageClass(driver);
		  cp = new CartPageClass(driver);
		  
	 }
	 
	 @Test (dataProvider="cartlabel",dataProviderClass=DataProviders.class)
	 public void yourCartLabel(String CartList, String cartName) {
		 pp.clickAddToCart();
		 pp.clickCartIcon();	
//		  Assertion for cart label button
		  Assert.assertEquals(cp.yourCartLabel(),cartName);
 
	 }
	 
	 @Test(dataProvider="cartQty", dataProviderClass=DataProviders.class)
	 public void cartQuantity(String cartList, String cartQty) {

	     pp.clickAddToCart();
	     pp.clickCartIcon();

	     int expectedCartQty = (int) Double.parseDouble(cartQty);
	     Assert.assertEquals(cp.cartQty(), expectedCartQty);
	 }
	 
	 @Test (dataProvider="cartRemove",dataProviderClass=DataProviders.class)
	 public void removeButton(String CartList, String cartRemove) {
	     pp.clickAddToCart();
	     pp.clickCartIcon();
	     Assert.assertEquals(cp.RemoveButtton(), cartRemove);
	     cp.clickRemoveButtton();
	    
	    
	 }
	 
	 @Test (dataProvider="cartProduct",dataProviderClass=DataProviders.class)
	 public void cartProduct(String CartList,String cartProduct) {
	     pp.clickAddToCart();
	     pp.clickCartIcon();
	     Assert.assertFalse(cp.isProductPresentInCart(cartProduct)
	     );
	 }
	 
	 
	 
	 @Test (dataProvider="cartcheckout",dataProviderClass=DataProviders.class)
	 public void checkOutBtn(String cartList, String cartcheckout) {
		 pp.clickAddToCart();
		 pp.clickCartIcon();	
//		  Assertion for check out button
		  Assert.assertEquals(cp.checkOutButtonText(),cartcheckout);
		  
//		  clicking checkout button
		  cp.checkOutBtnClick();	  
	 }
	 
	
	 
	 @Test(dataProvider="cartContinueShop",dataProviderClass=DataProviders.class)
	 public void continueShopBtn(String cartList, String cartContinueShop) {
		 pp.clickAddToCart();
		 pp.clickCartIcon(); 
		//Assertion for continue shopping button
		  Assert.assertEquals(cp.continueShopButton(),cartContinueShop);
	
		  
}
	 
	
}
