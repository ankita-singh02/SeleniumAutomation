package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class ProfilePage {
	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickon(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Profile");
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

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

	public void clearText(String inputName) {
		String xpath = xpathCreator("input", inputName);
		GenericMethods.clearText(driver, xpath);

	}

	public void selectDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on " + dropdown + " and selecting " + option);
		JSWaiter.waitForAngularLoad();
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");
		GenericMethods.click(driver, xpathCreator("option", option), "xpath");
	}

	public void input(String data, String inputName) {

		LogUtils.info("Inputting data in " + inputName + " on Profile Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> profilePageElements = new HashMap<String, String>();

		// >>>>>>>>>>>>>>>>>>> ELEMENTS ON EVENT TAB <<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		profilePageElements.put("tagAPPROVALPENDING",
				"//div[@class='unapproved-label' and text()='Approval Pending ']");
		profilePageElements.put("tagREJECTED", "//div[text()='Rejected']");
		profilePageElements.put("buttonLETSCONNECT", "//span[text()=\"Let's Connect\"]");
		profilePageElements.put("buttonLONGTERMMENTORSHIP", "//h3[text()='Long-Term Mentorship']");
		profilePageElements.put("inputPERSONALMESSAGE", "//div/textarea");
		profilePageElements.put("buttonSENDREQUEST", "//button[@ng-click='sendMentorshipRequest()']");
		profilePageElements.put("buttonFLASHMENTORSHIP", "//h3[text()='Flash Mentorship']");
		profilePageElements.put("inputTEXTAREA", "//div/textarea");
		profilePageElements.put("buttonREQUESTMENTOR", "//button[@ng-click='sendMentorshipRequest()']");
		profilePageElements.put("checkboxRESUME", "//span[contains(text(),'Resume')]");
		profilePageElements.put("buttonFLASHMENTORSHIP", "//h3[contains(text(),'Flash Mentorship')]");
		profilePageElements.put("buttonNEXT", "//button[contains(@aria-label,'Next')]");
		profilePageElements.put("radioONLINEVIDEOCALL", "//md-radio-button[@value='video call']");
		profilePageElements.put("dropdownDURATION", "//select[@ng-change='updateMeetingLength()']");
		profilePageElements.put("option1HOUR", "//option[@label='1 hour']");
		profilePageElements.put("buttonCONFIRM&CONTINUE", "//button[@ng-click='completedTimeSelectionStep()']");
		profilePageElements.put("buttonSEND", "//button[@ng-click='sendMessage()']");
		profilePageElements.put("inputDATE", "//input[@class='md-datepicker-input']");
	

		profilePageElements.put("", "");
		profilePageElements.put("", "");
		profilePageElements.put("", "");
		profilePageElements.put("", "");
		profilePageElements.put("", "");
		profilePageElements.put("", "");

		return profilePageElements.get(xpath_name);
	}

}
