package TestAutomationSuite.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAutomationSuite.AbstractMethods.AbstractMethods;

public class LoginPage extends AbstractMethods{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="input#userEmail")
	WebElement email;
	
	@FindBy(css="input#userPassword")
	WebElement password;
	
	@FindBy(css="input#login")
	WebElement login;
	
	public void loginApplication(String email1,String password1) {
		email.sendKeys(email1);
		password.sendKeys(password1);
		login.click();
	}
	
	public void goToUrl(String url) {
		driver.get(url);
	}
}
