package TestAutomationSuite.TestsDirectory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestAutomationSuite.BaseObjectDirectory.BaseClass;
import TestAutomationSuite.BaseObjectDirectory.FakerUtils;
import TestAutomationSuite.Pageobjects.ProductCatalogue;


public class SearchTest extends BaseClass {

	//Browser launch is handled by BeforeTest method in baseclass.

	//(dataProvider="LoginCredentials")
	@BeforeMethod
	@Test
	public void commonLogin() throws IOException {		
		loginpage.loginApplication("apurvatest@gmail.com","Elixir123!");
			
	}
	
	
	@Test
	public void searchProduct_onTextFilter() {
		//dynamic values
		searchf.enter_product_for_search(FakerUtils.getProductName());//directly called this class's object as its present in the baseclass	
	}
	
	
	
	@Test
	public void searchProduct_minmaxRange() {
		//static value
		String min=FakerUtils.getminval();
		String max=FakerUtils.getmaxval();
		searchf.add_min_max_val(min,max);
		
		
	}
	
	@DataProvider
	public Object LoginCredentials() {
		return new Object[][] {
			{"apurvatest@gmail.com","Elixir123!"}
		};
		
	}
}
