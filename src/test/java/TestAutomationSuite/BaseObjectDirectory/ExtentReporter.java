package TestAutomationSuite.BaseObjectDirectory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports configReport() {
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("TestAutomation Report");
		reporter.config().setReportName("Test Cycle Result");
		reporter.config().setTheme(null);
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);   ///attach the objects of above configured report over here.
		extent.setSystemInfo("QA", "Apurva");
		return extent;
		
	}

}
