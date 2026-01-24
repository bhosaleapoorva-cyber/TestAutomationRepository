package TestAutomationSuite.Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import TestAutomationSuite.AbstractMethods.AbstractMethods;

public class ProductCatalogue extends AbstractMethods {

	WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> itemList;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css=".cartSection")
	List<WebElement> cartItems;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement countryInput;
	
//	@FindBy(css="//*[text()='Place Order ']")
//	WebElement placeOrderButton;

	By productsBy = By.cssSelector(".mb-3");
	By addProductToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage=  By.cssSelector("#toast-container");
	By placeOrderButton=By.cssSelector("//*[text()='Place Order ']");
	
	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear((productsBy));
		return itemList;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;

	}

	public NavigationOptions addToCart(String productName)  {
		WebElement productNm = getProductByName(productName);
		moveToElement(productNm.findElement(addProductToCart));
		productNm.findElement(addProductToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		NavigationOptions navigator=new NavigationOptions(driver);
		return navigator;
		
	}
	
	public void verifyCartItems(String productName) {
		List<WebElement>cartItemList=cartItems;	
		Boolean match=cartItemList.stream().anyMatch(items->items.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(productName));
//		Assert.assertTrue(match);
		checkoutButton.click();
	}
	
	
	public void placeOrder(String countryInputVal) {
		sendKeysToElement(countryInput,countryInputVal);
		driver.findElement(By.xpath("//*[@class='ta-backdrop']/../button[2]")).click();		
		//placeOrderButton.click();
		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
	}
	
	

}