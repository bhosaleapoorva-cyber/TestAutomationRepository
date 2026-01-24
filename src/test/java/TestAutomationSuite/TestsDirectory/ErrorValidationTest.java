package TestAutomationSuite.TestsDirectory;
import TestAutomationSuite.BaseObjectDirectory.TestObjects;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestAutomationSuite.BaseObjectDirectory.BaseClass;

public class ErrorValidationTest extends BaseClass {

	@Test(groups={"ErrorHandling"})
	public void ErrorValidation() throws IOException {
		String itemName="ZARA COAT 3";
		LaunchApplication();
		loginpage.loginApplication("apurvatest@gmail.com","Eliyxir123!");

		
	}}
