package TestAutomationSuite.AbstractMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {

	WebDriver driver;
	Actions action;
	
	
	public AbstractMethods(WebDriver driver) {
		this.driver=driver;
		this.action=new Actions(driver);
		PageFactory.initElements(driver,this);
		
		
	}

	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	//Actions action=new Actions(driver);

	
	public void waitForElementToAppear(By findBy){	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement element1){	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(element1));
	}
	

	public void waitForElementToDisappear(WebElement ele){	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void moveToElement(WebElement elementToView) {
	//	Actions action=new Actions(driver);
		action.moveToElement(elementToView).build().perform();
	}

	public void sendKeysToElement(WebElement element,String inputValue) {
		//Actions action=new Actions(driver);
		action.sendKeys(element,inputValue).build().perform();
	}
	
	public void searchKeyword_on_tabOut(WebElement searchfield,String keyword) {
	//	Actions action=new Actions(driver); 
		action.sendKeys(searchfield,keyword).sendKeys(Keys.TAB);
	}
	
	
	
	
	
}