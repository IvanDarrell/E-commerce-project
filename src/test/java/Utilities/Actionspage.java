package Utilities;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import Creation.Main;

public class Actionspage {
	
	private WebDriver driver;
    private Extentlogger log;
	

	public Actionspage(WebDriver driver, Extentlogger log) {
		
		this.driver = driver;
        this.log = log;	
        
	}
	
	ITestResult result;
	
	
	WebElement element;
	
	public boolean click (WebElement element) {
		
		try {
			
			
			boolean visible = waituntilvisible(element);

	        if (!visible) {
	            return false;
	        }
			
			element.click();
			
			
			log.scenario.pass("Successfully clicked the element " + element);
			
			System.out.println("Successfully clicked the element " + element);
			
			return true;
		} catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");
			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			return false;
		}  catch (ElementClickInterceptedException e) {
			 System.out.println("Element " + element +  " is blocked by another element");
		    log.scenario.fail("Element " + element +" is blocked by another element" , MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (StaleElementReferenceException e) {
			
		    System.out.println("Element " + element +  " became stale.");
		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		}
		
		
		
	}
	
	public boolean hovertoelement (WebElement element) {
		
		try {
			
			boolean visible = waituntilvisible(element);

	        if (!visible) {
	            return false;
	        }
		Actions actions = new Actions(driver);
		
		actions.moveToElement(element).perform();
		
		
		
		log.scenario.pass("Hover to element is " + element +" success");	
		System.out.println("Hover to element is " + element +" success");
			
		return true;	
			
		} catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");
			
			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			 return false;
		} catch (StaleElementReferenceException e) {
		    System.out.println("Element " + element +  " became stale.");
		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		}
		
		
		
	}
	
	
	
	
	public boolean waituntilvisible(WebElement element) {

	    try {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.visibilityOf(element));

	        log.scenario.pass("Element " + element + " is displayed");

	        return true;

	    } catch (NoSuchElementException e) {

	        System.out.println("Element " + element + " is not existing.");

	        log.scenario.fail(
	                "Element " + element + " is not existing",
	                MediaEntityBuilder
	                        .createScreenCaptureFromBase64String(
	                                Extentlogger.getBase64Screenshot(driver))
	                        .build()
	        );

	        return false;

	    } catch (TimeoutException e) {

	        System.out.println("Element " + element + " did not appear in time.");

	        log.scenario.fail(
	                "Element " + element + " did not appear in time.",
	                MediaEntityBuilder
	                        .createScreenCaptureFromBase64String(
	                                Extentlogger.getBase64Screenshot(driver))
	                        .build()
	        );

	        return false;
	    }
	}
	
	
	public boolean fluentwait (WebElement element) {
		
		
		try {
		
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		log.scenario.pass("Successful Fluent Wait for Element" + element +" is displayed");		
		
		System.out.println("Successful Fluent Wait for Element" + element +" is displayed");
		
		return true;	
		} catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");
			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
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
			
			
		 } catch (NoSuchElementException e) {
				
				System.out.println("Element " + element +  " is not existing.");

				log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
				
			}  catch (ElementClickInterceptedException e) {
				
			    System.out.println("Element " + element +  " was blocked by another element.");

			    log.scenario.fail("Element " + element +" is blocked by another element" , MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());

			} catch (StaleElementReferenceException e) {
			    System.out.println("Element " + element +  " became stale.");
	
			    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());

			} catch (TimeoutException e) {
			    System.out.println("Element " + element + " did not appear in time.");
			    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			}
		
	}
	
	
	
	
	public boolean entertext(WebElement element, String string) {

		try {
		
			boolean visible = waituntilvisible(element);

	        if (!visible) {
	            return false;
	        }
	        
			element.clear();
			element.sendKeys(string);
			//element.sendKeys(Keys.ENTER);
			System.out.println("Entered text to " + element);
			log.scenario.pass("Entered text to " + element);
			
			return true;
		}catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");

			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			return false;
		}  catch (StaleElementReferenceException e) {
		    System.out.println("Element " + element +  " became stale.");
		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		}
		
		
		
	}
	
	public void thinktime () throws InterruptedException {
		
		
		
		Thread.sleep(6000);
		System.out.println("Waiting success");
		log.scenario.pass("Waiting success");
		
		
		
	}
	
	
	public boolean verifyText (WebElement element, String expectedValue) {
		
		
		try  {
			
			
			
			if (element.getText().trim().equals(expectedValue)) {
				
				System.out.println("Input Data value is the same as the expected value " + " Current value : " + element.getText().trim() + " Expected Value " + expectedValue );
				
				log.scenario.pass("Input Data value is the same as the expected value " + " Current value : " + element.getText().trim() + " Expected Value " + expectedValue );
				return true;
				
			} else {
				
				
				System.out.println("Input Data value is NOT the same as the expected value " + " Current value : " + element.getText().trim() + " Expected Value " + expectedValue );
				log.scenario.fail("Input Data value is NOT the same as the expected value " + " Current value : " + element.getText().trim() + " Expected Value " + expectedValue );
				
				return false;
			}
			
			
			
			
		} catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");
	
			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			
			return false;
			
		}   catch (StaleElementReferenceException e) {
		    System.out.println("Element " + element +  " became stale.");

		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		    
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		}
		
		
		
		
	}
	
	public boolean verifycurrentURL (String url) {
		
		try  {
			if (driver.getCurrentUrl().contains(url)) {
				
				
				log.scenario.pass("URL is the same Expected : " +  url + ", Current URL " + driver.getCurrentUrl());
				return true;
			}
			
			else {
				
				log.scenario.fail("URL not the same Expected : " +  url + ", Current URL " + driver.getCurrentUrl() ,MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());	
			
				return false;
			}
			
		} catch (Exception e) {
			
			log.scenario.fail("Browser incorrect",MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());	
			return false;
			
			
			
		}
		
		
		
		
	}
	
	
	public boolean waituntilclickable (WebElement element) {
		
		try {
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			return true;
		} catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");

			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			return false;
		}  catch (ElementClickInterceptedException e) {
			
		    System.out.println("Element " + element +  " was blocked by another element.");

		    log.scenario.fail("Element " + element +" is blocked by another element" , MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (StaleElementReferenceException e) {
		    System.out.println("Element " + element +  " became stale.");
		    
		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		}
		
		
	}
	
	
	public boolean clickbyjava (WebElement element) {
		
		try {
		
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
		 	//waituntilvisible(element);
		 
		
			 
			 js.executeScript("arguments[0].click();", element);
			 log.scenario.pass("Element successfully clicked");
			 
		
		
			 return true;
		
		}catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");
		
			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			return false;
		}  catch (ElementClickInterceptedException e) {
			
		    System.out.println("Element " + element +  " was blocked by another element.");
		 
		    log.scenario.fail("Element " + element +" is blocked by another element" , MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (StaleElementReferenceException e) {
		    System.out.println("Element " + element +  " became stale.");
	
		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		
		    return false;
		}
		
	}
	
	
	public boolean selectdropdownvalue(WebElement element, String value) {
		
		try { 
			
			
			boolean visible = waituntilvisible(element);

	        if (!visible) {
	            return false;
	        }
			
			Select dropdown = new Select(element);
			
			
			dropdown.selectByValue(value);
			
			log.scenario.pass(value + " is selected in Dropdown " + element);
			
			
			return true;
			
		} catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");
			
			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			return false;
		}  catch (StaleElementReferenceException e) {
		    System.out.println("Element " + element +  " became stale.");
		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		}
		
		
	}
	
	
	public boolean selectdropdownvaluebytext(WebElement element, String value) {
		
		try { 
			
			boolean visible = waituntilvisible(element);

	        if (!visible) {
	            return false;
	        }
	        
			
			
			Select dropdown = new Select(element);
			
			
			dropdown.selectByVisibleText(value);
			
			log.scenario.pass(value + " is selected in Dropdown " + element);
			
			return true;
			
		} catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");
			
			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			return false;
		}  catch (StaleElementReferenceException e) {
		    System.out.println("Element " + element +  " became stale.");
		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
			}
		
		
	}
	
	
	//This is for input populate then select the result (Not a dropdown)
	public boolean selectvalue (WebElement element, WebElement searchinput, String value) throws InterruptedException {
		
		
		try { 
			
			
			if (element.isDisplayed()) {
				
				
			
				boolean visible = waituntilvisible(element);

		        if (!visible) {
		            return false;
		        }
			
			clickbyjava(element);
			thinktime();
			searchinput.sendKeys(value);
			
			thinktime();
			
			
			
			WebElement valueclicker;
			
			if (driver.findElements(By.xpath("//span[contains(., '" + value + "')]")).size() == 0) {
				
				
				valueclicker = driver.findElement(By.xpath("//div[contains(@class, 'text-xs text-slate-500 truncate') and contains(text(), '" + value + "')]"));
				
				
			}  else {
				
				valueclicker = driver.findElement(By.xpath("//span[contains(., '" + value + "')]"));
				
			}
			
			
			clickbyjava(valueclicker);
			
			log.scenario.pass(value + " is selected in the Input " + element);
			return true;
			} else {
				
				
			log.scenario.fail(value + " failed to be selected in Input " + element);
				
			return false;
				
			}
			
				
			
			
			
		} catch (NoSuchElementException e) {
			
			System.out.println("Element " + element +  " is not existing.");
			
			log.scenario.fail("Element " + element + " is not existing", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
			return false;	
		}  catch (StaleElementReferenceException e) {
		    System.out.println("Element " + element +  " became stale.");
		    log.scenario.fail("Element " + element +  " became stale.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		} catch (TimeoutException e) {
		    System.out.println("Element " + element + " did not appear in time.");
		    log.scenario.fail("Element " + element + " did not appear in time.", MediaEntityBuilder.createScreenCaptureFromBase64String(Extentlogger.getBase64Screenshot(driver)).build());
		    return false;
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
