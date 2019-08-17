package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.JavascriptUtils;
import utils.LogUtils;

public class WORK_HISTORY {
	WebDriver driver;

	public WORK_HISTORY(WebDriver driver) {
		this.driver = driver;
	}

	public static final String pageTitle = "//span[text()='Your Current and Past Experience']";

	public void verifyOnWorkHistoryPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Work History Page");
		JavascriptUtils.bringIntoView(driver.findElement(By.xpath(pageTitle)));
		GenericMethods.assertDisplay(driver, "text", "About You", pageTitle);

	}

	public void input(String element_name, String data) {
		LogUtils.info("Inputting data in " + element_name + " on Work History Page");
		GenericMethods.input(driver, xpathCreator("input", element_name), "xpath", data);

	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

	public void verifyDisplayOf(String element_type, String element_name) {
		String xpath = xpathCreator(element_type, element_name);
		GenericMethods.assertDisplay(driver, element_type, element_name, xpath);
	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Work History Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");

	}

	public void clickOn(String buttonName) {
		String xpath = xpathCreator("button", buttonName);
		GenericMethods.clickOn(driver, xpath);

	}

	public void enterLocation(String location) {
		LogUtils.info("Entering " + location + " in Location Field");
		WebElement locationElement = driver.findElement(By.xpath(xpathCreator("input", "LOCATION")));

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

	public static String elementMap(String xpath_name) {
		HashMap<String, String> workHistoryElements = new HashMap<String, String>();
		workHistoryElements.put("inputCOMPANYNAME", "//input[@id='company-title-input']");
		workHistoryElements.put("buttonSEARCH", "//button[@ng-click='search()']");
		workHistoryElements.put("buttonSELECT", "//div/button[@aria-label='Select']");
		workHistoryElements.put("inputLOCATION", "//input[@data-qa='location-input']");
		workHistoryElements.put("checkboxICURRENTLYWORKHERE", "//div[@class='md-label']");
		workHistoryElements.put("inputCURRENTROLE", "//input[@data-qa='currentRole-input']");
		workHistoryElements.put("inputROLEDESCRIPTION", "//textarea[@data-qa='roleDescription-input']");
		workHistoryElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");
		workHistoryElements.put("button+SAVE", "//button[@data-qa='saveAndAddDegree-button']");
		workHistoryElements.put("dropdownSTARTMONTH", "//select[@ng-model='entry.startMonth']");
		workHistoryElements.put("dropdownENDMONTH", "//select[@ng-model='entry.endMonth']");
		workHistoryElements.put("dropdownSTARTYEAR", "//select[@ng-model='entry.startYear']");
		workHistoryElements.put("dropdownENDYEAR", "//select[@ng-model='entry.endYear']");
		workHistoryElements.put("buttonADDANOTHERCOMPANY", "//button[@ng-click='addAnother()']");
		workHistoryElements.put("optionFEBRUARY", "//select[@ng-model='entry.startMonth']/option[@label='February']");
		workHistoryElements.put("option2018", "//select[@ng-model='entry.startYear']/option[@label='2018']");
		workHistoryElements.put("optionAPRIL", "//select[@ng-model='entry.startMonth']/option[@label='April']");
		workHistoryElements.put("option2016", "//select[@ng-model='entry.startYear']/option[@label='2016']");
		workHistoryElements.put("optionDECEMBER", "//select[@ng-model='entry.endMonth']/option[@label='December']");
		workHistoryElements.put("option2017", "//select[@ng-model='entry.endYear']/option[@label='2017']");
		workHistoryElements.put("companytitlePEOPLEGROVEINC.", "//span[contains(text(),'PeopleGrove Inc.,')]");
		workHistoryElements.put("companytitleBUBBLEINC", "//span[contains(text(),'Bubble Inc,')]");

		return workHistoryElements.get(xpath_name);
	}

	public void clickOnDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on dropdown " + dropdown);
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");
		GenericMethods.click(driver, xpathCreator("option", option), "xpath");

	}

	public void enterWorkInfoData(String workInfo) {

		String info[] = workInfo.split(",");

		// Company Name
		GenericMethods.input(driver, xpathCreator("input", "Company Name"), "xpath", info[0]);
		clickOn("Search");
		clickOn("Select");

		// location
		WebElement locationElement = driver.findElement(By.xpath(xpathCreator("input", "LOCATION")));

		locationElement.sendKeys(info[1]);

		try {
			Thread.sleep(1500);
			locationElement.sendKeys(Keys.ARROW_DOWN);
			locationElement.sendKeys(Keys.RETURN);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Month
		GenericMethods.click(driver, xpathCreator("dropdown", "startmonth"), "xpath");
		GenericMethods.click(driver, xpathCreator("option", info[2]), "xpath");

		// Year
		GenericMethods.click(driver, xpathCreator("dropdown", "startyear"), "xpath");
		GenericMethods.click(driver, xpathCreator("option", info[3]), "xpath");

		clickOn("checkbox", "I currently work here");

		//role
		GenericMethods.input(driver, xpathCreator("input", "Current Role"), "xpath", info[4]);

		
		//role description
		GenericMethods.input(driver, xpathCreator("input", "Role Description"), "xpath", info[5]);

		clickOn("Continue");

	}

}
