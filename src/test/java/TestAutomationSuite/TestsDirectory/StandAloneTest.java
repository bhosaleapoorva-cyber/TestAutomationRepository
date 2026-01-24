package TestAutomationSuite.TestsDirectory;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestAutomationSuite.BaseObjectDirectory.BaseClass;
import TestAutomationSuite.Pageobjects.LoginPage;
import TestAutomationSuite.Pageobjects.NavigationOptions;
import TestAutomationSuite.Pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseClass {

	@Test
	public void SubmitOrder() throws IOException {
		
		String[] dressCode={"ZARA COAT 3","ADIDAS ORIGINAL"};
		String itemName="ZARA COAT 3";
		String country="India";		
		loginpage=LaunchApplication();
		ProductCatalogue productCatalogue=loginpage.loginApplication("apurvatest@gmail.com","Elixir123!");
		List<WebElement>itemList=productCatalogue.getProductList();
		productCatalogue.getProductByName(itemName);
		NavigationOptions navigator=productCatalogue.addToCart(itemName);	
		navigator.navigationHeader();
		productCatalogue.verifyCartItems(itemName);
		productCatalogue.placeOrder(country);
		

		
	}
	
	
	
}
