package pages;
import java.time.Duration;
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

	
//	checkout button
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutButton;
	
	
//	cart remove
	@FindBy(xpath="//button[@name='remove-sauce-labs-backpack']")
	WebElement removeButton;
	
//	continue shopping button
	@FindBy(xpath="//button[text()='Continue Shopping']")
	WebElement continueShop;
	
	
//	cart page
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
	
	public void clickRemoveButtton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(removeButton));
		removeButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



