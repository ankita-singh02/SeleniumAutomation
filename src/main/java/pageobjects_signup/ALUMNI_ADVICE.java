package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class ALUMNI_ADVICE {
	WebDriver driver;

	public ALUMNI_ADVICE(WebDriver driver) {
		this.driver = driver;
	}
	public static final String pageTitle="//span[text()='Your Preferences']";

	public void verifyOnAlumniAdvicePage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Alumni Advice Page");
		GenericMethods.assertDisplay(driver, "text", "User Programs",pageTitle );
			

	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Alumni Advice Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");

	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> alumniAdviceElements = new HashMap<String, String>();
		alumniAdviceElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");

		return alumniAdviceElements.get(xpath_name);
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

}
