package TestAutomationSuite.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAutomationSuite.AbstractMethods.AbstractMethods;

public class SearchingFilters extends AbstractMethods {

	WebDriver driver;
	public SearchingFilters(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this.driver);
	}

	
	@FindBy(xpath="//section[@id='sidebar']/form/div[1]/input")
	WebElement searchField;
	
	@FindBy(xpath="//*[@id='sidebar']/form/div[2]/div/div[1]/input")
	WebElement minValue;
	
	@FindBy(xpath="//*[@id='sidebar']/form/div[2]/div/div[2]/input")
	WebElement maxValue;
	
	
	
	public void enter_product_for_search(String searchproduct) {
		searchKeyword_on_tabOut(searchField,searchproduct);		
	}
	
	public void add_min_max_val(String min,String max) {
		searchKeyword_on_tabOut(minValue,min);
		searchKeyword_on_tabOut(maxValue,max);
	}
	
	
	
	
	
}
