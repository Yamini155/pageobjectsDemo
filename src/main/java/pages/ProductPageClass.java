package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;


public class ProductPageClass extends BasePage {
	public ProductPageClass (WebDriver driver) {
		super(driver);
	}
	
//	page title
	@FindBy(xpath="//div[text()='Swag Labs']")
	WebElement pageTitle;
	

// Products title
	@FindBy(xpath="//span[@data-test='title']")
	WebElement productTitle;
	
	
//	list of prices
	@FindBy(className = "inventory_item_price")
	List<WebElement> allPrices;
	
// selection of product
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	WebElement productBackPack;
	
//	list of products
	@FindBy(className = "inventory_item_name")
	List<WebElement> allProducts;
	
//	multiple add to carts
	@FindBy(xpath="//button[text()='Add to cart']")
	List<WebElement> addCartbtnButtons;
	
//	product add to cart
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addCartbtnBP;
	
//	remove button clicking in products page
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement removeButtonBP;
	
	
//	filter
	@FindBy(className="product_sort_container")
	WebElement filterIcon;
	
//	cart icon
	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]")
	WebElement cartIcon;
	
//	products count in cart
	@FindBy(className = "shopping_cart_badge")
	WebElement cartCount;
	
	
//	products
	
	
	public int cartCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(cartCount));
	    return Integer.parseInt(cartCount.getText());
	}
	
		public void clickCartIcon() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
	     cartIcon.click();
	}
	public String pageTitle() {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfAllElements(pageTitle));
		
		return pageTitle.getText();
		
	}
	
	
	
	public List<String> allProducts() {
		List<String> productNames= new ArrayList<>();

	    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfAllElements(allProducts));

	    for (WebElement product : allProducts) {
	        
	        productNames.add(product.getText());
	       
	    }
	    return productNames;
	}
	
	public List<Double> allPrices() {
		List<Double> productPrices= new ArrayList<>();

	    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfAllElements(allPrices));

	    for (WebElement price : allPrices) {

	        String text = price.getText().replace("$", "").trim();

	        productPrices.add(Double.parseDouble(text));
	    }
	    return productPrices;
	}
	
	public String titleOfProducts() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(productTitle));
	    return productTitle.getText();
	}
	
	public String singlePdtName() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(productBackPack));

	    return productBackPack.getText();
	}
	
//	for adding selected products by using count
	public void addProducts(int count) {

	    int size = addCartbtnButtons.size();

	    for(int i = 0; i < Math.min(count, size); i++) {

	        addCartbtnButtons.get(0).click();
	    }
	}
	
//	adding products based on product name
	public void addinProducts(String productName) {
		for( int i=0;i<allProducts.size();i++) {
			String currentProduct=allProducts.get(i).getText();
			if(currentProduct.equalsIgnoreCase(productName)) {
				addCartbtnButtons.get(i).click();
				
			}
			
		}
		
	}

	
	
	
	public boolean clickAddToCart() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.elementToBeClickable(addCartbtnBP));

	    addCartbtnBP.click();

	    return removeButtonBP.isDisplayed();
	}
	
	
	
	public boolean clickRemoveButton() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement removeButton =
	            wait.until(ExpectedConditions.elementToBeClickable(removeButtonBP));

	    removeButton.click();

	    return addCartbtnBP.isDisplayed();
	}
	
	
	
	public void selectFilterOptions(String option) {
		Select select =new Select(filterIcon);
			select.selectByVisibleText(option);
			
			
	}

	
	public boolean isCartIconDisplayed() {
	    return cartIcon.isDisplayed();
	}
	
	
	
	


}
