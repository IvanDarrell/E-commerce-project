package Utilities;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import Creation.Main;

public class Actionspage extends Page {
	
	
	
	
	Extentlogger log = Main.log;
	
	WebElement element = Page.element;
	
	
	WebDriver driver = Browsers.driver;
	
	
	
	ITestResult result;
	
	public void click (WebElement element) {
		
		try {
			
			
			element.click();
			
			
			log.scenario.pass("Successfully clicked the element " + element);
			
			System.out.println("Successfully clicked the element " + element);
			
		} catch (Exception e) {
			
			log.scenario.fail("Failed to clicked the element", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			
		}
		
		
		
	}
	
	public void hovertoelement (WebElement element) {
		
		try {
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(element).perform();
		
		
		
		log.scenario.pass("Hover to element is " + element +" success");	
		System.out.println("Hover to element is " + element +" success");
			
			
			
		} catch (Exception e) {
			
			
			
			
			log.scenario.fail("Element " + element + " is not visible", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			fail("Your failure message here");	
		}
		
		
		
	}
	
	
	public void implicitwait() {
		
		try {
		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			System.out.println("Implicit wait successful");
			log.scenario.pass("Implicit wait successful");
		
		
		} catch (Exception e) {
			
			
		log.scenario.fail("Failed to wait",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		
		}
		
		
		
	}
	
	public void waituntilvisible (WebElement element) {
		
		try {
			
			
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(element));
	
		
		log.scenario.pass("Element" + element + " is displayed");		
		
		
		
		} catch (Exception e) {
			
			
			log.scenario.fail("Element " + element + " is not visible",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			fail("Your failure message here");	
			}
		
		
		
	} 
	
	
	public void fluentwait (WebElement element) {
		
		
		try {
		
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		log.scenario.pass("Successful Fluent Wait for Element" + element +" is displayed");		
		
		System.out.println("Successful Fluent Wait for Element" + element +" is displayed");
			
		} catch (Exception e) {
			
			System.out.println("Element " +  element + " is not visible");
			log.scenario.fail("Element " +  element + " is not visible",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			fail("Your failure message here");	
			}
		
		
	}
	
	
	
	
	public void verifydropdownvalues (WebElement element,String expectedvalue) {
		
		
		try {
			
			List <String> expectedvalues  = List.of(expectedvalue.split(","));
			List <String> currentvalues  = new ArrayList<>();
			List<WebElement> elements = driver.findElements(By.tagName("option"));
			
						
			
			for (WebElement e : elements) {
				
				currentvalues.add(e.getText());
				
				
			}
		
		//System.out.println(expectedvalues.size());
		//System.out.println(currentvalues.size());
			
			if (expectedvalues.size() == currentvalues.size()) {
				
				for (int i = 0; i < expectedvalues.size(); i++) {
					
					
					expectedvalues.get(i).equals(currentvalues.get(i));
				
				
				
				}
				log.scenario.pass("Expected values are correct");
			
			} else {
				
				log.scenario.fail("Expected values are incorrect with currentvalues");
				
			}
			
			
		 } catch (Exception e) {
			
			
			
			
			log.scenario.fail("Element is not visible");
			fail("Your failure message here");	
		}
		
	}
	
	
	
	
	public void pausevideo (WebElement element) {
		
		try {
		
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].pause();", element);
			
			
		} catch (Exception e) {
			
			
			log.scenario.fail("Video cannot be play",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		
			
		}
		
		
		
	}
	
	public void entertext(WebElement element, String string) {

		try {
		
			
			element.sendKeys(string);
			element.sendKeys(Keys.ENTER);
			System.out.println("Entered text to " + element);
			log.scenario.pass("Entered text to " + element);
			
			
		} catch (Exception e) {
			
			
			log.scenario.fail("Failed to input keys",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		
			
		}
		
		
		
	}
	
	public void thinktime () throws InterruptedException {
		
		
		
		Thread.sleep(6000);
		System.out.println("Successful thread sleep");
		log.scenario.pass("Thread sleep success");
		
		
		
	}
	
	
	public void verifyText (WebElement element, String expectedValue) {
		
		
		try  {
			
			
			
			if (element.getAttribute("value").equals(expectedValue)) {
				
				System.out.println("Input Data value is the same as the expected value " + " Current value : " + element.getAttribute("value") + " Expected Value " + expectedValue );
				log.scenario.pass("Input Data value is the same as the expected value " + " Current value : " + element.getAttribute("value") + " Expected Value " + expectedValue );
				
				
			} else {
				
				
				System.out.println("Input Data value is NOT the same as the expected value " + " Current value : " + element.getAttribute("value") + " Expected Value " + expectedValue );
				log.scenario.fail("Input Data value is NOT the same as the expected value " + " Current value : " + element.getAttribute("value") + " Expected Value " + expectedValue );
				
				
			}
			
			
			
			
		} catch (Exception e) {
			
			
			log.scenario.fail("Failed to verify the expected value",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());	
			
		}
		
		
		
		
	}
	
	public void verifycurrentURL (String url) {
		
		try  {
		
			if (url.equals(driver.getCurrentUrl())) {
				
				log.scenario.pass("URL is the same");
				
			}
			
			else {
				
				log.scenario.fail("URL not the same",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());	
				fail("Your failure message here");	
			}
			
		} catch (Exception e) {
			
			
			
			log.scenario.fail("Browser incorrect",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());	
			fail("Your failure message here");	
			
			
			
			
		}
		
		
		
		
	}
	
	

	

}
