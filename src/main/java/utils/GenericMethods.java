package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class GenericMethods {

	// METHOD TO CLICK ON AN ELEMENT
	public static void click(WebDriver driver, String sLocator, String locatorType) { // To click on a certain element
																						// using its locator
		LogUtils.info("Performing click action");
		JSWaiter.waitForLoad(driver);

		try {
			WebElement element = driver.findElement(By.xpath(sLocator));
			WaitTool.waitForElement(driver, By.xpath(sLocator), 5);
			//JavascriptUtils.bringIntoView(element);
			element.click();

		} catch (Exception e) {
			LogUtils.error("Click action failed: " + e.getMessage());
		}
	}

	// METHOD TO SEND TEXT IN AN INPUT/TEXT FIELD

	public static void input(WebDriver driver, String sLocator, String locatorType, String data) {
		// To input String into text fields

		LogUtils.info("Performing input action");
		//JSWaiter.waitMethod(driver, sLocator, locatorType);
		try {

			WebElement element = driver.findElement(By.xpath(sLocator));
			//JavascriptUtils.bringIntoView(element);
			element.sendKeys(data);
		} catch (Exception e) {

			LogUtils.error("Input Action Failed " + e.getMessage());
		}

	}

	// METHOD TO CHECK WHETHER AN ELEMENT IS VISIBLE ON SCREEN OR NOT
	public static boolean isElementVisible(WebDriver driver, String sLocator) {
		LogUtils.info("Verifying Visibility of an Element");
		JSWaiter.waitForAngularLoad();
		System.out.println("Xpath: " + sLocator);
		boolean flag = false;
		try {
			if (driver.findElement(By.xpath(sLocator)).isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
		}

		boolean value = flag;
		System.out.println("Is element displayed?" + value);
		return value;
	}

	// METHOD TO CHECK WHETHER AN ELEMENT IS PRESENT IN DOM OR NOT
	public static boolean isElementPresent(WebDriver driver, String sLocator) {
		LogUtils.info("Verifying Visibility of an Element");
		JSWaiter.waitForAngularLoad();
		System.out.println(sLocator);
		boolean flag = false;
		try {
			if (driver.findElement(By.xpath(sLocator)) != null) {
				flag = true;
			} else {
				LogUtils.info("Element not present");
			}
		} catch (Exception e) {
		}

		boolean value = flag;
		LogUtils.info("Is element displayed?" + value);
		return value;
	}

	// METHOD TO NAVIGATE TO A URL
	public static void navigate(WebDriver driver, String url) { // To navigate to a certain URL on the set driver
		try {

			driver.navigate().to(url);

		} catch (Exception e) {
			System.out.println("Error in Navigation" + e.getMessage());
		}
	}

	// METHOD TO SETUP LOG4J
	public static void setUpLog4j() {

		try {

			Properties po1 = new Properties();
			FileInputStream configStream1 = null;
			FileOutputStream output1 = null;
			if (System.getProperty("os.name").contains("Windows")) {
				configStream1 = new FileInputStream("resources\\log4j.properties");
				po1.load(configStream1);
				PropertyConfigurator.configure("resources\\log4j.properties");
				String logFolderPath = System.getProperty("user.dir") + "\\resources\\log.txt";
				po1.setProperty("log4j.appender.file.File", logFolderPath);
				output1 = new FileOutputStream("resources\\log4j.properties");
			} else {
				configStream1 = new FileInputStream("resources/log4j.properties");
				po1.load(configStream1);
				PropertyConfigurator.configure("resources/log4j.properties");
				String logFolderPath = System.getProperty("user.dir") + "/resources/log.txt";
				po1.setProperty("log4j.appender.file.File", logFolderPath);
				output1 = new FileOutputStream("resources/log4j.properties");
			}

			po1.store(output1, null);
			configStream1.close();
			output1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clickOn(String button_type, String button_name, WebDriver driver, String xpath) {

		LogUtils.info("Clicking on " + button_type + ": " + button_name + " XPATH: " + xpath);
		JSWaiter.waitForAngularLoad();

		GenericMethods.click(driver, xpath, "xpath");
		LogUtils.info("Clicked on " + button_name);

	}
	
	public static void clickOn( WebDriver driver, String xpath) {

		JSWaiter.waitForAngularLoad();

		GenericMethods.click(driver, xpath, "xpath");
		LogUtils.info("Clicked on JoinOur Community");

	}

	public static void assertDisplay(WebDriver driver, String element_type, String element_name, String xpath) {

		JSWaiter.waitForAngularLoad();
		JavascriptUtils.bringIntoView(driver.findElement(By.xpath(xpath)));
		LogUtils.info("Verifying Presence of " + element_type + " " + element_name + " XPATH:" + xpath);

		// WaitTools.waitForElementPresent(driver, xpath, 5);

		Boolean condition = GenericMethods.isElementVisible(driver, xpath);
		System.out.println("Boolean condition is: " + condition);
		try {
			Assert.assertTrue("Assertion failed for " + element_name, condition);
		} catch (Exception e) {
			LogUtils.error("Issue in display assertion of: " + element_type + element_name);
		}
		/*
		 * SoftAssert softAssert=new SoftAssert(); softAssert.assertTrue(condition);
		 */
	}

	public static void clickAndInput(WebDriver driver, String xpath, String sLocator, String inputValue) {
		LogUtils.info("Performing input action");
		WebElement element = driver.findElement(By.xpath(sLocator));
		JavascriptUtils.bringIntoView(element);
		Actions action = new Actions(driver);
		action.click(element).sendKeys(inputValue).build().perform();

		element.sendKeys(inputValue);

	}

	public static void assertPresence(WebDriver driver, String element_type, String element_name, String xpath) {

		JSWaiter.waitForAngularLoad();

		LogUtils.info("Verifying Presence of " + element_type + " " + element_name + " XPATH:" + xpath);

		// WaitTools.waitForElementPresent(driver, xpath, 5);

		Boolean condition = GenericMethods.isElementPresent(driver, xpath);
		System.out.println("Boolean condition is: " + condition);
		try {
			Assert.assertTrue("Assertion failed for " + element_name, condition);
			LogUtils.info("Assertion Passed");

		} catch (Exception e) {
			LogUtils.error("Issue in presence assertion for " + element_type + element_name);
		}

	}

	public static void drawSign(WebDriver driver, String sLocator) {
		// TO Draw sign on canvas
		WebElement canvas;

		Actions actions = new Actions(driver);
		canvas = driver.findElement(By.xpath(sLocator));
		JSWaiter.waitForAngularLoad();
		// Action draw=actions.click(canvas).build(); >> Just makes one dot on the
		// canvas
		Action draw = actions.clickAndHold(canvas).moveByOffset(20, 0).moveByOffset(0, 20).moveByOffset(-20, 0)
				.moveByOffset(0, -20).release().build();
		draw.perform();

	}

	public static void assertAbsence(WebDriver driver, String element_type, String element_name, String xpath) {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying Absence of " + element_type + " " + element_name + " XPATH:" + xpath);
		Boolean condition = GenericMethods.isElementPresent(driver, xpath);
		System.out.println("Boolean condition is: " + condition);
		Assert.assertFalse("Absence Assertion failed for " + element_name, condition);

	}

	public static void assertDisplay(WebElement webElement) {
		JSWaiter.waitForAngularLoad();
		JavascriptUtils.bringIntoView(webElement);
		Boolean condition = webElement.isDisplayed();
		LogUtils.info("Is element displayed? :" + condition);
		try {
			Assert.assertTrue(condition);
			LogUtils.info("Assertion Passed");
		} catch (Exception e) {
			LogUtils.info("Assertion failed");
		}

	}

	public static void clearText(WebDriver driver, String xpath) {
		JSWaiter.waitForAngularLoad();
		WebElement textarea = driver.findElement(By.xpath(xpath));
		JavascriptUtils.bringIntoView(textarea);
		textarea.clear();

	}

}
