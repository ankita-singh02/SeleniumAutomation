package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class BrowsePage {
	WebDriver driver;

	public BrowsePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickon(String element_type, String element_name) {
	
		LogUtils.info("Clicking on " + element_name + " on Browse Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
		LogUtils.info("Done clicking");

	}

	public void verifyDisplayOf(String element_type, String element_name) {
		LogUtils.info("Verifying Presence of " + element_name);
		JSWaiter.waitForAngularLoad();
		GenericMethods.assertDisplay(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	public void verifyAbsenceOf(String element_type, String element_name) {
		GenericMethods.assertAbsence(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	public void verifyInfo(String element_type, String element_name, String element_value) {

		String value = driver.findElement(By.xpath(xpathCreator(element_type, element_name))).getText();
		LogUtils.info("Value from DOM: " + value);
		LogUtils.info("Value from Feature file: " + element_value);
		LogUtils.info("Matching DOM value to Feature file element value (Case Insensitive)");
		Boolean condition = value.toLowerCase().contains(element_value.toLowerCase());
		System.out.println("MATCHING CONDITION: " + condition);
		Assert.assertTrue(condition);
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> browsePageElements = new HashMap<String, String>();

		// >>>>>>>>>>>>>>>>>>>>>>>>>>> ELEMENTS ON EVENT CARD <<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		browsePageElements.put("filterBOOKMARK", "//button[@id='bookmark']");
		browsePageElements.put("bookmarkPROFILE", "//i[@class='star-icon campuskudos-star-9 yellow']");
		browsePageElements.put("filterMYACTIONS", "//h3[text()='My Actions']");
		browsePageElements.put("filterSTARREDPEOPLE", "//span[text()=\"People I've starred\"]");
		browsePageElements.put("buttonUPDATE", "//button[@aria-label=\"Update\"]");

		return browsePageElements.get(xpath_name);
	}

}
