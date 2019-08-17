package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class CALENDAR_SYNC {
	WebDriver driver;
	
	public CALENDAR_SYNC(WebDriver driver) {
		this.driver=driver;
	}

	public static final String pageTitle="//span[text()='Sync Calendar']";
	public void verifyOnCalendarSyncPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Calendar Sync Page");
		GenericMethods.assertDisplay(driver, "text", "Calendar Sync",pageTitle );
	
	}

	public void clickOnDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on dropdown "+dropdown);
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");
		GenericMethods.click(driver, xpathCreator("option", option), "xpath");
		
	}

	public void selectWeekdays() {

		LogUtils.info("Checking checkboxes for all the weekdays on Calendar Sync Page");
		LogUtils.info("Checking checkboxes for MONDAY");
		GenericMethods.click(driver, xpathCreator("checkbox", "MONDAY"), "xpath");
		LogUtils.info("Checking checkboxes for TUESDAY");
		GenericMethods.click(driver, xpathCreator("checkbox", "TUESDAY"), "xpath");
		LogUtils.info("Checking checkboxes for WEDNESDAY");
		GenericMethods.click(driver, xpathCreator("checkbox", "WEDNESDAY"), "xpath");
		LogUtils.info("Checking checkboxes for THURSDAY");
		GenericMethods.click(driver, xpathCreator("checkbox", "THURSDAY"), "xpath");
		LogUtils.info("Checking checkboxes for FRIDAY");
		GenericMethods.click(driver, xpathCreator("checkbox", "FRIDAY"), "xpath");

	}

	public void clickAndinputValue(String inputName, String data) {
		LogUtils.info("Inputting "+data+" in "+inputName +" on Calendar Sync Page");
		GenericMethods.clickAndInput(driver, xpathCreator("input", inputName), "xpath", data);
				
	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on "+element_name +" on Calendar Sync Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");		
	}
	
	public static String elementMap(String xpath_name) {
		HashMap<String, String> calendarSyncElements = new HashMap<String, String>();
		calendarSyncElements.put("buttonSAVESETTINGS", "//button[@data-qa='saveSettings-button']");
		calendarSyncElements.put("checkboxMONDAY", "//span[contains( text(),'Monday' )]");
		calendarSyncElements.put("checkboxTUESDAY", "//span[contains( text(),'Tuesday')]");
		calendarSyncElements.put("checkboxWEDNESDAY", "//span[contains( text(),'Wednesday')]");
		calendarSyncElements.put("checkboxTHURSDAY", "//span[contains( text(),'Thursday')]");
		calendarSyncElements.put("checkboxFRIDAY", "//span[contains( text(),'Friday')]");
		calendarSyncElements.put("dropdownCALENDARSETUP", "//select[@data-qa='manageCalendar-select']");
		calendarSyncElements.put("dropdownMINIMUMNOTICE", "//select[@ng-model='model.settings.minimumNotice']");
		calendarSyncElements.put("dropdownMAXIMUMNOTICE", "//select[@ng-model='model.settings.maxNotice']");
		calendarSyncElements.put("option2WEEKS", "//option[@label='2 weeks']");
		calendarSyncElements.put("option1DAY", "//option[@label='1 day']");
		calendarSyncElements.put("option30MINUTES", "//option[@label='30 minutes']");
		calendarSyncElements.put("optionMANAGECALENDARLOCALLY","//option[@data-qa='manageLocally-option']");
		calendarSyncElements.put("inputINVITEMESSAGE","//span[@class='fr-placeholder']");

		return calendarSyncElements.get(xpath_name);
	}
	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type+element_name.replace(" ", "").toUpperCase());
		String xpath= elementMap(element_type+element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: "+xpath);
		return xpath;
	}

}
