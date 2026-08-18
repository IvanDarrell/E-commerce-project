package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Browsers {

	
	public static String browser;
	
	public static WebDriver driver;
	
	
	public Browsers (String browser) {
		
		Browsers.driver = set(browser);
	}
	
	
	
	public WebDriver set (String browser) {
		
		
		if (browser.equals("chrome")) {
			
			
	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); 
			driver = new ChromeDriver(options);
			
			 
			 return driver;
			
			
		} else if (browser.equals("edge")) {
			
			driver = new EdgeDriver();
			driver.manage().window().fullscreen();
			
			
			return driver;
			
		} else {
			
			System.out.println("Invalid browser");
			
		}
		return driver;
			
		
	}
	
	public void  startbrowser (String url) {
		
			 driver.get(url);
			 
			
		
	}
	
	

		
	
	
}
