package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPageClass extends BasePage {
		public LoginPageClass (WebDriver driver) {
		super(driver);
		
	}
		
		
//	userName 
	@FindBy(xpath="//input[@id='user-name']")
	WebElement userName;
	
//	password
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
//	LoginButton
	@FindBy(xpath="//input[@class='submit-button btn_action']")
	WebElement loginbtn;
	
//	ErrorMessage
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement errorMsg;
	
	
	
//	Login
	public void enterUsername(String user) {
		enterText(userName, user);
				
}

	public void enterPassword(String pwd) {
		enterText(password, pwd);
		
	}

	public void clickLoginbtn() {
		click(loginbtn);
	}
	
	
	public String getErrorMsg() {
		return errorMsg.getText();
	}
	
	public void loginPage(String userName, String password) {
		enterUsername(userName);
		enterPassword(password);
		click(loginbtn);
		
	}
	
	


}
