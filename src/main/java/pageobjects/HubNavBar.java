package pageobjects;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class HubNavBar {

	WebDriver driver;
	public static final String eventTab="//md-tab-item/span[@class='hub-action-tab' and contains(text(),'Event')]";
	
	public HubNavBar(WebDriver driver) {

		this.driver=driver;
	}
	public void clickOnTab(String tab) {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Clicking on Tab: "+tab);
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=tab.replace(" ", "").toUpperCase();
		switch(value) {
		case "EVENT":  GenericMethods.click(driver, eventTab, "xpath"); break;
		case "HOME" :  GenericMethods.click(driver, "//md-tab-item/span[@class='hub-action-tab' and contains(text(),'Home')]", "xpath"); break;
		}
		JSWaiter.waitForAngularLoad();
		
	}
	
	

}
