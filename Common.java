package Creation;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Utilities.Actionspage;
import Utilities.Browsers;
import Utilities.Database;
import Utilities.Extentlogger;
import Utilities.Handler;
import Utilities.Page;
import Utilities.jsonReader;

public class Common {

	private WebDriver driver;
	private Browsers browser;
	private Database db;
	private Page elements;
	private Actionspage action;
	private Extentlogger log;
	private Handler handle;
	private jsonReader jReader;

	public Common(Browsers browser, WebDriver driver, Page elements, Actionspage action, Extentlogger log,
			Handler handle, Database db, jsonReader jReader) {

		this.browser = browser;
		this.db = db;
		this.driver = driver;
		this.elements = elements;
		this.action = action;
		this.log = log;
		this.handle = handle;
		this.jReader = jReader;
	}

	// TODO Auto-generated constructor stub

	public static String dbconnection = "yes";

	public static String json = "disabled";

	public Integer overallcart = 0;

	HashMap<String, Integer> orders = new HashMap<>();
	HashMap<String, Integer> orderprice = new HashMap<>();

	String username = db.data.get("email").toString();
	String password = db.data.get("password").toString();
	String fname = db.data.get("fname").toString();
	String mname = db.data.get("mname").toString();
	String lname = db.data.get("lname").toString();
	String personmail = db.data.get("personemail").toString();
	String mobile = db.data.get("mobile").toString();
	String address = db.data.get("address").toString();
	String state = db.data.get("state").toString();
	String city = db.data.get("city").toString();
	Integer pincode = Integer.parseInt(db.data.get("pincode").toString());


	public void navigate() throws IOException {

		Extentlogger.createTest("Navigate the URL");

		try {

			if (dbconnection.equals("yes") && json.equals("disabled")) {

				browser.startbrowser(db.url);
				action.thinktime();
				boolean urlVerified = action.verifycurrentURL(db.url);

				Assert.assertTrue(urlVerified, "Navigation failed. Expected URL: " + db.url);

			} else if (dbconnection.equals("no") && json.equals("enabled")) {

				browser.startbrowser(jReader.getUrl());
				System.out.println(jReader.getUrl());
				boolean urlVerified = action.verifycurrentURL(jReader.getUrl());

				Assert.assertTrue(urlVerified, "Navigation failed. Expected URL: " + jReader.getUrl());

			}

			else {
				String url = "https://www.youtube.com/";
				browser.startbrowser("https://www.youtube.com/");
				boolean urlVerified = action.verifycurrentURL(url);

				Assert.assertTrue(urlVerified, "Navigation failed. Expected URL: " + url);
			}

		} catch (Exception e) {

			log.scenario.fail("Redirection to the site is unsuccessful");
			log.onTestFailure("Fail");
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}

	public void customerlogin() throws IOException {

		Extentlogger.createTest("Customer logs in ");

		try {

			boolean emailVisible = action.waituntilvisible(elements.email);

			Assert.assertTrue(emailVisible, "Email field is not visible");

			boolean passwordVisible = action.waituntilvisible(elements.password);

			Assert.assertTrue(passwordVisible, "Password field is not visible");

			action.entertext(elements.email, username);
			action.thinktime();
			action.entertext(elements.password, password);
			action.click(elements.button("Login"));

			boolean urlVerified = action.verifycurrentURL("https://shop.qaautomationlabs.com/shop");

			Assert.assertTrue(urlVerified, "Customer login failed - URL is incorrect");

			log.scenario.pass("Customer logged in successfully");

		} catch (Exception e) {

			log.scenario.fail("Customer unsuccessful login");
			log.onTestFailure("Fail");
			fail("Your failure message here");
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}

	public void userverifyshopmodule() throws IOException {

		Extentlogger.createTest("Verify shop options");

		try {

			boolean menfashionvisible = action.waituntilvisible(
					driver.findElement(By.xpath("//div[@class=\"offer-text\"]/h3[text()='Men Fashion']")));

			Assert.assertTrue(menfashionvisible, "Men Fashion module is not visible");
			boolean womanfashionvisible = action.waituntilvisible(
					driver.findElement(By.xpath("//div[@class=\"offer-text\"]/h3[text()='Women Fashion']")));

			Assert.assertTrue(womanfashionvisible, "Women Fashion module is not visible");
			boolean kidsfashionvisible = action.waituntilvisible(
					driver.findElement(By.xpath("//div[@class=\"offer-text\"]/h3[text()='Kids Fashion']")));

			Assert.assertTrue(kidsfashionvisible, "Kids Fashion module is not visible");

			boolean electronicsvisible = action.waituntilvisible(
					driver.findElement(By.xpath("//div[@class=\"offer-text\"]/h3[text()='Electronics']")));

			Assert.assertTrue(electronicsvisible, "Electronic module is not visible");

			log.scenario.pass("Modules are visible");
		} catch (Exception e) {

			Assert.fail("Shop module verification failed: " + e.getMessage());

		}

	}

	public void userselectshopmodule(String module) throws IOException {

		Extentlogger.createTest("Select shop option");

		try {

			boolean clicked = action.click(driver.findElement(
					By.xpath("//div[@class=\"offer-text\"]/h3[text()='" + module + "']/following-sibling::a")));

			Assert.assertTrue(clicked, "Cannot select shop option: " + module);
			if (clicked) {
				log.scenario.pass("Successfully selected a shop option");
			}

		} catch (Exception e) {

			log.scenario.fail("Cannot select shop option");
			log.onTestFailure("Fail");
			
			Assert.fail("Clicking of shop module failed: " + e.getMessage());

		}

	}
	
	public void verifyconfirmdetails() throws IOException {

		Extentlogger.createTest("Select shop option");

		try {

			boolean verifyfname = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'firstname')]")), fname);

			Assert.assertTrue(verifyfname, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'firstname')]")).getText().trim() + "Expected :" + fname);
			if (verifyfname) {
				log.scenario.pass("First name is correct" );
			}
			
			boolean verifymname = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'middlename')]")), mname);

			Assert.assertTrue(verifymname, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'middlename')]")).getText().trim() + "Expected :" + mname);
			if (verifymname) {
				log.scenario.pass("Middle name is correct");
			}
			
			
			boolean verifylname = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'lastname')]")), lname);

			Assert.assertTrue(verifylname, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'lastname')]")).getText().trim() + "Expected :" + lname);
			if (verifylname) {
				log.scenario.pass("Last name is correct");
			}
			
			
			boolean verifyemail = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'email')]")), personmail);

			Assert.assertTrue(verifyemail, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'email')]")).getText().trim() + "Expected :" + personmail);
			if (verifyemail) {
				log.scenario.pass("Email is correct");
			}
			
			boolean verifyphone = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'phone')]")), mobile);

			Assert.assertTrue(verifyphone, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'phone')]")).getText().trim() + "Expected :" + mobile);
			if (verifyphone) {
				log.scenario.pass("Mobile number is correct");
			}
			boolean verifyaddress = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'address')]")), address);

			Assert.assertTrue(verifyaddress, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'address')]")).getText().trim() + "Expected :" + address);
			if (verifyaddress) {
				log.scenario.pass("Address is correct");
			}
			boolean verifystate = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'state')]")), state);

			Assert.assertTrue(verifystate, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'state')]")).getText().trim() + "Expected :" + state);
			if (verifystate) {
				log.scenario.pass("State is correct");
			}
			boolean verifycity = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'city')]")), city);

			Assert.assertTrue(verifycity, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'city')]")).getText().trim() + "Expected :" + city);
			if (verifycity) {
				log.scenario.pass("City is correct");
			}
			boolean verifypin = action.verifyText(driver.findElement(By.xpath("//div[contains(@data-testid, 'pincode')]")), pincode.toString());

			Assert.assertTrue(verifypin, "Incorrect actual text: " + driver.findElement(By.xpath("//div[contains(@data-testid, 'pincode')]")).getText().trim() + "Expected :" + pincode.toString());
			if (verifypin) {
				log.scenario.pass("First name is correct");
			}

		} catch (Exception e) {

			log.scenario.fail("Cannot verify the Confirm Details");
			log.onTestFailure("Fail");
			
			Assert.fail("Cannot verify the Confirm Details: " + e.getMessage());

		}

	}

	public void goback() throws IOException {

		Extentlogger.createTest("Go back to previous page");

		try {

			boolean click = action.click(driver.findElement(By.xpath("//a[@title=\"Go To Back\"]")));

			Assert.assertTrue(click, "Previous page cannot be done");
			if (click) {
				log.scenario.pass("Successfully went back to previous page");
			}
		} catch (Exception e) {

			log.scenario.fail("Previous page cannot be done");
			log.onTestFailure("Fail");

			Assert.fail("Go back button fail to be clicked: " + e.getMessage());

		}

	}

	public void searchproduct(String product, SoftAssert softAssert) throws IOException {

		Extentlogger.createTest("Search Product");

		try {

			boolean search = action.entertext(driver.findElement(By.xpath("//input[@title=\"Search products\"]")),
					product);

			softAssert.assertTrue(search, "Failed to search product: " + product);

			if (search) {
				log.scenario.pass("Successfully searched product");
			}
		} catch (Exception e) {

			log.scenario.fail("Searching product failed");
			log.onTestFailure("Fail");
			softAssert.fail("Searching product failed: " + e.getMessage());

		}

	}

	public void sortby(String option, SoftAssert softAssert) throws IOException {

		Extentlogger.createTest("Search Product");

		try {

			boolean selectdrop = action.selectdropdownvaluebytext(driver.findElement(By.xpath("//*[@id=\"sort-select\"]")), option);

			softAssert.assertTrue(selectdrop, "Failed to sortby: " + option);

			if (selectdrop) {
				log.scenario.pass("Successfully sorted product");
			}

		} catch (Exception e) {

			log.scenario.fail("Searching product failed");
			log.onTestFailure("Fail");

			softAssert.fail("Sorting failed: " + e.getMessage());

		}

	}

	public void filter(String filtername, SoftAssert softAssert) throws IOException {

		Extentlogger.createTest("Click the filter" + filtername);

		try {

			boolean filterclick = action
					.clickbyjava(driver.findElement(By.xpath("//input[@value='" + filtername + "']")));
			softAssert.assertTrue(filterclick, "Failed to click filter: " + filtername);

			if (filterclick) {
				log.scenario.pass("Successfully filter it by " + filtername);
			}

		} catch (Exception e) {

			log.scenario.fail("Failed in filterting the product");
			log.onTestFailure("Fail");

			softAssert.fail("Filter click failed: " + e.getMessage());

		}

	}

	public void addtocart(String itemname, SoftAssert softAssert) throws IOException {

		Extentlogger.createTest("Added " + itemname + " to Cart");

		try {

			String pricestring = driver
					.findElement(By.xpath("//a[text()='" + itemname + "']/following-sibling::div/h5")).getText()
					.substring(1);

			Integer price = Integer.parseInt(pricestring);

			boolean clicked = action
					.click(driver.findElement(By.xpath("//a[text()='" + itemname + "']/following-sibling::button")));

			softAssert.assertTrue(clicked, "Failed to Add item to cart : " + itemname);

			if (!orders.containsKey(itemname)) {

				orders.put(itemname, 1);
				orderprice.put(itemname, price);

			} else {

				orders.replace(itemname, orders.get(itemname) + 1);
				orderprice.put(itemname, orders.get(itemname) * price);
			}
			
			/*
			for (String test : orders.keySet()) {

				System.out.println("Order " + test);
				System.out.println("Quantity" + orders.get(test));

			}

			for (String test : orderprice.keySet()) {

				System.out.println("Order " + test);
				System.out.println("Overall Price" + orderprice.get(test));

			}
			*/
			
			
			overallcart += price;

			System.out.println(overallcart);
			
			
			if (clicked) {
				log.scenario.pass("Successfully Added the Item" + itemname);
			}

		} catch (Exception e) {

			log.scenario.fail("Adding product failed");
			log.onTestFailure("Fail");

			softAssert.fail("Failed to add the Item: " + e.getMessage());

		}

	}
	
	
	
	
	public void verifyfilters(String filters) throws IOException {

		Extentlogger.createTest("Verify the Filter options of the module");

		try {

			List<String> expectedValues = List.of(filters.split(","));
			List<String> currentValues = new ArrayList<>();

			List<WebElement> elements = driver.findElements(By.xpath("//label[@class=\"custom-control-label\"]"));

			for (WebElement e : elements) {
				currentValues.add(e.getText());
			}

			System.out.println("Expected: " + expectedValues);
			System.out.println("Current : " + currentValues);

			if (!expectedValues.equals(currentValues)) {

				log.scenario.fail("Expected: " + expectedValues + " | Current: " + currentValues);

				fail("Filter options don't match. Expected: " + expectedValues + " but found: " + currentValues);
			}

			log.scenario.pass("Filter options verified successfully: " + currentValues);

		} catch (Exception e) {

			e.printStackTrace();

			log.scenario.fail("Verification failed: " + e.getMessage());

			log.onTestFailure("Fail");

		}
	}

	public void verifycartitem() throws IOException {

		Extentlogger.createTest("Verify the Cart Items");

		try {

			for (String items : orders.keySet()) {

				WebElement itemelement = driver
						.findElement(By.xpath("//td/text()[contains(normalize-space(.), '" + items + "')]/parent::td"));
				if (itemelement.isDisplayed()) {

					System.out.println("Item" + itemelement + " is displayed");

					log.scenario.pass("Item : " + items + " is shown ");

				} else {

					log.scenario.fail("Item : " + items + " is not shown ");

				}

			}
		} catch (Exception e) {

			e.printStackTrace();

			log.scenario.fail("Verification failed: " + e.getMessage());

			log.onTestFailure("Fail");

		}

	}

	public void verifycartitemquantityprice(SoftAssert softAssert) throws IOException {

		Extentlogger.createTest("Verify the Cart Item Quantity");

		try {

			for (String items : orders.keySet()) {

				WebElement itemelement = driver.findElement(By.xpath("//td/text()[contains(normalize-space(.), '"
						+ items + "')]/parent::td/following-sibling::td[@class=\"align-middle\"]/input"));

				Integer itemquantity = Integer.parseInt(itemelement.getAttribute("value"));

				if (itemquantity == orders.get(items)) {

					System.out.println(
							"Expected item quantity : " + orders.get(items) + " is displayed" + " Item " + items);

					log.scenario
							.pass("Expected item quantity : " + orders.get(items) + " is displayed" + " Item " + items);

				} else {

					log.scenario.fail(
							"Expected item quantity : " + orders.get(items) + " is not displayed" + " Item " + items);

				}

				Integer totalpriceincart = Integer.parseInt(driver
						.findElement(By.xpath("//td/text()[contains(normalize-space(.), '" + items
								+ "')]/parent::td/following-sibling::td[contains(@data-testid, \"cart-item-total\")]"))
						.getText().substring(1));
				
				
	
				
				
				
				if (totalpriceincart.equals(orderprice.get(items))) {
					/*
					System.out.println("Total price is : " + totalpriceincart + " is displayed" + " Item " + items);

					System.out.println(
							"Expected Total Price : " + totalpriceincart + " is displayed" + " Item " + items);

					
					*/
					log.scenario.pass("Expected Total Price : " + orderprice.get(items) + " is displayed");

				} else {
					softAssert.assertTrue(totalpriceincart == (Integer) orders.get(items), "Values are not the the same");
					log.scenario.fail("Expected Total Price : " + orderprice.get(items) + " is not displayed, Actual " + totalpriceincart);

				}

			}

		} catch (Exception e) {

			e.printStackTrace();

			log.scenario.fail("Verification failed: " + e.getMessage());

			log.onTestFailure("Fail");

		}

	}

	public void verifytotalcart() throws IOException {

		Extentlogger.createTest("Verify if the total Cart is correct");

		try {

			Integer totalcart = Integer.parseInt(
					driver.findElement(By.xpath("//div[@id=\"totalPrice\"]")).getText().replaceAll("[^0-9]", ""));

			if (overallcart.equals(totalcart)) {

				log.scenario.pass(
						"Expected Total Price : " + overallcart + " and Current Value " + totalcart + " is correct");

			} else {

				log.scenario.fail(
						"Expected Total Price : " + overallcart + " and Current Value " + totalcart + " is INCORRECT");

			}

		} catch (Exception e) {

			e.printStackTrace();

			log.scenario.fail("Verification failed: " + e.getMessage());

			log.onTestFailure("Fail");

		}

	}

	public void populatebillingaddress() throws IOException {

		Extentlogger.createTest("Populate billing address fields");

		try {

			boolean firstname = action.entertext(elements.input("First Name"), fname);
			Assert.assertTrue(firstname, "Failed to populate First Name");
			boolean midname = action.entertext(elements.input("Middle Name"), mname);
			Assert.assertTrue(midname, "Failed to populate Middle Name");
			boolean lastname = action.entertext(elements.input("Last Name"), lname);
			Assert.assertTrue(lastname, "Failed to populate Last Name");
			boolean personam = action.entertext(elements.input("email.com"), personmail);
			Assert.assertTrue(personam, "Failed to populate Email");
			boolean mobileno = action.entertext(elements.input("Mobile No."), mobile.toString());
			Assert.assertTrue(mobileno, "Failed to populate Mobile Number");
			boolean addr = action.entertext(elements.textarea("Address"), address);
			Assert.assertTrue(addr, "Failed to populate Address");
			boolean states = action.entertext(elements.input("State"), state);
			Assert.assertTrue(states, "Failed to populate State");
			boolean cit = action.entertext(elements.input("City"), city);
			Assert.assertTrue(cit, "Failed to populate City");
			boolean pin = action.entertext(elements.input("Pin Code"), pincode.toString());

			Assert.assertTrue(pin, "Failed to populate Pin Code");

			log.scenario.pass("Billing Address populated");

		} catch (Exception e) {

			e.printStackTrace();
			log.scenario.fail("Population of fields: " + e.getMessage());
			log.onTestFailure("Fail");
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

	}
	
	
	
	public void deleteitemfromcart(String item, SoftAssert softAssert) throws IOException {

		Extentlogger.createTest("Delete item from Cart");

		try {

			boolean itemdeleted = action.click(driver.findElement(By.xpath("//td/text()[contains(normalize-space(.), '" +item+"')]/parent::td/following-sibling::td/button[@title='Remove']")));
			softAssert.assertTrue(itemdeleted, "Failed to delete: " + item);
			
			
			
			Integer removeditemprice = orderprice.get(item);
			
			
			System.out.println(removeditemprice);
			
			overallcart -= removeditemprice;
			
			
			
			
			System.out.println(overallcart);
			
			orders.remove(item);
			orderprice.remove(item);
			
			
			log.scenario.pass("Deleted Product success! Current overall cart " + overallcart);

		} catch (Exception e) {

			e.printStackTrace();
			log.scenario.fail("Deleted Product success failed: " + e.getMessage());
			log.onTestFailure("Fail");
			
		}

	}
	
	
	
	
	public void addquantitytoitem(String item, Integer count, SoftAssert softAssert) throws IOException {

		Extentlogger.createTest("Add quantity to item" + item);

		try {
			
			
			WebElement quantity = driver.findElement(By.xpath("//td/text()[contains(normalize-space(.), '"+item+"')]/parent::td/following-sibling::td/input[@type=\"number\"]"));
			
			
			boolean itemadded = action.click(quantity);
			softAssert.assertTrue(itemadded, "Failed to delete: " + item);
			
			
			/*
			for (int i = 0; i < count; i++  ) {
				
				action.thinktime();
				action.click(quantity);
				quantity.sendKeys(Keys.ARROW_UP);
			
			}
			
			*/
			
			By qtyLocator = By.xpath(
				    "//td[text()[contains(normalize-space(.), '" + item +
				    "')]]/following-sibling::td/input[@type='number']"
				);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				for (int i = 0; i < count; i++) {

				    WebElement qty = wait.until(
				        ExpectedConditions.presenceOfElementLocated(qtyLocator)
				    );

				    int oldValue = Integer.parseInt(qty.getAttribute("value"));

				    qty.sendKeys(Keys.ARROW_UP);

				    // Table refreshes and old qty becomes stale.
				    // Wait for the newly-created input.
				    wait.until(driver -> {
				        try {
				            WebElement newQty = driver.findElement(qtyLocator);
				            int newValue = Integer.parseInt(newQty.getAttribute("value"));

				            return newValue == oldValue + 1;
				        } catch (StaleElementReferenceException e) {
				            return false;
				        }
				    });
				    
				}
			
			overallcart -= orders.get(item) * orderprice.get(item);
			
			
			String text = driver.findElement(By.xpath("//td/text()[contains(normalize-space(.), '"+item+"')]/parent::td/following-sibling::td[contains(@data-testid, 'cart-item-price')]")).getText().substring(1);
			
			Integer price = Integer.parseInt(text);
			
			orders.put(item, Integer.parseInt(driver.findElement(qtyLocator).getAttribute("value")));
			orderprice.put(item, orders.get(item) * price);
			
	
			
			Integer updateditemprice = orders.get(item) * orderprice.get(item);
			

			
			System.out.println("Item :" + updateditemprice);
	
			
			overallcart += updateditemprice;
			
			
			System.out.println(overallcart);
			
			log.scenario.pass("Added quantity Price");

		} catch (Exception e) {

			e.printStackTrace();
			log.scenario.fail("Added quantity failed: " + e.getMessage());
			log.onTestFailure("Fail");
			
		}

	}
	
	
	public void reducequantitytoitem(String item, Integer count, SoftAssert softAssert) throws IOException {

		Extentlogger.createTest("Reduce Item Quantity " + item);

		try {
			
			
			WebElement quantity = driver.findElement(By.xpath("//td/text()[contains(normalize-space(.), '"+item+"')]/parent::td/following-sibling::td/input[@type=\"number\"]"));
			boolean itemreduce = action.click(quantity);
			softAssert.assertTrue(itemreduce, "Failed to delete: " + item);
			
			
			/*
			for (int i = 0; i < count; i++  ) {
				
				action.thinktime();
				action.click(quantity);
				quantity.sendKeys(Keys.ARROW_UP);
			
			}
			
			*/
			
			By qtyLocator = By.xpath(
				    "//td[text()[contains(normalize-space(.), '" + item +
				    "')]]/following-sibling::td/input[@type='number']"
				);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				for (int i = 0; i < count; i++) {

				    WebElement qty = wait.until(
				        ExpectedConditions.presenceOfElementLocated(qtyLocator)
				    );

				    int oldValue = Integer.parseInt(qty.getAttribute("value"));

				    qty.sendKeys(Keys.ARROW_DOWN);

				    // Table refreshes and old qty becomes stale.
				    // Wait for the newly-created input.
				    wait.until(driver -> {
				        try {
				            WebElement newQty = driver.findElement(qtyLocator);
				            int newValue = Integer.parseInt(newQty.getAttribute("value"));

				            return newValue == oldValue - 1;
				        } catch (StaleElementReferenceException e) {
				            return false;
				        }
				    });
				    
				}
			
			overallcart -= orders.get(item) * orderprice.get(item);
			
			String text = driver.findElement(By.xpath("//td/text()[contains(normalize-space(.), '"+item+"')]/parent::td/following-sibling::td[contains(@data-testid, 'cart-item-price')]")).getText().substring(1);
			
			Integer price = Integer.parseInt(text);
			orders.put(item, Integer.parseInt(driver.findElement(qtyLocator).getAttribute("value")));
			orderprice.put(item, orders.get(item) * price);
	
			
			
			Integer updateditemprice = orderprice.get(item);
			

			
			System.out.println("Item :" + updateditemprice);
			
			overallcart += updateditemprice;
			
			
			System.out.println(overallcart);
			
			log.scenario.pass("Added quantity Price");

		} catch (Exception e) {

			e.printStackTrace();
			log.scenario.fail("Added quantity failed: " + e.getMessage());
			log.onTestFailure("Fail");
			
		}

	}
	
	public static void main(String[] args) throws IOException {

	}

}
