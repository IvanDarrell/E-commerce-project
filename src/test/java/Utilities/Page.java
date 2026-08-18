package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Creation.Main;

public class Page  {

	WebDriver driver = Browsers.driver;
	
	public Page() {
		
		
		super();
		

		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public static WebElement element;


	@FindBy(xpath = "//button[contains(text(), 'I am 18 or older - Enter')]")
	public WebElement submitButton;
	
	
	@FindBy(xpath = "//div[@class=\"innerDropdown clearfix js-submenu\"]/div[@class=\"leftPanel videos\"]/ul[@class=\"discover\"]/li/a/i")
	public WebElement topvideo;
	
	
	By searchdrop = By.xpath("div[@class=\"innerDropdown clearfix js-submenu\"]/div[@class=\"leftPanel videos\"]/ul[@class=\"discover\"]/li/a/i"); 
	
	
	
	@FindBy(xpath ="//div[@id=\"firstName\"]")
	
	public static WebElement inputFirst;
	
	
@FindBy(xpath ="//input[@id=\"searchInput\"]")
	
	public static WebElement search;
	
	
@FindBy(xpath ="//div[@class=\"mgp_adRollSkipButtonContent\"]")
	
	public WebElement ads;
	
	public WebElement button (String name) {
		
		
			
		if (driver.findElements(By.xpath("//button[contains(text(),'" + name + "')]")).size() != 0) {
			
			element = driver.findElement(By.xpath("//button[contains(text(),'" + name + "')]"));
			
		} else {
			

			System.out.println( name + " Element is not valid or not visible");
			
			
			
		}
		
		
	
		
		
		
		
		
		
		return element;
	}
	
	
	public WebElement text (String name) {
		
		
		if (driver.findElements(By.xpath("//span[normalize-space(text())='" + name + "']")).size() != 0) {
			
			 element = driver.findElement(By.xpath("//span[normalize-space(text())='" + name + "']"));
			
		} else if (driver.findElements(By.xpath("//*[normalize-space(text())='"+ name  +"']")).size() != 0) {
			
			
			 element = driver.findElement(By.xpath("//*[normalize-space(text())='"+ name  +"']"));
			
		}  else if (driver.findElements(By.xpath("//input[@placeholder='"+  name  +"']")).size() != 0)
			
		{
			
			 element = driver.findElement(By.xpath("//input[@placeholder='"+  name  +"']"));
				
			
		} 
			
			else {
			

			System.out.println( name + " Text is not valid or not visible");
			
			
			
		}
		
		
		
		return element;
	}
	
	
	public WebElement icon (String name) {
		
		
		if (driver.findElements(By.xpath("//i[contains(@class, '"+name +"')]")).size() != 0) {
			
			 element = driver.findElement(By.xpath("//i[contains(@class, '"+name +"')]"));
			
			
		} else {
			

			System.out.println( name + " Icon is not valid or not visible");
			
			
			
		}
		
		
		
		return element;
	}
	
	
public WebElement video (String name) {
		
		
		if (driver.findElements(By.xpath("//a[contains(text(), '"+ name +"')]/parent::span/parent::div/parent::div/parent::div/parent::li")).size() != 0) {
			
			 element = driver.findElement(By.xpath("//a[contains(text(), '" + name + "')]/parent::span/parent::div/parent::div/parent::div/parent::li"));
			
			
		} else if (driver.findElements(By.xpath("//span[contains(text(), '" + name + "')]/parent::h1/parent::div/preceding-sibling::div[@id=\"player\"]/div/div")).size() != 0) {
			
			
			
			element = driver.findElement(By.xpath("//span[contains(text(), '" + name + "')]/parent::h1/parent::div/preceding-sibling::div[@id=\"player\"]/div/div"));
			
			
		} else {
			

			System.out.println( name + " Video is not valid or not visible");
			
			
			
		}
		
		
		
		return element;
	}


public WebElement dropdown (String name) {
	
	if (driver.findElements(By.xpath("//span[normalize-space(text())='" + name + "']")).size() != 0) {
		
		 element = driver.findElement(By.xpath("//span[normalize-space(text())='" + name + "']"));
		
	} else if (driver.findElements(By.xpath("//*[normalize-space(text())='"+ name  +"']")).size() != 0) {
		
		
		 element = driver.findElement(By.xpath("//*[normalize-space(text())='"+ name  +"']"));
		
	} else {
		

		System.out.println( name + " Text is not valid or not visible");
		
		
		
	}
	
	
	
	return element;
	
	
	
	

}


public WebElement input (String name) {
	
	if (driver.findElements(By.xpath("//b[normalize-space(text())='" + name + "']/parent::label/following-sibling::input[contains(@placeholder, '" + name + "')]")).size() != 0) {
		
		element = driver.findElement(By.xpath("//b[normalize-space(text())='" + name + "']/parent::label/following-sibling::input[contains(@placeholder, '" + name + "')]"));
		
		
	} else if (driver.findElements(By.xpath("//input[@placeholder='" + name + "']")).size() != 0 ) {
		
		element = driver.findElement(By.xpath("//input[@placeholder='" + name + "']"));
		
	} else {
		

		System.out.println( name + " Text is not valid or not visible");
		
		
		
	}
	
	
	
	
	return element;
}



}
