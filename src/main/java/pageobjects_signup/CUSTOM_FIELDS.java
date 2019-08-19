package pageobjects_signup;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class CUSTOM_FIELDS {
	WebDriver driver;

	public CUSTOM_FIELDS(WebDriver driver) {
		this.driver = driver;
	}

	public static final String pageTitle = "//span[text()='What else do you want others to know about you?']";

	public void verifyOnCustomFieldsPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Custom Fields Page");
		GenericMethods.assertDisplay(driver, "text", "Custom Fields", pageTitle);
	}

	public void enterCustomDetails(String details) {

		String info[] = details.split(",");
		enterInput("Number Custom Field", info[0]);
		enterInput("Text Custom Field", info[1]);
		inputLocation(info[2]);
		enterInput("Link Custom Field", info[3]);
		enterInput("Long Custom Field", info[3]);
		clickOn("checkbox", "Checkbox Custom Field");
		clickOn("button", "Select");
		clickOn("checkbox", "Test 2");
		clickOn("button", "Save");
		selectDate();
		clickOn("button", "Continue");

	}

	public void enterInput(String inputName, String data) {
		LogUtils.info("Inputting data in " + inputName + " on Custom Fields Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);

	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Custom Fields Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");

	}

	public void inputLocation(String location) {
		LogUtils.info("Entering " + location + " in Location Field");
		WebElement locationElement = driver.findElement(By.xpath(xpathCreator("input", "LOCATION CUSTOM FIELD")));

		locationElement.sendKeys(location);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		locationElement.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		// locationElement.sendKeys(Keys.RETURN);
		JSWaiter.waitForAngularLoad();
	}

	public void selectDate() {
		LogUtils.info("Clicking on Calendar Icon on Custom Fields Page");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GenericMethods.click(driver, xpathCreator("icon", "calendar"), "xpath");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> date = driver.findElements(By.xpath(xpathCreator("date", "2")));
		System.out.println(date.size());
		date.get(0).click();

	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> customFieldElements = new HashMap<String, String>();
		customFieldElements.put("inputNUMBERCUSTOMFIELD", "//input[@data-qa='custom-number-input']");
		customFieldElements.put("inputTEXTCUSTOMFIELD", "//input[@data-qa='custom-text-input']");
		customFieldElements.put("inputLOCATIONCUSTOMFIELD",
				"//md-autocomplete[@placeholder='Your Location']/md-autocomplete-wrap/input");
		customFieldElements.put("inputLONGCUSTOMFIELD", "//p[@placeholder='Long Custom Field Placeholder']");
		customFieldElements.put("inputLINKCUSTOMFIELD", "//input[@data-qa='custom-url-input']");
		customFieldElements.put("checkboxCHECKBOXCUSTOMFIELD", "//md-checkbox[@data-qa='custom-checkbox']");
		customFieldElements.put("buttonSELECT", "//button[@data-qa='select-button']");
		customFieldElements.put("buttonSAVE", "//button[@ng-click='saveDialog()']");
		customFieldElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");
		customFieldElements.put("checkboxTEST2", "//span[text()=' Test 2']");
		customFieldElements.put("iconCALENDAR", "//button[@aria-label='Open calendar']/div");
		customFieldElements.put("date2", "//span[text()='2']");
		customFieldElements.put("locationMUMBAI", "//span[text()='Mumbai, Maharashtra, India']");

		return customFieldElements.get(xpath_name);
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

}
