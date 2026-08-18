package Creation;

import static org.testng.Assert.fail;
import org.testng.ITestResult;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

import org.testng.annotations.Parameters;

import Utilities.Browsers;
import Utilities.Extentlogger;
import Utilities.Page;
import Utilities.Verification;
import io.reactivex.rxjava3.functions.Action;
import jdk.internal.org.objectweb.asm.commons.Method;

public class Youtube extends Main {
	
	WebDriver driver = Browsers.driver;
	
	
	public Youtube(String browser) {
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	Extentlogger log = Main.log;
	
	

		
	public static String dbconnection = "no";
	
	public static String json = "disabled";

	
	@Test
	@Parameters({"casename"})
	public void navigate () throws IOException {
		
		
	
		try {
		
			

	    if (dbconnection.equals("yes") && json.equals("disabled")) {
	    	
		browser.startbrowser(db.url);
		action.verifycurrentURL(db.url);
	    
	    } else if (dbconnection.equals("no") && json.equals("enabled"))  {
	    	
	    	
	    	browser.startbrowser(jReader.getUrl());
	    	action.verifycurrentURL(jReader.getUrl());
	    	
	    }
	    
	    
	    else {
	    	
	    browser.startbrowser("https://www.youtube.com/");	
	    action.verifycurrentURL(jReader.getUrl());	
	    } 
	    
	    
	    
	    /*
	    action.thinktime();

		action.implicitwait();
		action.click(elements.button("I am 18 or older - Enter"));
		action.thinktime();
		
		
		
		action.thinktime();
		action.fluentwait(elements.text("Porn Videos"));
		action.hovertoelement(elements.text("Porn Videos"));
		action.thinktime();
		action.implicitwait();
		action.click(elements.icon("Hottest"));
		*/
		
		} catch (Exception e) {
		
			
			log.scenario.fail("Redirection to the site is unsuccessful");
			log.onTestFailure("Fail");
			
			fail("Your failure message here");	
			
			
		} 
			
			
			
		
		
		
		
	}
	
	@Test
	@Parameters({"casename"})
	public void playvideo () throws IOException {
		
		
		
		try {
			
			
		
		action.thinktime();
		action.waituntilvisible(elements.video("They Were Pure Perfection"));
		action.click(elements.video("They Were Pure Perfection"));
		action.thinktime();
		
		
		
		
		
		
			
		action.thinktime();
		
		
		
		action.thinktime();
		
		action.click(elements.video("They Were Pure Perfection"));
		action.implicitwait();
		
		
		
		} catch (Exception e) {
		
			
			log.scenario.fail("Unable to manipulate the video");
			log.onTestFailure("Fail");
			fail("Your failure message here");	
			
			
		} 
			
			
			
		
		
		
		
	}
	
	
	@Test
	@Parameters({"casename"})
	public void windowhandling() {
		
		
		try {
			
			browser.startbrowser("https://www.hyrtutorials.com/p/window-handles-practice.html");
			action.thinktime();
			action.waituntilvisible(elements.button("Open New Window"));
			action.click(elements.button("Open New Window"));
			handle.switchframe("Basic Controls - H Y R Tutorials");
			action.thinktime();
			
			
			action.thinktime();
			action.hovertoelement(elements.text("First Name"));
		    action.thinktime();
		    action.entertext(elements.input("First Name"), "Etits" );
			 
			     
			
		
			
			
			handle.switchtab(0);
			
			
			
		} catch (Exception e) {
			
				
			
		}
		
			
		
	}
	
	

}
