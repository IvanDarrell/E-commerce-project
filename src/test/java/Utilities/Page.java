package Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.reflect.Field;
import Creation.Common;
import Creation.Main;

public class Page {
	
	 private WebDriver driver;

	    public Page(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	
	
	



@FindBy(xpath="//div[@id=\"tr_type_panel\"]//span[@class=\"text-sm whitespace-nowrap\"]")


public List<WebElement> tourType;


@FindBy(xpath="//span[contains(., 'Economy')]//parent::button//following-sibling::div/div")


public List<WebElement> economytypes;


	
	public static WebElement element;


	

@FindBy(xpath="//input[@id='email']")



	public WebElement email;


@FindBy(xpath="//input[@id='password']")



public WebElement password;



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
			
		}  else if (driver.findElements(By.xpath("//*[contains(text(), '" + name + "')]")).size() != 0)
			
		{
			
			 element = driver.findElement(By.xpath("//*[contains(text(), '" + name + "')]"));
				
			
		}  else if (driver.findElements(By.xpath("//input[@placeholder='"+  name  +"']")).size() != 0)
			
		{
			
			 element = driver.findElement(By.xpath("//input[@placeholder='"+  name  +"']"));
				
			
		}  
			
			else {
			

				element = null;
			
			
			
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
	
	

public WebElement dropdown (String name) {
	
	if (driver.findElements(By.xpath("//*[contains(text(), '"+ name  +"')]/parent::div/parent::div[@class=\"w-full inline-flex items-center gap-2 justify-between h-[42px] px-3 rounded-md text-sm font-medium text-gray-700 hover:bg-[#f2f4f7] cursor-pointer border border-gray-200\"]")).size() != 0) {
		
		
		 element = driver.findElement(By.xpath("//*[contains(text(), '"+ name  +"')]/parent::div/parent::div[@class=\"w-full inline-flex items-center gap-2 justify-between h-[42px] px-3 rounded-md text-sm font-medium text-gray-700 hover:bg-[#f2f4f7] cursor-pointer border border-gray-200\"]"));
		
	}  else if (driver.findElements(By.xpath("//*[normalize-space(text())='"+ name  +"']")).size() != 0) {
		
		
		 element = driver.findElement(By.xpath("//*[normalize-space(text())='"+ name  +"']"));
		
	} else if  (driver.findElements(By.xpath("//span[normalize-space(text())='" + name + "']")).size() != 0) {
		
		 element = driver.findElement(By.xpath("//span[normalize-space(text())='" + name + "']"));
		
	} else if  (driver.findElements(By.xpath("//h3[contains(normalize-space(.), '" + name + "')]/../../following-sibling::div/table/tbody/tr/td/select")).size() != 0) {
		
		 element = driver.findElement(By.xpath("//h3[contains(normalize-space(.), '" + name + "')]/../../following-sibling::div/table/tbody/tr/td/select"));
		
	} else if  (driver.findElements(By.xpath("//h3[contains(normalize-space(.), '" + name + "')]/../../following-sibling::div/table/tbody/tr/td/select")).size() != 0) {
		
		 element = driver.findElement(By.xpath("//h3[contains(normalize-space(.), '" + name + "')]/../../following-sibling::div/table/tbody/tr/td/select"));
		
	}
	else {
		

		System.out.println( name + " Text is not valid or not visible");
		
		
		
	}
	
	
	
	return element;
	
	
	
	

}


public WebElement input (String name) {
	
	if (driver.findElements(By.xpath("//input[contains(@placeholder, '"+ name +"')]")).size() != 0) {
		
		element = driver.findElement(By.xpath("//input[contains(@placeholder, '"+ name +"')]"));
		
		
	} else if (driver.findElements(By.xpath("//input[@placeholder='" + name + "']")).size() != 0 ) {
		
		element = driver.findElement(By.xpath("//input[@placeholder='" + name + "']"));
		
	} else if (driver.findElements(By.xpath("//input[contains(@title, '"+name+"')]")).size() != 0 ) {
		
		element = driver.findElement(By.xpath("//input[contains(@title, '"+name+"')]"));
		
	} else {
		

		System.out.println( name + " Input is not valid or not visible");
		
		
		
	}
	
	
	
	
	return element;
}

public WebElement textarea (String name) {
	
	if (driver.findElements(By.xpath("//textarea[contains(@placeholder, '"+ name +"')]")).size() != 0) {
		
		element = driver.findElement(By.xpath("//textarea[contains(@placeholder, '"+ name +"')]"));
		
		

		
	} else {
		

		System.out.println( name + " Input is not valid or not visible");
		
		
		
	}
	
	
	
	
	return element;
}








public static void main (String [] args) {
	
	//System.out.println(driver);
	//System.out.println(ads);
}


}
