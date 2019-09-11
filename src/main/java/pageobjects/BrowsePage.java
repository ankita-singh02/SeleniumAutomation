package pageobjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class BrowsePage {
	WebDriver driver;
	public static final String searchFilter = "//div[@class='pg-filter']/div/div/[@id='searchFilterFilter']";
	public static final String bookmarkFilter = "//div[@class='pg-filter']/div/div/[@id='bookmarkFilterFilter']";
	public static final String peopleContacted = "//div[@class='pg-filter']/div/div/[@id='peopleMetFilter']";
	public static final String locationFilter = "//div[@class='pg-filter']/div/div/[@id='locationFilterFilter']";
	public static final String majorFilter = "//div[@class='pg-filter']/div/div/[@id='majorFilterFilter']";
	public static final String expertiseFilter = "//div[@class='pg-filter']/div/div/[@id='expertiseFilterFilter']";
	public static final String input_SEARCH = "//span[@class='search-filter']//input[@type='text']";
	public static final String searchApply = "	//div[@class='pg-filter-menu__footer']//button[2]";

	public static final String XPATH = "xpath";

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


	public Map getMap(String data) {

		Map<String, List<String>> map = new TreeMap<String, List<String>>();

		String[] keyValueCombined = data.split(";");

		String val[] = null;

		for (String s : keyValueCombined) {

			String keyValuePairs[] = s.split(":");

			for (String a : Arrays.asList(keyValuePairs[1])) {

				val = a.split(",");
			}

			map.put(keyValuePairs[0], Arrays.asList(val));

		}
		System.out.println("Map " + map);

		return map;

	}

	public void applyFiters(String filters) {
		
		System.out.println("In click Tab");
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Filter Name: " + filters);
		
		Map map = getMap(filters);
		
        Iterator itr = map.entrySet().iterator(); 
        while (itr.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)itr.next(); 

		
		switch((String)mapElement.getKey()){
		
		case "Search":
			GenericMethods.click(driver, BrowsePage.searchFilter, "xpath");
			GenericMethods.input(driver, BrowsePage.input_SEARCH, LandingPage_Elements.XPATH, (String)mapElement.getValue());
			break;
			
		case "Location":
			GenericMethods.click(driver, BrowsePage.locationFilter, "xpath");
			GenericMethods.input(driver, BrowsePage.input_SEARCH, LandingPage_Elements.XPATH, (String)mapElement.getValue());
			break;
			
		
		}

        }
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> browsePageElements = new HashMap<String, String>();

		// >>>>>>>>>>>>>>>>>>>>>>>>>>> ELEMENTS ON EVENT CARD
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		browsePageElements.put("filterBOOKMARK", "//button[@id='bookmark']");
		browsePageElements.put("bookmarkPROFILE", "//i[@class='star-icon campuskudos-star-9 yellow']");
		browsePageElements.put("filterMYACTIONS", "//h3[text()='My Actions']");
		browsePageElements.put("filterSTARREDPEOPLE", "//span[text()=\"People I've starred\"]");
		browsePageElements.put("buttonUPDATE", "//button[@aria-label=\"Update\"]");

		return browsePageElements.get(xpath_name);
	}

}
