package pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;


public class CartPageClass extends BasePage {
	public CartPageClass (WebDriver driver) {
		super(driver);
	}
	
	
//Your Cart label
	@FindBy(xpath="//span[text()='Your Cart']")
	WebElement yourCart;
	
//	Quantity in cart
	@FindBy(xpath="//div[@data-test=\"item-quantity\"]")
	WebElement cartQty;
	
//	checkout button
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutButton;
//	cart remove
	@FindBy(xpath="//button[@name='remove-sauce-labs-backpack']")
	WebElement removeButton;
//	cart empty
	@FindBy(className = "removed_cart_item")
	List<WebElement> cartItems;
	
//	continue shopping button
	@FindBy(id="continue-shopping")
	WebElement continueShop;
	
	
//	cart page
	
	public String yourCartLabel() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(yourCart));
		return yourCart.getText();
		
	}
	
	public int cartQty() {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.visibilityOf(cartQty));
	     return Integer.parseInt(cartQty.getText());
	}
	
	
	
	public String checkOutButtonText() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(checkoutButton));
		return checkoutButton.getText();
		
	}
	public void checkOutBtnClick() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
	    checkoutButton.click();
	}
	
	public String continueShopButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(continueShop));
		return continueShop.getText();
		
	}
	
	public void clickContinueShopButtton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(continueShop));
		 continueShop.click();
	}
	public String RemoveButtton() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(removeButton));
		return removeButton.getText();
		
	}
	
	public void clickRemoveButtton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(removeButton));
		removeButton.click();
	}
	
	public boolean isProductPresentInCart(String productName) {
	    for (WebElement item : cartItems) {
	        if (item.getText().equals(productName)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



