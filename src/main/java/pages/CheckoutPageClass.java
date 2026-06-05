package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class CheckoutPageClass extends BasePage{
	public CheckoutPageClass(WebDriver driver) {
		super(driver);
		
	}
	
//	checkout button
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutButton;
	
//	information label
	@FindBy(xpath="//span[text()='Checkout: Your Information']")
	WebElement checkOutInfo;
	
//	cancel button
	@FindBy(id="finish")
	WebElement finishBtn;
	
	
//	firstName
	@FindBy(id="first-name")
	WebElement firstName;
	
//	lastName
	@FindBy(id="last-name")
	WebElement lastName;
	
//	postal code
	@FindBy(css="[name='postalCode']")
	WebElement postalCode;
	
//	error msg for first name
	@FindBy(xpath="//h3[text()='Error: First Name is required']")
	WebElement errFname;
	
//	error msg for last name
	@FindBy(xpath="//h3[text()='Error: Last Name is required']")
	WebElement errLname;
	
	//	error msg for postal code
	@FindBy(xpath="//h3[text()='Error: Postal Code is required']")
	WebElement errPcode;
	
	
//	continue button
	@FindBy(id="continue")
	WebElement continueBtn;
	
//	 checkout overview
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	WebElement checkoutOverview;
	
//	Qty label
	@FindBy(xpath="//div[@class='cart_quantity_label']")
	WebElement quantity;
	
//	cart quantity
	@FindBy(className = "cart_quantity")
	WebElement cartQuantity;
//	product name
	@FindBy(className = "inventory_item_name")
	WebElement productName;
	
//	product price
	@FindBy(css = "[data-test='inventory-item-price']")
	WebElement productPrice;
	
	
	
	
  
	
	
//	checkOut module
	
	
	public String checkOutInfo() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(checkOutInfo));
		return checkOutInfo.getText();
		
	}
	
	
	public void enterFirstname(String Fuser) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(firstName));
		 enterText(firstName, Fuser);
				
}
	
	public void enterLastname(String Luser) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(lastName));
		 enterText(lastName, Luser);
				
}
	
	public void postalCode(String pinNo) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(postalCode));
	    enterText(postalCode, String.valueOf(pinNo));
	}
	
	public String errFirstname() {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(errFname));
		 return errFname.getText();
				
}
	
	public String errLastname() {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(errLname));
		 return errLname.getText();
				
}
	
	public String errPin() {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(errPcode));
		 return errPcode.getText();
				
}
	
	public void continueButton() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		 continueBtn.click();
		
	}
	public String checkOutOverview() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(checkoutOverview));
		return checkoutOverview.getText();
		
	}
	public String qunatity() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(quantity));
		return quantity.getText();
		
	}
	public String cartQuantity() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until( ExpectedConditions.visibilityOf(cartQuantity));

	    return cartQuantity.getText();
	}
	
	public String getProductName() {

	    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until( ExpectedConditions.visibilityOf(productName)
	    );

	    return productName.getText();
	}
	
	public String getProductPrice() {

	    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until( ExpectedConditions.visibilityOf(productPrice));

	    return productPrice.getText();
	}
	public void finishButton() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
		 finishBtn.click();
		
	}
	
	

}
