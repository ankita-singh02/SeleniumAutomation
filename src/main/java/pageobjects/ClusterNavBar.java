package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class ClusterNavBar {

	WebDriver driver;

	public ClusterNavBar(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnProfileDropdownOption(String string) {
		LogUtils.info("Clicking on Profile dropdown option: " + string);
		switch (string) {
		case "Sign Out":
			GenericMethods.click(driver, ClusterNavBar_Elements.dropdownPROFILE, ClusterNavBar_Elements.XPATH);
			break;

		default:
			LogUtils.error("Incorrect Profile dropdown option passed");
		}

	}

	public void clickOnProfileDropdown() {

		LogUtils.info("Clicking on Profile Dropdown");
		JSWaiter.waitForAngularLoad();
		GenericMethods.click(driver, ClusterNavBar_Elements.dropdownPROFILE, ClusterNavBar_Elements.XPATH);

	}

	public void isOnHomePage() {
		// //a[@ng-click='goHome()'] is visible
		LogUtils.info("Asserting visibility of Logo on Clustur Nav Bar ");
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Clicking on Got It on Thank You Modal");
		GenericMethods.click(driver, "//div[contains(text(),'GOT IT')]", "xpath");
		JSWaiter.waitForAngularLoad();
		GenericMethods.assertDisplay(driver, "image", "Logo", "//a[@ng-click='goHome()']");
	}

	public void goToMy(String option) {
		JSWaiter.waitForAngularLoad();
		clickOn("dropdown", "profile");
		clickOn("option", option);
	}

	public void clickOn(String elementType, String elementName) {
		LogUtils.info("Clicking on " + elementName + " on Cluster Nav Bar");
		GenericMethods.click(driver, xpathCreator(elementType, elementName), "xpath");
		LogUtils.info("Done clicking");
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

	public void driverClose() {
		System.out.println("INSIDE DRIVER CLOSE");
		driver.close();
		driver.quit();
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> clusterNavBarElements = new HashMap<String, String>();

		clusterNavBarElements.put("dropdownPROFILE", "//a[@title='My Profile']");
		clusterNavBarElements.put("optionMYEVENTS", "//a[contains(text(),'My Events')]");
		clusterNavBarElements.put("optionSIGNOUT", "//a[contains(text(),'Sign Out')]");

		return clusterNavBarElements.get(xpath_name);
	}

}
