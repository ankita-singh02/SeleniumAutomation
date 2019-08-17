package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class InboxPage {
	WebDriver driver;

	public InboxPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickon(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Profile");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
		LogUtils.info("Done clicking");

	}

	public void selectDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on " + dropdown + " and selecting " + option);
		JSWaiter.waitForAngularLoad();
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");
		GenericMethods.click(driver, xpathCreator("option", option), "xpath");
	}

	public void input(String data, String inputName) {

		LogUtils.info("Inputting data in " + inputName + " on Inbox Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);
	}

	public void verifyDisplayOf(String element_type, String element_name) {
		LogUtils.info("Verifying Presence of " + element_name);
		JSWaiter.waitForAngularLoad();
		GenericMethods.assertDisplay(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.print(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println(" XPATH: " + xpath);
		return xpath;
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> inboxPageElements = new HashMap<String, String>();

		inboxPageElements.put("", "");
		inboxPageElements.put("tagPENDING", "//div[@class='status pending']");
		inboxPageElements.put("tagUPCOMINGMEETING", "//div[@class='status upcoming']");
		inboxPageElements.put("tagPENDINGMEETING", "//div[@class='status pending']");

		inboxPageElements.put("buttonACCEPTREQUEST", "//button[@ng-click=\"updateRequest('active')\"]");
		inboxPageElements.put("inputSENDMESSAGE", "//div[@class='send-message']/textarea");
		inboxPageElements.put("buttonSUBMIT", "//button[@ng-click='postMessageToThread()']");
		inboxPageElements.put("iconCALENDAR", "//button[@ng-click='scheduleMeeting()']");
		inboxPageElements.put("iconCLOSEMENTORSHIP", "//button[@ng-click='closeThread()']");
		inboxPageElements.put("sentMESSAGE", "//div[text()='This is AMAZING!']");
		inboxPageElements.put("buttonPOLITELYDECLINE", "//button[@ng-click=\"updateRequest('rejected')\"]");
		inboxPageElements.put("textDECLINEMESSAGE", "//p[contains(text(),'You have declined this request')]");
		inboxPageElements.put("textREJECTMESSAGE",
				"//p[@ng-if=\"mentorship.isMentee && (mentorship.type === 'longTermMentorship' || mentorship.type === 'advisorMeeting')\"]");
		inboxPageElements.put("tagONGOING", "//div[@class='status ongoing']");
		inboxPageElements.put("textCLOSEDCONVERSATION", "//span[contains(text(),'Conversation Closed')]");
		inboxPageElements.put("buttonYES", "//span[contains(text(),'Yes')]");
		inboxPageElements.put("linkVIEWEDITREQUEST", "//a[contains(text(),'View / Edit Request')]");
		inboxPageElements.put("buttonPROPOSEOTHERTIMES", "//button[@ng-click='newTimes.proposingTime=true']");
		inboxPageElements.put("iconDATE", "//md-icon[@class='md-datepicker-calendar-icon']");
		inboxPageElements.put("buttonSENDNEWTIMES", "//button[@ng-click=\"sendNewTimes(null, 'pending')\"]");
		inboxPageElements.put("buttonREVIEWANDSCHEDULE", "//button[@ng-click='scheduleMeeting(meeting)']");
		inboxPageElements.put("dropdownTIME", "//select[@default-option='Time']");
		inboxPageElements.put("option2:00PM", "//option[@label='2:00 pm']");
		inboxPageElements.put("linkCLICKHERE", "//a[contains(text(),'click here')] ");
		inboxPageElements.put("buttonCANCELMEETING", "//button[@ng-click='reject()']");
		inboxPageElements.put("textMEETINGDECLINED", "//div[@ng-if=\"meeting.status === 'rejected'\"]");
		inboxPageElements.put("buttonCLOSE", "//i[@ng-click='close()']");

		inboxPageElements.put("alertPENDINGMEETING", "//h1[text()='Pending meeting request']");
		inboxPageElements.put("alertUPCOMINGMEETING", "//h1[text()='Upcoming meeting']");
		inboxPageElements.put("radioPHONECALL", "//md-radio-button[@ng-value=\"'phone call'\"]");
		inboxPageElements.put("inputPHONENUMBER", "//input[contains(@placeholder,'Best number to reach you')]");
		inboxPageElements.put("linkCHANGE", "//a[@ng-click='editingTimezone = true']");
		inboxPageElements.put("dropdownTIMEZONE", "//b[@class='group-name']");
		inboxPageElements.put("inputTIMEZONE", "//div[@class='chosen-search']");
		inboxPageElements.put("optionKOLKATA", "//li[contains(text(),'Asia/Kolkata (UTC+05:30)')]");
		inboxPageElements.put("icon1STCROSS", "//div[@class='select-time-directive']/div[2]/i");
		inboxPageElements.put("inputDATE", "//input[@class='md-datepicker-input']");
		inboxPageElements.put("buttonSENDREQUEST", "//button[@ng-click='submitRequest()']");
		inboxPageElements.put("radioTIME", "//md-radio-button");
		inboxPageElements.put("inputTEXTAREA", "//textarea");
		inboxPageElements.put("buttonSCHEDULEMEETING", "//button[@ng-click='acceptRequest()']");
		inboxPageElements.put("textPHONECALL", "//span[text()='phone call']");
		inboxPageElements.put("textPHONENUMBER", "//p[text()='PHONE NUMBER: 123456789']");
		inboxPageElements.put("buttonRETURNTOINBOX", "//button[@ng-click='goToInbox();']");
		inboxPageElements.put("buttonCANCEL", "//button[@aria-label='Cancel']");
		inboxPageElements.put("buttonCONFIRMCANCELLATION", "//button[@aria-label='Confirm Cancellation']");
		inboxPageElements.put("iconCLOSE", "//i[@ng-click='close()']");
		inboxPageElements.put("buttonCANCEL/RESCHEDULE", "//button[@ng-click='scheduleMeeting(meeting)']");
		inboxPageElements.put("option3:00PM", "//option[@label='3:00 pm']");
		inboxPageElements.put("", "");
		inboxPageElements.put("", "");
		inboxPageElements.put("", "");

		return inboxPageElements.get(xpath_name);
	}

	public void selectDate(String dateId) {
		String xpath = "//td[contains(@aria-label,'" + dateId + "')]";
		LogUtils.info("Selecting date: " + dateId);
		GenericMethods.click(driver, xpath, "xpath");
		LogUtils.info("Done clicking");

	}

	public void verifyThreadMessage(String message) {
		String xpath = "//div[contains(text(),'" + message + "')]";
		LogUtils.info("Verifying presence of: " + message);
		JSWaiter.waitForAngularLoad();
		GenericMethods.assertDisplay(driver, "text", "message", xpath);
	}

	public void assertProposedTime(String date_time) {
		String xpath = "//li[contains(text(),'" + date_time + "')]"; // li[contains(text(),'January 1, 2019 2:00 pm -
																		// 2:30 pm')]

		LogUtils.info("Verifying Presence of " + date_time);
		JSWaiter.waitForAngularLoad();
		GenericMethods.assertDisplay(driver, "text", "Proposed Times", xpath);

	}

	public void verifyAbsenceOf(String element_type, String element_name) {
		GenericMethods.assertAbsence(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

}
