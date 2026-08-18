package Creation;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;

import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;

import Utilities.Actionspage;
import Utilities.Browsers;
import Utilities.Database;
import Utilities.Extentlogger;
import Utilities.Handler;
import Utilities.Page;
import Utilities.Verification;
import Utilities.jsonReader;
import io.reactivex.rxjava3.functions.Action;
import org.testng.ITestResult;

public class Main {
	
	
	
	
	public static Browsers browser = new Browsers("chrome");
	static Actionspage action = new Actionspage();
	public static Page elements = new Page();
	static Verification verif = new Verification(null);
	public static Database db = new Database();
	
	public static Extentlogger log = new Extentlogger();
	static Handler handle = new Handler();
	
	
	public static jsonReader jReader = new jsonReader();
	
	@BeforeTest
	public void  logger () {
		
		log.initializereport();
		
	}
	
	
	
	
	@BeforeMethod
	@Parameters({"casename"})
	public void  createtest (String casename) {
		
		
		log.casename = casename;
		log.configuretestname();
		
		log.createTest(casename);
		
		
		
	}
	

	
	@AfterTest
	
	public void fluush () {
		
		
		log.report.flush();
		
		
	}
	
	
}
