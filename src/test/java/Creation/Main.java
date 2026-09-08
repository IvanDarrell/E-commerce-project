package Creation;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;

import Utilities.Actionspage;
import Utilities.Browsers;
import Utilities.Database;
import Utilities.Extentlogger;
import Utilities.Handler;
import Utilities.Page;
import Utilities.jsonReader;
import io.reactivex.rxjava3.functions.Action;
import org.testng.ITestResult;

public class Main {

	
	

	 
	protected WebDriver driver;
    protected Page elements;
    protected Actionspage action;
    protected Common common;

    protected Browsers browser;
    protected Database db;
    protected jsonReader jReader;
    protected Extentlogger log;
    protected Handler handle;

 
	@BeforeTest
	public void logger() throws NoSuchFieldException, SecurityException {

		log.initializereport();
		
		
		
	}
	
	

	@BeforeMethod
	public void test () {
		browser = new Browsers();

        driver = Browsers.set("chrome");
        
        System.out.println("Driver = " + driver);

        // Now everything that requires driver
        // can be created safely.
        elements = new Page(driver);
        
        
        log = new Extentlogger(driver);
        
        action = new Actionspage(driver,log);

        handle = new Handler(driver,log);

        db = new Database(driver);

        jReader = new jsonReader();

        
        
        common = new Common(browser,
                driver,
                elements,
                action,
                log,
                handle,
                db,
                jReader
            );
	    
	  
	
	}
	
	

	@AfterMethod

	public void flush() {
		
		log.report.flush();
		
		driver.close();
		
	}
	
	

}
