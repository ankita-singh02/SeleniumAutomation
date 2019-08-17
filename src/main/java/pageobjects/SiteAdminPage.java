package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class SiteAdminPage {
	WebDriver driver;
	public SiteAdminPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickon(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Site Admin Elements");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
		LogUtils.info("Done clicking");
		
	}
	public void goToHubAdminCard(String adminLink, String settingCard) {

		clickon("dropdown", "ADMIN");
		clickon("option", "HUB ADMIN");
		clickon("link", adminLink);
		JSWaiter.waitForAngularLoad();
		clickon("card", settingCard);
		
	}
	
	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> siteAdminElements = new HashMap<String, String>();
		siteAdminElements.put("dropdownADMIN", "//a[@title='Admin']");
		siteAdminElements.put("optionHUBADMIN", "//a[contains(text(),'Hub Admin') and @class='large-pad']");
		//LINKS
		siteAdminElements.put("linkAPPROVALQUEUES", "//p[@data-qa='approvalQueuesLink']");
		siteAdminElements.put("linkHOME", "//p[@data-qa='homeLink']");
		siteAdminElements.put("linkEVENTMANAGEMENT", "//p[@data-qa='eventManagementLink']");
		siteAdminElements.put("linkEMAILANDNOTIFICATIONS", "//p[@data-qa='emailAndNotificationLink']");
		siteAdminElements.put("linkMATCHINGANDINTROS", "//p[@data-qa='matchingAndIntroLink']");
		siteAdminElements.put("linkRESOURCESANDBANNERS", "//p[@data-qa='resourcesAndBannerLink']");
		siteAdminElements.put("linkINITIALSETUP", "//p[@data-qa='initialSetupLink']");
		siteAdminElements.put("linkADVANCESETTINGS", "//p[@data-qa='advanceSettingsLink']");
		siteAdminElements.put("linkUSERSANDANALYTICS", "//p[@data-qa='usersAndAnalyticsLink']");

		// CARDS
		siteAdminElements.put("cardAPPROVEEVENTS", ".//md-card[@data-qa='approveEventsCard']");
		siteAdminElements.put("cardBULKEMAILS", ".//md-card[@data-qa='bulkEmailCard']");
		siteAdminElements.put("cardAPPROVEQUESTIONS", "//md-card[@data-qa='approveQuestionsCard']");
		siteAdminElements.put("card", "");
		siteAdminElements.put("card", "");
		siteAdminElements.put("card", "");
		siteAdminElements.put("card", "");
		siteAdminElements.put("card", "");
		siteAdminElements.put("card", "");
		siteAdminElements.put("buttonAPPROVE", "//button[@ng-click='actionOnApplicants(question, true)']");
		siteAdminElements.put("buttonREJECT", "//button[@ng-click='actionOnApplicants(question, false)']");

		

		return siteAdminElements.get(xpath_name);
	}



}
