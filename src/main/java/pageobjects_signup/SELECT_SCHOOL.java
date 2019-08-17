package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class SELECT_SCHOOL {
	WebDriver driver;

	public SELECT_SCHOOL(WebDriver driver) {
		this.driver = driver;
	}

	public void schoolDetails(String info) {
		System.out.println("Info : " + info);
		String school_info[] = info.split(",");
		selectSchool(school_info[0]);
		inputAndSelect("Majors", school_info[1]);
		inputAndSelect("Minors", school_info[2]);
		clickOnDropdownOption("Degree Type", school_info[3]);
		clickOnDropdownOption("Graduation Year", school_info[4]);
		clickOnDropdownOption("Specialization Branch", school_info[5]);
		clickOn("button", "Continue");
		clickOn("button", "Continue");

	}

	public static final String pageTitle = "//span[text()='Your Education']";

	public void verifyOnSelectSchoolPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Select School");
		GenericMethods.assertDisplay(driver, "text", "Your Education", pageTitle);

	}

	public void selectSchool(String schoolName) {
		LogUtils.info("Entering School Name: " + schoolName);
		GenericMethods.input(driver, xpathCreator("input", "SCHOOL"), "xpath", schoolName);
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Clicking on option");
		JSWaiter.waitForAngularLoad();
		GenericMethods.click(driver, "//span[contains(text(),'CampusKudos')]", "xpath");

	}

	public void inputAndSelect(String element_name, String data) {
		LogUtils.info("Entering " + data + " in" + element_name + "on Select School Page");
		GenericMethods.input(driver, xpathCreator("input", element_name), "xpath", data);
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Selecting the entered option");
		// driver.findElement(By.xpath("//span[contains(text(),'"+data+"')]"));
		driver.findElement(By.xpath(xpathCreator("input", element_name))).sendKeys(Keys.RETURN);
	}

	public void clickOnDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on dropdown " + dropdown);
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");
		GenericMethods.click(driver, xpathCreator("option", option), "xpath");

	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Select School Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> selectSchoolElements = new HashMap<String, String>();
		selectSchoolElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");
		selectSchoolElements.put("inputSCHOOL",
				"//md-autocomplete[@data-qa='school-autocomplete']/md-autocomplete-wrap/input");
		selectSchoolElements.put("inputMAJORS",
				"//md-autocomplete[@data-qa='majors-autocomplete']/md-autocomplete-wrap/input");
		selectSchoolElements.put("inputMINORS",
				"//md-autocomplete[@data-qa='minors-autocomplete']/md-autocomplete-wrap/input");
		selectSchoolElements.put("dropdownGRADUATIONYEAR", "//select[@data-qa='gradYear-dropdown']");
		selectSchoolElements.put("dropdownDEGREETYPE", "//select[@data-qa='degreeType-dropdown']");
		selectSchoolElements.put("option2017", "//option[@label='2017']");
		selectSchoolElements.put("optionTEST1", "//option[contains(@label,'test 1')]");
		selectSchoolElements.put("dropdownSPECIALIZATIONBRANCH", "//select[@ng-change='selectExtraFieldValue()']");
		selectSchoolElements.put("optionTESTAUTOMATION", "//option[@label='Test Automation']");

		return selectSchoolElements.get(xpath_name);
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

}
