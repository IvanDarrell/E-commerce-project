package Utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.testng.ITestListener;
import org.testng.ITestResult;


public class Extentlogger {
	
	
	
	static public ExtentReports report;
	static public ExtentTest scenario;
	
	
	WebDriver driver = Browsers.driver;
	
	static public String casename;
	
	public static void  initializereport () {

        // Specify the location of the report
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/IVAN DARRELL/eclipse-workspace/MyCreation/report/Regression " +  timeStamp + ".html");
       
        spark.config().setTheme(Theme.DARK);

        // Create ExtentReports instance

        ExtentReports extent = new ExtentReports();

        // Attach reporter

        extent.attachReporter(spark);
        
        
        Extentlogger.report = extent;
        
         
        
        
        
        
	}
	
	
	public static void createTest (String name) {
		
		
		ExtentTest testcase = report.createTest(name);

		Extentlogger.scenario = testcase;
		
		
		
		
		
		
	}
	
	
	public void configuretestname() {
        // This method can read the shared variable directly
        System.out.println("Configuring environment for: " + this.casename);
    }
	
	
	
	public void onTestFailure(String test) throws IOException {
		
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    
	    File destinationFile = new File("C:/Users/IVAN DARRELL/eclipse-workspace/MyCreation/report/my_screenshot.png");
	    
	    FileUtils.copyFile(screenshot, destinationFile);

	}
	
	
	 public static String getBase64Screenshot(WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	    }
	 
	 
	
	
	 
	 
	 
	 
	
}