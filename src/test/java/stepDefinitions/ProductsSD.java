package stepDefinitions;



import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPageClass;
import pages.ProductPageClass;
import utils.ConfigReader;

public class ProductsSD extends BaseTest{
	ProductPageClass pp;
	@Given("user launches the application")
	public void user_is_logged_into_sauce_demo_application() {
		LoginPageClass lp = new LoginPageClass(driver);
		  lp.loginPage(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
		  pp = new ProductPageClass(driver); 
	}
	
	@Then("Products page title should be {string}")
	public void products_page_title_should_be(String labelName) {
	    Assert.assertEquals(pp.titleOfProducts(), labelName);
	}
	
	@Then("Product name should be {string}")
	public void product_name_should_be(String productName) {
		Assert.assertEquals(pp.singlePdtName(), productName);
	    
	}
	
	@When("user selects filter {string}")
	public void user_sf1(String filter) {
	    pp.selectFilterOptions(filter);
	}
	
	@Then("product should be sorted in descending order {string}")
	public void product_should_be_sorted_in_ascending_order(String productDecending) {
        Assert.assertEquals(pp.allProducts().getFirst(), productDecending);
	    
	}

	@Then("product should be sorted in ascending order {string}")
	public void product_should_be_sorted_in_descending_order(String productAscending) {
  Assert.assertEquals(pp.allProducts().getFirst(), productAscending);
	    
	}

	 @Then("products should be sorted by low to high price {string}")
	    public void products_should_be_sorted_by_low_to_high_price(String lowToHighPrice) {
	        Double expectedLow = Double.parseDouble(lowToHighPrice);
	        Assert.assertEquals(pp.allPrices().getFirst(), expectedLow);
	    }


	 @Then("products should be sorted by high to low price {string}")
	    public void products_should_be_sorted_by_high_to_low_price(String highToLowPrice) {
	        Double expectedHigh = Double.parseDouble(highToLowPrice);
	        Assert.assertEquals(pp.allPrices().getFirst(), expectedHigh);
	    }

	 @When("user clicks Add To Cart button")
	    public void user_clicks_add_to_cart_button() {

	        Assert.assertTrue(pp.clickAddToCart());
	    }

	    @Then("Remove button should be displayed")
	    public void remove_button_should_be_displayed() {

	        Assert.assertTrue(pp.clickRemoveButton());
	    }

	    @Then("cart icon should be visible")
	    public void cart_icon_should_be_visible() {

	        Assert.assertTrue(pp.isCartIconDisplayed());
	    }
	    
	    @When("user adds {int} product to cart")
	    public void user_adds_product_to_cart(Integer count) {
	        pp.addProducts(count);
	    }

	    @Then("cart badge count should be {int}")
	    public void cart_badge_count_should_be(Integer expectedCount) {

	        Assert.assertEquals(pp.cartCount(), expectedCount);
	    }

	    @Then("user clicks cart icon")
	    public void user_clicks_cart_icon() {

	        pp.clickCartIcon();
	    }
	    
	   

	   
	    
}
