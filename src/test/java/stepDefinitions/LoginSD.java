package stepDefinitions;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPageClass;


public class LoginSD extends BaseTest{
	LoginPageClass lp;
	@Given("application is launched")
	public void application_is_launched() {
	    lp = new LoginPageClass(driver);
	}

	 @When("user enters username {string}")
	    public void user_enters_username(String username) {
	        lp.enterUsername(username);
	    }

	  @And("user enters password {string}")
	    public void user_enters_password(String password) {
	        lp.enterPassword(password);
	    }
	  
	  @And("user clicks on login button")
	     public void user_clicks_on_login_button() {
		    lp.clickLoginbtn();
	     }

	  @Then("login is {string}")
	    public void login_is(String result) {
	        if(result.equalsIgnoreCase("invalid")) {
	    String expectedErrorMsg ="Epic sadface: Sorry, this user has been locked out.";
	      Assert.assertEquals(lp.getErrorMsg(), expectedErrorMsg);

	        } 
	    }
	}

	

