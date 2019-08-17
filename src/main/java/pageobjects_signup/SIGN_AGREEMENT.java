package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class SIGN_AGREEMENT {
	WebDriver driver;
	
	public SIGN_AGREEMENT(WebDriver driver) {
		this.driver=driver;
	}
    public static final String pageTitle="//span[text()='AGREEMENTS']";

	public void verifyOnSignAgreementPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Agreement Page");
		GenericMethods.assertDisplay(driver, "text", "Agreement",pageTitle );
					
	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on "+element_name +" on Sign Agreement Page");
		JSWaiter.waitForAngularLoad();
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");	
		JSWaiter.waitForAngularLoad();
	}

	public void drawSign() {
		LogUtils.info(" Drawing Signature on Canvas");
		GenericMethods.drawSign(driver, "//canvas[@data-qa='drawSign-canvas']");
		
		
	}

	public void checkAgreement() {
		LogUtils.info("Clicking on Agreement Checkbox ");
		System.out.println("Clicking on next");
		GenericMethods.click(driver, "//button[@data-qa='next-button']", "xpath");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GenericMethods.click(driver, "//span[text()='I have read the entire agreement above.']", "xpath");
		
		
	}
	
	public static String elementMap(String xpath_name) {
		HashMap<String, String> agreementPageElements = new HashMap<String, String>();
		agreementPageElements.put("buttonNEXT", "//button[@data-qa='next-button']");

		return agreementPageElements.get(xpath_name);
	}
	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type+element_name.replace(" ", "").toUpperCase());
		String xpath= elementMap(element_type+element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: "+xpath);
		return xpath;
	}

}
