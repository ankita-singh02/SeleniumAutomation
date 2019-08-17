package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class EventsPage {

	WebDriver driver;

	public EventsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void input(String data, String inputName) {

		LogUtils.info("Inputting data in " + inputName + " on Custom Fields Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);
	}

	public void selectDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on " + dropdown + " and selecting " + option);
		JSWaiter.waitForAngularLoad();
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");
		GenericMethods.click(driver, xpathCreator("option", option), "xpath");
	}

	public void enterDescription(String inputValue) {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(xpathCreator("input", "Event Description"))));
		actions.click().sendKeys(inputValue);
		actions.build().perform();
	}
	
	public static String eventUrl;
	public void copyEventURL() {
		eventUrl=driver.findElement(By.xpath(xpathCreator("input", "Event URL"))).getAttribute("value");
		LogUtils.info("Event URL: "+ eventUrl);
	}

	public void clickon(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Event Page");
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
	
	public void goToEventUrl() {
		System.out.println("Event URL: "+eventUrl);
		driver.navigate().to(eventUrl);		
		JSWaiter.waitForAngularLoad();
	}

	public void verifyInfo(String element_type, String element_name, String element_value) {

		String value=driver.findElement(By.xpath(xpathCreator(element_type, element_name))).getText();
		LogUtils.info("Value from DOM: "+value);
		LogUtils.info("Value from Feature file: "+element_value);
		LogUtils.info("Matching DOM value to Feature file element value (Case Insensitive)");
		Boolean condition=value.toLowerCase().contains(element_value.toLowerCase());
		System.out.println("MATCHING CONDITION: "+condition);
		Assert.assertTrue(condition);
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> eventPageElements = new HashMap<String, String>();

		/* >>>>>>>>>>>>>>>>>>>>>>>>>>> ELEMENTS ON EVENT CARD <<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
		eventPageElements.put("buttonVIEWREGISTRATIONS", "//button[@data-qa='viewRegistrations-button']");
		eventPageElements.put("buttonMOREINFO", "//button[@data-qa='moreInfo-button']");
		eventPageElements.put("buttonEDITEVENT", "//button/span[contains(text(),'Edit')]");
		eventPageElements.put("buttonDELETEEVENT", "//button/span[contains(text(),'Delete')]");
		eventPageElements.put("buttonREGISTER", "//button/span[@data-qa='registerEvent-button']");
		eventPageElements.put("buttonNO", "//button[@data-qa='noEventRegistration-button']/span");
		eventPageElements.put("buttonYES", "//button[@data-qa='yesEventRegistration-button']/span");
		eventPageElements.put("buttonCLICKTOUNREGISTER", "//span[@data-qa='clickToUnregister-button']");
		eventPageElements.put("buttonNEVERMIND", "//span[contains(text(),'Nevermind')]");
		eventPageElements.put("buttonPENDING", "//span[@data-qa='pendingEvent-button']");
		eventPageElements.put("modalbuttonDELETE", "//button[@ng-click='deleteEvent()']");

		/*  >>>>>>>>>>>>>>>>>>>>>>>>>>> ELEMENTS ON EVENT PAGE  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<	 */
		eventPageElements.put("buttonCREATEEVENT", "//button[@data-qa='createEvent-button']");
		eventPageElements.put("buttonCREATEEVENTONMODAL", "//button[@data-qa='createEventModal-button']");
		eventPageElements.put("modalCREATEEVENT", "//h3[text()='Select Event Type']");
		eventPageElements.put("tagAPPROVALPENDING", "//div[@class='unapproved-label' and text()='Approval Pending ']");
		eventPageElements.put("tagREJECTED", "//div[text()='Rejected']");
		eventPageElements.put("infoHEADLINE", "//div[@class='event-data-container']/h3");
		eventPageElements.put("infoEVENTTYPE", "//div[@class='event-data-container']/h4");
		eventPageElements.put("infoEVENTTIME", "//div[@data-qa='eventTime-info']");
		eventPageElements.put("infoSTARTDATE", "//div[@data-qa='eventDate-info']");
		eventPageElements.put("infoLOCATION", "//div[@data-qa='eventLocationAddress-info']");

		/* >>>>>>>>>>>>>>>>>>>>>>>>>>> ELEMENTS ON CREATE EVENT PAGE  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
		eventPageElements.put("toggleDONOTSENDREMINDEREMAIL", "//md-switch[@data-qa='reminderEmail-switch']");
		eventPageElements.put("buttonSUBMIT", "//button[@data-qa='submitEvent-button']");
		eventPageElements.put("buttonOK", "//button[@ng-click='closeDialog()']");
		eventPageElements.put("dropdownEVENTTYPE", "//select[@data-qa='eventType-dropdown']");
		eventPageElements.put("optionTEST", "//option[@label='Test']");
		eventPageElements.put("dropdownSTARTTIME", "//select[@data-qa='startTime-select']");
		eventPageElements.put("dropdownTIMEZONE", "//b[text()='Local: ']");
		eventPageElements.put("inputSTARTDATE", "//input[@placeholder='Enter start date']");
		eventPageElements.put("dateTODAY", "//td[@class='md-calendar-date md-calendar-date-today md-focus']");
		eventPageElements.put("optionKOLKATA", "");
		eventPageElements.put("checkboxSELECTALL", "//md-checkbox[@aria-label='Select All']");
		eventPageElements.put("formCREATEEVENT", "//span[text()='New event:']");
		eventPageElements.put("modalEVENTTYPE", "//h3[text()='Select Event Type']");
		eventPageElements.put("inputHEADLINE", "//input[@data-qa='eventHeadline-input']");
		eventPageElements.put("inputEVENTDESCRIPTION", "//span[text()='Describe the question in more detail']");
		eventPageElements.put("option9:00PM", "//option[@label='9:00 pm']");
		eventPageElements.put("locationMUMBAI", "");
		eventPageElements.put("inputLOCATION", "//input[@options='locationOptions']");
		eventPageElements.put("inputADDRESS", "//input[@data-qa='locationHeader-input']");
		eventPageElements.put("radioSHOWTOEVERYONE", "//md-radio-button[@data-qa='showToEveryone-radio']");
		eventPageElements.put("toggleUNLIMITED", "//md-switch[@data-qa='unlimited-switch']");
		eventPageElements.put("modalEVENTCREATED", "//h4[text()='Event Created']");
		eventPageElements.put("inputEVENTURL", "//input[@id='dialog-event-url']");

		return eventPageElements.get(xpath_name);
	}



}
