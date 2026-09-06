package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import Creation.Main;

public class Browsers {

	
	
	private static WebDriver driver;
	
	
	
	/*
	public Browsers (String browser) {
		
		Browsers.driver = set(browser);
	
	}
	*/
	

	public static WebDriver set (String browser) {
		
		
		if (browser.equals("chrome")) {
			
			
	
			ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");

        // Headless mode for GitHub Actions
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
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
	
	public void getdriver () {
		
		System.out.print(driver);
		
		
	}
	
	public void  startbrowser (String url) {
		
			 driver.get(url);
			 
			
		
	}
	
	

	
	
}
