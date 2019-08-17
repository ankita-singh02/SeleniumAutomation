package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.LogUtils;

public class ApprovalQueuesPage {
	
	WebDriver driver;
	public ApprovalQueuesPage(WebDriver driver) {
		this.driver=driver;
	}
	public void goTo(String option) {
		// TODO Auto-generated method stub
		
	}
	public void clickOn(String elementType, String elementName) {
		LogUtils.info("Clicking on " + elementName + " on Approval Page");
		GenericMethods.click(driver, xpathCreator(elementType, elementName), "xpath");
		LogUtils.info("Done clicking");		
	}
	
	
	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> approvePageElements = new HashMap<String, String>();

		approvePageElements.put("", "");
		return approvePageElements.get(xpath_name);
	}
	
	public void eventAction(String action) {
		if(action.equalsIgnoreCase("REJECTS")) {
			GenericMethods.click(driver, "//button[@ng-click='vm.updateEvent(event, false)']", "xpath");
		}
		else if(action.equalsIgnoreCase("APPROVES")) {
			GenericMethods.click(driver, "//button[@ng-click='vm.updateEvent(event, true)']", "xpath");

		} else {
			LogUtils.error("Action in feature file not found in Approval Page Object class");
		}
		
	}
	
	

}
