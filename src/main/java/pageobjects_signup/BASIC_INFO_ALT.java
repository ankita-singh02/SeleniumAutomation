package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.JavascriptUtils;
import utils.LogUtils;

public class BASIC_INFO_ALT {
	WebDriver driver;
	
	public BASIC_INFO_ALT(WebDriver driver) {
		this.driver=driver;
	}
	public static final String pageTitle="//h5[text()='Current Company/Organization *']";

	public void verifyOnBasicInfoAltPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Basic Info Alt Page");
		JavascriptUtils.bringIntoView(driver.findElement(By.xpath(pageTitle)));
		GenericMethods.assertDisplay(driver, "text", "About You",pageTitle );

	}


	public void input(String element_name, String data) {
		LogUtils.info("Inputting data in "+element_name +" on Basic info Page");
		GenericMethods.input(driver, xpathCreator("input", element_name), "xpath", data);
				
	}
	
	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type+element_name.replace(" ", "").toUpperCase());
		String xpath= elementMap(element_type+element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: "+xpath);
		return xpath;
	}
	public void verifyDisplayOf(String element_type, String element_name) {
		String xpath=xpathCreator(element_type, element_name);
		GenericMethods.assertDisplay(driver, element_type, element_name, xpath);
	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on "+element_name +" on Basic info Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
		
	}
	public static String elementMap(String xpath_name) {
		HashMap<String, String> basicInfoAltElements = new HashMap<String, String>();
		basicInfoAltElements.put("inputCURRENTCOMPANY", "//md-autocomplete[@data-qa='companyName-autocomplete']/md-autocomplete-wrap/input");
		basicInfoAltElements.put("inputCURRENTROLE", "//input[@data-qa='currentRole-input']");
		basicInfoAltElements.put("inputROLEDESCRIPTION", "//textarea[@data-qa='roleDescription-input']");
		basicInfoAltElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");

		return basicInfoAltElements.get(xpath_name);
	}
	

}
