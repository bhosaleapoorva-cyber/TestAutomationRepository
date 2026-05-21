package cucumberOptions;

//import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature", glue="StepDefination.StepDefination",
monochrome=true,tags="@Regression",plugin= {"html:target/cucumber.html"})  //helper attributes

public class TestRunner extends AbstractTestNGCucumberTests{

}
