package pageobjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class BrowsePage {
	WebDriver driver;
	public static final String searchFilter = "//*[@id=\"searchFilter\"]";
	public static final String bookmarkFilter = "//div[@class='pg-filter']/div/div/[@id='bookmarkFilterFilter']";
	public static final String peopleContacted = "//div[@class='pg-filter']/div/div/[@id='peopleMetFilter']";
	public static final String locationFilter = "//*[@id=\"locationFilter\"]";
	public static final String majorFilter = "//*[@id=\"majorFilterFilter\"]";
	public static final String expertiseFilter = "//*[@id=\"expertiseFilter\"]";
	public static final String input_SEARCH = "//*[@id=\"searchFilterFilter\"]/div/div/div/div/div[1]/span/input";	
	public static final String input_LOCATION = "//*[@id=\"locationFilterFilter\"]/div/div/div/div/div[1]/div[2]/div/div/ul/li/div/input";	
	public static final String input_MAJOR = "//*[@id=\"majorFilterFilter\"]/div/div/div/div/div[1]/div/input";	  
	public static final String input_EXPERTISE = "//*[@id=\"expertiseFilterFilter\"]/div/div/div/div/div[1]/div/input";	
	public static final String input_EXPERTISE_checkbox = "//*[@id=\"expertiseFilterFilter\"]/div/div/div/div/div[1]/div/div/div/label/span[1]/input";
	public static final String searchApply = "//*[@id=\"searchFilterFilter\"]/div/div/div/div/div[2]/div/button[2]";
	public static final String locationApply = "//*[@id=\"locationFilterFilter\"]/div/div/div/div/div[3]/div/button[2]";
	public static final String majorApply = "//*[@id=\"majorFilterFilter\"]/div/div/div/div/div[3]/div/button[2]";
	public static final String expertiseApply = "//*[@id=\"expertiseFilterFilter\"]/div/div/div/div/div[3]/div/button[2]";
	
	
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
		JSWaiter.waitForLoad(driver);
		LogUtils.info("Filter Name: " + filters);

		Map<String, List<String>> map = getMap(filters);

		Iterator<Map.Entry<String, List<String>>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, List<String>> mapElement = itr.next();

			for (int i =0;i<mapElement.getValue().size();i++) {
				switch ((String) mapElement.getKey()) {

				case "Search":
					GenericMethods.click(driver, BrowsePage.searchFilter, "xpath");
					System.out.println("Value " + mapElement.getValue().get(i));
					GenericMethods.input(driver, BrowsePage.input_SEARCH, LandingPage_Elements.XPATH,
							mapElement.getValue().get(i));
					GenericMethods.click(driver, BrowsePage.searchApply, "xpath");

					break;

				case "Location":
					System.out.println("Loc " + mapElement.getValue().get(i));
					GenericMethods.click(driver, BrowsePage.locationFilter, "xpath");
					GenericMethods.input(driver, BrowsePage.input_LOCATION, LandingPage_Elements.XPATH,
							mapElement.getValue().get(i));
					JSWaiter.sleep(4000);
					driver.findElement(By.xpath(BrowsePage.input_LOCATION)).sendKeys(Keys.ENTER);
					JSWaiter.sleep(2000);
					GenericMethods.click(driver, BrowsePage.locationApply, "xpath");
					break;
					
				case "Major(s)":
					GenericMethods.click(driver, BrowsePage.majorFilter, "xpath");
					GenericMethods.input(driver, BrowsePage.input_MAJOR, LandingPage_Elements.XPATH,
							mapElement.getValue().get(i));
					JSWaiter.sleep(4000);
					driver.findElement(By.xpath(BrowsePage.input_MAJOR)).sendKeys(Keys.ENTER);
					JSWaiter.sleep(2000);
					GenericMethods.click(driver, BrowsePage.majorApply, "xpath");
					break;
					
				case "Expertise":
					System.out.println("Expertise " + mapElement.getValue().get(i));
					GenericMethods.click(driver, BrowsePage.expertiseFilter, "xpath");
					GenericMethods.click(driver, BrowsePage.input_EXPERTISE, "xpath");
					GenericMethods.input(driver, BrowsePage.input_EXPERTISE, LandingPage_Elements.XPATH,
							mapElement.getValue().get(i));
					GenericMethods.click(driver, BrowsePage.input_EXPERTISE_checkbox, "xpath");
					System.out.println("Here");
				    GenericMethods.clearText(driver, BrowsePage.input_EXPERTISE);
					GenericMethods.click(driver, BrowsePage.expertiseApply, "xpath");
					break;
				}

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
