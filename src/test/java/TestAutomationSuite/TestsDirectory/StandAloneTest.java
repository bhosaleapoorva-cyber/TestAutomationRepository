package TestAutomationSuite.TestsDirectory;

import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestAutomationSuite.BaseObjectDirectory.BaseClass;
import TestAutomationSuite.Pageobjects.LoginPage;
import TestAutomationSuite.Pageobjects.NavigationOptions;
import TestAutomationSuite.Pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseClass {

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void SubmitOrder(String email, String password,String productname) throws IOException {
		
		String[] dressCode={"ZARA COAT 3","ADIDAS ORIGINAL"};
		String itemName="ZARA COAT 3";
		String country="India";		
		loginpage=LaunchApplication();
		ProductCatalogue productCatalogue=loginpage.loginApplication(email,password);
		List<WebElement>itemList=productCatalogue.getProductList();
		productCatalogue.getProductByName(productname);
		NavigationOptions navigator=productCatalogue.addToCart(productname);	
		navigator.navigationHeader();
		productCatalogue.verifyCartItems(productname);
		productCatalogue.placeOrder(country);
		
	}
	@DataProvider
	public Object[][] getData() {
		
//		HashMap<String,String> hm=new HashMap<String,String>();
//		hm.put("email","apurvatest@gmail.com");
//		hm.put("password","Elixir123!");
//		hm.put("product","ZARA COAT 3");
//		
//		
//		HashMap<String,String> hm1=new HashMap<String,String>();
//		hm1.put("email","apurvatest@gmail.com");
//		hm1.put("password","Elixir123!");
//		hm1.put("product","ZARA COAT 3");
		//getJsonDataToString("\"//src/test/java/TestAutomationSuite/TestData/Data.json\"");
		
		return new Object[][] {{"apurvatest@gmail.com","Elixir123!","ZARA COAT 3"}};
		//return new Object[][] {{hm},{hm1}};
	}
	
	
	
}
