package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import Creation.Main;

public class Handler {

	private WebDriver driver;
	private Extentlogger log;
	
	public Handler(WebDriver driver, Extentlogger log) {
		
		this.driver = driver;
        this.log = log;	
	  
		

		// TODO Auto-generated constructor stub
	}
	
	
	String currentWindow;
	
	
	
	
	
	
	public void nameofhandler () {
		
		
		System.out.println(driver.getTitle() + " " + currentWindow);
		
		
		
	}
	
	
	public void switchframe (String title) {
		
		try {
			
			for (String windowHandle : driver.getWindowHandles()) {
			    if(driver.switchTo().window(windowHandle).getTitle().equals(title)) {
			        driver.switchTo().window(windowHandle);
			        break;
			        
			    }
			    
			    
			    
			    
			}
			
			
			
			
			log.scenario.pass("Successfully switched frame");
			
			
		} catch (Exception e){
			
			log.scenario.fail("Unsuccessfull switching of frame");
	
		}
		
		
		
		
	}
	
	public void switchtab (Integer number) {
		
	 try {
			
		 
		 List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		 
		 
		 if (tabs.size() != 0) {
		 driver.switchTo().window(tabs.get(number));
		 
			log.scenario.pass("Successfully switched tab");
			
		 } else {
			 
			 log.scenario.fail("Unsuccessfull switching of tab"); 
			 
			 
		 }
		} catch (Exception e){
			
			log.scenario.fail("Invalid tab");
	
		}
		
		
		
		
	}
	
	
	public void switchdefaultframe () {
		
		
		try {
		
		
		
	driver.switchTo().defaultContent();
			
			
			
			
	System.out.println("Switch successful");
			
		} catch (Exception e){
			
			log.scenario.fail("Unsuccessfull switching of frame");
	
		}
		
		
		
		
	}
	
	public String getcurrentwindow () {
		
		
		return driver.getWindowHandle();
	}
	
	
}
