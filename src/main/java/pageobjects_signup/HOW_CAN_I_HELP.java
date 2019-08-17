package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class HOW_CAN_I_HELP {
	WebDriver driver;
	
	public HOW_CAN_I_HELP(WebDriver driver) {
		this.driver=driver;
	}

	public static final String pageTitle="//span[text()='Let others know how you can help (filter selection)']";

	public void verifyOnHowCanIHelp() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of How Can I Help Page");
		GenericMethods.assertDisplay(driver, "text", "How Can I Help Page",pageTitle );
		
	}
	
	public void enterHowCanIHelpDetails(String details) {
		String info[]=details.split(",");
		clickOn("checkbox", info[0]);
		clickOn("checkbox", info[1]);
		clickOn("button", "Continue");
				
	}


	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on "+element_name +" on How Can I Help Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");		
	}
	
	public static String elementMap(String xpath_name) {
		
		HashMap<String, String> howCanIHelpPage = new HashMap<String, String>();
		howCanIHelpPage.put("buttonSAVESETTINGS", "//button[@data-qa='saveSettings-button']");
		howCanIHelpPage.put("checkboxADVERTISING","//span[contains(text(),' Advertising')]");
		howCanIHelpPage.put("checkboxCHOOSINGAMAJOR","//span[contains(text(),' Choosing a Major')]");
		howCanIHelpPage.put("buttonCONTINUE", "//button[@data-qa='continue-button']");

		return howCanIHelpPage.get(xpath_name);
	}
	
	private String xpathCreator(String element_type, String element_name) {
		
		System.out.println(element_type+element_name.replace(" ", "").toUpperCase());
		String xpath= elementMap(element_type+element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: "+xpath);
		return xpath;
	}

}
