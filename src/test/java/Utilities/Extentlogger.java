package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

import Creation.Main;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Extentlogger {

	private WebDriver driver;

	public Extentlogger(WebDriver driver) {
		this.driver = driver;
	}

	private static ThreadLocal<ExtentReports> report = new ThreadLocal<>();

	// Each thread gets its own ExtentTest
	private static ThreadLocal<ExtentTest> scenario = new ThreadLocal<>();
	static public String casename;

	public static synchronized void initializereport(String testName) {


        // Specify the location of the report
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		 String reportPath = "target/report/Regression " + timeStamp + ".html";

		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
       
        spark.config().setTheme(Theme.DARK);


		// Make the TestNG test name safe for a Windows filename
		String safeTestName = testName.replaceAll("[\\\\/:*?\"<>|]", "_");

		

		spark.config().setTheme(Theme.DARK);

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(spark);

		report.set(extent);

		System.out.println("Extent Report Created: " + reportPath);

	}

	public static void createTest(String name) {

		ExtentReports extent = report.get();

		if (extent == null) {
			throw new IllegalStateException("ExtentReports has not been initialized for this thread.");
		}

		ExtentTest testcase = extent.createTest(name);

		scenario.set(testcase);

	}

	public void configuretestname() {
		// This method can read the shared variable directly
		System.out.println("Configuring environment for: " + this.casename);
	}

	public static String getBase64Screenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	public static ExtentTest getScenario() {

		ExtentTest test = scenario.get();

		if (test == null) {
			throw new IllegalStateException("ExtentTest has not been created for this thread.");
		}

		return test;
	}

	public static ExtentReports getReport() {

		ExtentReports extent = report.get();

		if (extent == null) {
			throw new IllegalStateException("ExtentReports has not been initialized for this thread.");
		}

		return extent;
	}

	public static void flushReport() {

		ExtentReports extent = report.get();

		if (extent != null) {
			extent.flush();
			report.remove();
		}

		scenario.remove();
	}

	public void onTestFailure(String test) throws IOException {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(new Date());

		File destinationFile = new File("C:/Users/IVAN DARRELL/eclipse-workspace/" + "E-commerce project/report/"
				+ "screenshot_" + timeStamp + ".png");

		FileUtils.copyFile(screenshot, destinationFile);
	}

}


	
	
	 
 
	 
	 
	


