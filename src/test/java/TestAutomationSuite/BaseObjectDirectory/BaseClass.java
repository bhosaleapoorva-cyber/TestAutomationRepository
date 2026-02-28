package TestAutomationSuite.BaseObjectDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import TestAutomationSuite.Pageobjects.LoginPage;
import TestAutomationSuite.Pageobjects.NavigationOptions;
import TestAutomationSuite.Pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	String browserName;
	String url;
	public LoginPage loginpage;

	public WebDriver InitializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//test//java//TestAutomationSuite//BaseObjectDirectory//Global.properties");
		prop.load(fis);
		browserName = prop.getProperty("browser");
		url=prop.getProperty("url");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
//		public void getJsonDataToString(String path) throws IOException {
//				
//				//json to string
//				String json=FileUtils.readFileToString
//						(new File(System.getProperty("user.directory")+path),StandardCharsets.UTF_8);
//			
//					//string to hashmap
//				ObjectMapper mapper=new ObjectMapper();
//			List<HashMap<String,String>> maps=	mapper.readValue(json, new TypeReference<List<HashMap<String,String>>>(){
//					
//				
//				
//				});
//			return maps;
//			}
	
	@BeforeTest
	public LoginPage LaunchApplication() throws IOException {
		driver=InitializeDriver();
		loginpage=new LoginPage(driver);
		loginpage.goToUrl(url);	
		return loginpage;
	}
	
//	public LoginPage CreateObjects() {  Just tried creating a random object creation method.
//		LoginPage loginpage1=new LoginPage(driver);
//		return loginpage1;
//	}
//	
	
	public String ScreenshotOnFailure(String testcasename,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File destination=new File(System.getProperty("user.dir"+"\\records\\"+testcasename+".png"));
	FileUtils.copyFile(source, destination);
	return System.getProperty("user.dir"+"\\records\\"+testcasename+".png");
	
	

	}
	@AfterMethod(alwaysRun=true)
	public void TearDown() {
		driver.close();
	}

	
	
}
