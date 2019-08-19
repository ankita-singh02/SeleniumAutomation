package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class SMS_NOTIFICATIONS {
	WebDriver driver;
	
	public SMS_NOTIFICATIONS(WebDriver driver) {
		this.driver=driver;
	}
    public static final String pageTitle="//span[text()='sms notifications']";

	public void verifyOnSmsNotificationsPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Sms Notification Page");
		GenericMethods.assertDisplay(driver, "text", "Sms Notification",pageTitle );
				
	}
	
	public void enterSmsNotifiationDetails(String details) {
		
		String info[]=details.split(",");
		
		System.out.println("INFO : " + info);
		clickOn("checkbox", info[0]);
		clickOn("checkbox", info[1]);
		clickOn("checkbox", info[2]);
		input("Phone Number", info[3]);
		clickOn("button", "Continue");




	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on "+element_name +" on SMS Notifications Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");		
	
	}
	public void input(String inputName, String data) {
		LogUtils.info("Inputting data in "+inputName +" on SMS Notifications Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);
				
	}
	public static String elementMap(String xpath_name) {
		HashMap<String, String> smsNotificationElements = new HashMap<String, String>();

		smsNotificationElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");
		smsNotificationElements.put("checkboxNEWCONNECTIONREQUESTS", "//md-checkbox[@data-qa='newConnectionRequest-checkbox']");
		smsNotificationElements.put("checkboxUPCOMINGMEETINGS", "//md-checkbox[@data-qa='upcomingMeeting-checkbox']");
		smsNotificationElements.put("checkboxNEWMESSAGE", "//md-checkbox[@data-qa='newMessage-checkbox']");
		smsNotificationElements.put("inputPHONENUMBER", "//input[@data-qa='smsNumber-input']");

	
		return smsNotificationElements.get(xpath_name);
	}
	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type+element_name.replace(" ", "").toUpperCase());
		String xpath= elementMap(element_type+element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: "+xpath);
		return xpath;
	}
}
