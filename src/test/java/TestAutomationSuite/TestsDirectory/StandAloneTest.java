package TestAutomationSuite.TestsDirectory;


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

import TestAutomationSuite.BaseObjectDirectory.BaseClass;
import TestAutomationSuite.Pageobjects.LoginPage;
import TestAutomationSuite.Pageobjects.NavigationOptions;
import TestAutomationSuite.Pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseClass {

	public static void main(String[] args) {
		
		String[] dressCode={"ZARA COAT 3","ADIDAS ORIGINAL"};
		String itemName="ZARA COAT 3";
		String country="India";

		

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
//		driver.manage().window().maximize();			
		LoginPage loginpage=new LoginPage(driver);
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		NavigationOptions navigator=new NavigationOptions(driver);
		loginpage.goToUrl("https://rahulshettyacademy.com/client");
		loginpage.loginApplication("apurvatest@gmail.com","Elixir123!");		
		List<WebElement>itemList=productCatalogue.getProductList();
		productCatalogue.getProductByName(itemName);
		productCatalogue.addToCart(itemName);	
		navigator.navigationHeader();
		productCatalogue.verifyCartItems(itemName);
		productCatalogue.placeOrder(country);
		
//		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
//		WebElement prod = products.stream()
//				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(itemName)).findFirst()
//				.orElse(null);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		//js.executeScript("window.scrollBy(0,2000)");
//		//js.executeScript("arguments[0].scrollIntoView();",prod.findElement(By.cssSelector(".card-body")));
//		Actions action=new Actions(driver);
//		action.moveToElement(prod.findElement(By.cssSelector(".card-body button:last-of-type"))).build().perform();
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
					
					
		
//		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
//		List<WebElement> cartItems=driver.findElements(By.cssSelector(".cartSection"));
//		Boolean match=cartItems.stream().anyMatch(items->items.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(itemName));
//		Assert.assertTrue(match);
//		driver.findElement(By.cssSelector(".totalRow button")).click();
//		Actions a=new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
//		driver.findElement(By.xpath("//*[@class='ta-backdrop']/../button[2]")).click();
//		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
		
	}
	
}
