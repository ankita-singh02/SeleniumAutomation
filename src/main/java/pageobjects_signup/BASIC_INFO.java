package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class BASIC_INFO {
	WebDriver driver;

	public BASIC_INFO(WebDriver driver) {
		this.driver = driver;
	}

	public static final String pageTitle="//span[text()='About You']";
	public void verifyOnBasicInfoPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Basic Info Page");
		GenericMethods.assertDisplay(driver, "text", "Select User Type Title",pageTitle );

	}


	public void enterInput(String data, String inputName) {
		LogUtils.info("Inputting data in "+inputName +" on Basic info Page");

		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);
		
	}
	
	public void enterLocation(String location) {
		LogUtils.info("Entering "+ location+" in Location Field");
		WebElement locationElement=driver.findElement(By.xpath(xpathCreator("input", "LOCATION")));

		locationElement.sendKeys(location); 
		
		try {
			Thread.sleep(1500);
			locationElement.sendKeys(Keys.ARROW_DOWN);
			locationElement.sendKeys(Keys.RETURN);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	public void basicInfoData(String basicInfo) {
		
		//Headline
		String info[]=basicInfo.split(",");
		GenericMethods.input(driver, xpathCreator("input", "Headline"), "xpath", info[0]);

		//location
		LogUtils.info("Entering "+ info[1]+" in Location Field");
		WebElement locationElement=driver.findElement(By.xpath(xpathCreator("input", "LOCATION")));

		locationElement.sendKeys(info[1]); 
		
		try {
			Thread.sleep(1500);
			locationElement.sendKeys(Keys.ARROW_DOWN);
			locationElement.sendKeys(Keys.RETURN);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	
	public void verifyDisplayOf(String element_type, String element_name) {
		LogUtils.info("Verifying display of "+element_name +" on Basic info Page");

		String xpath=xpathCreator(element_type, element_name);
		GenericMethods.assertDisplay(driver, element_type, element_name, xpath);
	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on "+element_name +" on Basic info Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
		
	}
	
	
	public void clickOn(String buttonName) {
		String xpath = xpathCreator("button", buttonName);
		GenericMethods.clickOn(driver, xpath);

	}

	
	public static String elementMap(String xpath_name) {
		HashMap<String, String> basicInfoElements = new HashMap<String, String>();
		basicInfoElements.put("inputHEADLINE", "//input[@data-qa='headline-input']");
		basicInfoElements.put("inputLOCATION", "//input[@data-qa='location-input']");
		basicInfoElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");
		basicInfoElements.put("buttonMUMBAI", "//span[text()='Mumbai, Maharashtra, India']");

		return basicInfoElements.get(xpath_name);
	}
	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type+element_name.replace(" ", "").toUpperCase());
		String xpath= elementMap(element_type+element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: "+xpath);
		return xpath;
	}

}
