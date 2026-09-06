package Creation;

import static org.testng.Assert.fail;
import org.testng.ITestResult;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

import org.testng.annotations.Parameters;

import Utilities.Actionspage;
import Utilities.Browsers;
import Utilities.Database;
import Utilities.Extentlogger;
import Utilities.Handler;
import Utilities.Page;
import Utilities.jsonReader;
import io.reactivex.rxjava3.functions.Action;


public class EcommerceTest extends Main{
	
	
	

	

	
	
	public EcommerceTest() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	private String invoicenumber = "";
	


	
	@Test
	public void usertest() throws IOException {
		
		SoftAssert softAssert = new SoftAssert();
		Extentlogger.createTest("Userworkflow");
		
		try {
			
			
			
			
			
			common.navigate();
			common.customerlogin();
		
		
		
			common.userverifyshopmodule();
			
			
			action.thinktime();
			
			common.userselectshopmodule("Women Fashion");
		
			common.goback();
		
			common.userselectshopmodule("Men Fashion");
		
			common.searchproduct("Pant",softAssert);
		
			common.sortby("Name: Z to A",softAssert);
		
			common.verifyfilters("Formal,Footwear,$0 - $100,$101 - $200,$201 - $300,$301 - $400,$401 - $500,Small,Medium,Large,Extra Large,Double Extra Large,Black,White,Red,Blue,Green");
		
			common.filter("Formal",softAssert);
		
			common.filter("Footwear",softAssert);
			
			common.addtocart("White Pant",softAssert);
	
			common.addtocart("White Pant",softAssert);
	
			common.addtocart("Red Pant",softAssert);

			common.addtocart("Green Pant",softAssert);

			common.addtocart("Black Pant",softAssert);
			
			
			
			common.goback();
			
			common.userselectshopmodule("Electronics");
			
			common.verifyfilters("Mobile,Laptop,Fridge,TV,Monitor,$0 - $100,$101 - $200,$201 - $300,$301 - $400,$401 - $500,Samsung,LG,Panasonic,Toshiba,Sony");
			
			common.addtocart("LG Mobile",softAssert);
			
			common.addtocart("Samsung Laptop",softAssert);
			
			action.click(driver.findElement(By.xpath("//a[@title=\"Cart\"]")));
			
			
			action.verifycurrentURL("https://shop.qaautomationlabs.com/cart");
			
			
			common.addquantitytoitem("Green Pant", 5, softAssert);
			
			common.reducequantitytoitem("Green Pant", 3, softAssert);

			common.verifycartitem();

			common.verifycartitemquantityprice(softAssert);
			
			

			common.verifytotalcart();
			
			
			common.deleteitemfromcart("Green Pant",softAssert);
			
			common.verifycartitemquantityprice(softAssert);
			
			
			
			common.verifytotalcart();
			
			
			action.click(driver.findElement(By.xpath("//a[@id=\"checkoutBtn\"]")));
			
			
			action.verifycurrentURL("https://shop.qaautomationlabs.com/checkout");
			
			common.populatebillingaddress();
			
			action.click(driver.findElement(By.xpath("//button[@id=\"continue\"]")));
			
			action.verifycurrentURL("https://shop.qaautomationlabs.com/confirm");
			
			
			common.verifyconfirmdetails();
			
			
			action.click(driver.findElement(By.xpath("//a[@title=\"Place Order\"]")));
			
			
			softAssert.assertAll();
			
		} catch (Exception e) {
			
			
			log.scenario.fail("Failure to go through User workflow");
			log.onTestFailure("Fail");
			
			fail("Your failure message here");	
			
			
			
		}
		
		
		
		
		
	}
	
		
	


}		
	
	
	


