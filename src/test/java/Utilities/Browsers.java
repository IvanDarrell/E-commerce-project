package Utilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import Creation.Main;

public class Browsers {

	private WebDriver driver;

	/*
	 * public Browsers (String browser) {
	 * 
	 * Browsers.driver = set(browser);
	 * 
	 * }
	 */
	
	private final String execution;
    private final String seleniumUrl;
    
    
    public Browsers () {
    	
    	execution = System.getProperty("execution", "docker");

        seleniumUrl = System.getProperty(
            "selenium.url",
            "http://localhost:4444"
        );
    	
    	
    	
    	
    }
    
	public WebDriver set(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            if (execution.equalsIgnoreCase("docker")) {

                try {
                    driver = new RemoteWebDriver(
                        new URI(seleniumUrl).toURL(),
                        options
                    );

                    return driver;

                } catch (
                    MalformedURLException |
                    URISyntaxException e
                ) {
                    throw new RuntimeException(
                        "Unable to connect to Selenium Grid: "
                        + seleniumUrl,
                        e
                    );
                }

            } else {

                driver = new ChromeDriver(options);
                return driver;
            }
        } 
		
		
		if (browser.equalsIgnoreCase("edge"))

         {
        	EdgeOptions options = new EdgeOptions();
            
            // Add argument to start maximized
            options.addArguments("--start-maximized");
            
            
            
            
            if (execution.equalsIgnoreCase("docker")) {

                try {
                    driver = new RemoteWebDriver(
                        new URI(seleniumUrl).toURL(),
                        options
                    );

                    return driver;

                } catch (
                    MalformedURLException |
                    URISyntaxException e
                ) {
                    throw new RuntimeException(
                        "Unable to connect to Selenium Grid: "
                        + seleniumUrl,
                        e
                    );
                }

            } else {

            	 driver = new EdgeDriver(options);
                 return driver;
            }

           
        }
		
		
		if (browser.equalsIgnoreCase("firefox"))

        {
			FirefoxOptions options = new FirefoxOptions();
           
           // Add argument to start maximized
           options.addArguments("--start-maximized");
           
           
           
           
           if (execution.equalsIgnoreCase("docker")) {

               try {
                   driver = new RemoteWebDriver(
                       new URI(seleniumUrl).toURL(),
                       options
                   );
                   driver.manage().window().maximize();
                   return driver;

               } catch (
                   MalformedURLException |
                   URISyntaxException e
               ) {
                   throw new RuntimeException(
                       "Unable to connect to Selenium Grid: "
                       + seleniumUrl,
                       e
                   );
               }

           } else {

           	 driver = new FirefoxDriver(options);
           	driver.manage().window().maximize();
                return driver;
           }

          
       }

        throw new IllegalArgumentException(
            "Unsupported browser: " + browser
        );
	    }

	

<<<<<<< HEAD
	public void getdriver() {

=======
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
		
>>>>>>> branch 'master' of https://github.com/IvanDarrell/E-commerce-project.git
		System.out.print(driver);

	}

	public void startbrowser(String url) {

		driver.get(url);

	}

}
