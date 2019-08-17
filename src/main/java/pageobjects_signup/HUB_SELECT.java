package pageobjects_signup;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;


public class HUB_SELECT {
	WebDriver driver;
	
	public HUB_SELECT(WebDriver driver) {
		this.driver=driver;
		
	}
	 public static final String btnAutomationHub="//span[contains(text(),'Automation')]";
	 public static final String titleHubSelect="//h2[text()='Get started with joining a hub']";
	 public static final String Xpath="xpath";

	 public  void selectAutomationHub() {
		 LogUtils.info("Clicking On Automation Hub");
		 System.out.println("Driver in click method:" +driver);
		GenericMethods.click(driver,btnAutomationHub , Xpath);
	 }

	public void verifyOnHubSelectPage() {
		LogUtils.info("Verifying whether on Hub Select Page");
		JSWaiter.waitForAngularLoad();
		System.out.println("Done verifying");
		//GenericMethods.assertDisplay(driver, "input", "Hub Select Page Title", titleHubSelect);
	}


}
