package StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestAutomationSuite.BaseObjectDirectory.BaseClass;
import TestAutomationSuite.Pageobjects.NavigationOptions;
import TestAutomationSuite.Pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseClass{

	ProductCatalogue productCatalogue;
	NavigationOptions navigator;
	String country="India";		
	
	@Given("I landed on ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		loginpage=LaunchApplication();		
	}
	
	@Given("Logged in with username {string} and password {string}")
	public void logged_in_with_username_and_password(String username,String password)
	//@Given("^Logged in with username (.+) and password (.+)$")
//	public void Logged_in_with_username_and_password(String username,String password)
	{
		productCatalogue=loginpage.loginApplication(username,password);
		
	}
	
	@When("I add product {string} to the cart")
	public void I_add_product_to_the_cart(String productname) {
		List<WebElement>itemList=productCatalogue.getProductList();
		productCatalogue.getProductByName(productname);
		navigator=productCatalogue.addToCart(productname);			
	}
	
	@When("When submit button is clicked")
	public void When_submit_button_is_clicked(String productname) {
		navigator.navigationHeader();
		productCatalogue.verifyCartItems(productname);		
		}
	
	@Then("^Then complete the purchase of (.+)$")
	public void Then_complete_the_purchase_of_productname(){
		productCatalogue.placeOrder(country);
	}
	
	@Then("Then verify the invalid credential message {string}")
	public void Then_verify_the_invalid_credential_message(String string) {
		Assert.assertEquals(string,"Incorrect username and password");
	}
	
	
	
	
	
	}

