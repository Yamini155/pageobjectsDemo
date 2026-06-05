package stepDefinitions;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPageClass;
import pages.LoginPageClass;
import pages.ProductPageClass;
import utils.ConfigReader;

public class CartSD extends BaseTest {
	ProductPageClass pp;
	CartPageClass cp;
	@Given("user launches the application for cart page")
	public void user_is_logged_into_sauce_demo_application() {
		LoginPageClass lp = new LoginPageClass(driver);
		  lp.loginPage(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		  
		  cp = new CartPageClass(driver);
		  pp = new ProductPageClass(driver); 
	}
	
	@When("user navigates to cart page")
	public void user_navigates_to_cart_page() {
		 pp.clickAddToCart();
		 pp.clickCartIcon();
	    
	}

	@And("Your Cart label is visible")
	public void your_cart_label_is_visible() {
		Assert.assertEquals(cp.yourCartLabel(),"Your Cart");
	    
	}

	@Then("list of added products should be visible")
	public void list_of_added_products_should_be_visible() {
		Assert.assertEquals(cp.cartQty(),1);
	    
	}

	@And("Remove button should be visible")
	public void remove_button_should_be_visible() {
		Assert.assertEquals(cp.RemoveButtton(),"Remove");
	}

	@Then("user clicks on Remove button")
	public void user_clicks_on_remove_button() {
		cp.clickRemoveButtton();
	}

	@Then("product {string} should be removed from cart")
	public void product_should_be_removed_from_cart(String productName) {
	    Assert.assertFalse(cp.isProductPresentInCart(productName));
	}
	

	@And("Checkout button should be visible")
	public void checkout_button_should_be_visible() {
		 Assert.assertEquals(cp.checkOutButtonText(),"Checkout");
	   
	}

	@Then("user clicks the Checkout button")
	public void user_clicks_the_checkout_button() {
		cp.checkOutBtnClick();
	    
	}

	@And("Continue Shopping button should be visible")
	public void continue_shopping_button_should_be_visible() {
		 Assert.assertEquals(cp.continueShopButton(),"Continue Shopping");
			
	}

	@Then("user clicks Continue Shopping button")
	public void user_clicks_continue_shopping_button() {
		cp.clickContinueShopButtton();
	}

	@And("navigates to Products page {string}")
	public void navigates_to_products_page(String labelName) {
	    Assert.assertEquals(pp.titleOfProducts(), labelName);
	}

}
