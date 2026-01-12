package TestAutomationSuite.BaseObjectDirectory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;	
	String browserName;
	
	
	public void InitiazeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty
				("user.dir")+"//src//test//java//TestAutomationSuite//BaseObjectDirectory//Global.properties");
		prop.load(fis);
		browserName=prop.getProperty("browser");
	
		if (browserName.equalsIgnoreCase("Chrome")){
	WebDriverManager.chromedriver().setup();	
	driver=new ChromeDriver();
		}
		else if
			(browserName.equalsIgnoreCase("FireFox")){
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
			}
		else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	driver.manage().window().maximize();
	}
	
		
}
