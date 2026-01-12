package TestAutomationSuite.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAutomationSuite.AbstractMethods.AbstractMethods;

public class NavigationOptions extends AbstractMethods{

	WebDriver driver;
	
	public NavigationOptions(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="button[routerlink=\"/dashboard/cart\"]")
	WebElement addtoCart;
	
	
	public void navigationHeader() {
		moveToElement(addtoCart);
		addtoCart.click();
		
	}
		
}
