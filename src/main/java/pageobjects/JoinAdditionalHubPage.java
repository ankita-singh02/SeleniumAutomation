package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class JoinAdditionalHubPage {
	WebDriver driver;
	public JoinAdditionalHubPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public static final String pageTitle="//div[@class='browse-page-header']";


	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on "+element_name +" on Work History Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
		
	}
	
	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type+element_name.replace(" ", "").toUpperCase());
		String xpath= elementMap(element_type+element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: "+xpath);
		return xpath;
	}
	
	public static String elementMap(String xpath_name) {
		HashMap<String, String> joinAdditionalHubElements = new HashMap<String, String>();
		joinAdditionalHubElements.put("buttonSKIPFORNOW", "//span[@ng-click='skip()']");

		return joinAdditionalHubElements.get(xpath_name);
	}



	public void verifyOnJoinAdditionalHubPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Join Additional Hub Page");
		GenericMethods.assertDisplay(driver, "text", "Browse Hubs",pageTitle );
				
	}

}
