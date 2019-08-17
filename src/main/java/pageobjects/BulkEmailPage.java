package pageobjects;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.JavascriptUtils;
import utils.LogUtils;

public class BulkEmailPage {
	public static String emailLink = "something";
	WebDriver driver;

	public BulkEmailPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyDisplayOf(String element_type, String element_name) {
		LogUtils.info("Verifying Presence of " + element_name);
		JSWaiter.waitForAngularLoad();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		GenericMethods.assertDisplay(driver, element_type, element_name, xpathCreator(element_type, element_name));

	}

	public void verifyAbsenceOf(String element_type, String element_name) {
		GenericMethods.assertAbsence(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	public void clickOnDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on " + dropdown + " and selecting " + option);
		JSWaiter.waitForAngularLoad();
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");

		GenericMethods.click(driver, xpathCreator("option", option), "xpath");
	}

	public void enterInput(String data, String inputName) {

		LogUtils.info("Inputting data in " + inputName + " on Bulk Email Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);

	}

	public void enterEmailBody() {
		WebElement emailbody = driver
				.findElement(By.xpath("//div[@class='fr-inner-container fr-inner-container-medium']/p"));
		LogUtils.info("Clicking on email body");
		Actions builder = new Actions(driver);
		Action input = builder.moveToElement(emailbody).click().sendKeys("This is an Automated Email Body ").build();
		input.perform();
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Email input done");
		LogUtils.info("Clicking on Merge Tags Button");
		WebElement element = driver.findElement(By.xpath("//button/span[contains(text(),'Insert Merge')]"));
		JavascriptUtils.bringIntoView(element);
		GenericMethods.click(driver, "//button/span[contains(text(),'Insert Merge')]", "xpath");
		JavascriptUtils.bringIntoView(driver.findElement(By.xpath("//div/span[contains(text(),'First Name')]")));
		LogUtils.info("Clicking on FirstName");
		try {
			GenericMethods.click(driver, "//div/span[contains(text(),'First Name')]", "xpath");

		} catch (Exception e) {
			LogUtils.info("Issue in adding merge tags");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String enterInternalTracking() {
		LogUtils.info("Entering INternal Tracking field");
		JSWaiter.waitForAngularLoad();
		Random rand = new Random();
		int i = rand.nextInt(10000) + rand.nextInt(10000);
		final String data = "AutomatedClassicEmail_" + i;
		emailLink = data;
		System.out.println("Email Link:" + emailLink);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		GenericMethods.input(driver, "//input[@data-qa='internalTrackingName-input']", "xpath", data);

		return data;
	}

	public void clickon(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Bulk Email Page");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> bulkEmailElements = new HashMap<String, String>();
		bulkEmailElements.put("buttonNEWMESSAGE", "//a[@data-qa='createNewMessage-button']");
		bulkEmailElements.put("overlayCHOOSEEDITOR", "//div[@data-qa='chooseEditor-overlay']/p");
		bulkEmailElements.put("buttonUSECLASSICEMAILEDITOR", "//button[@data-qa='classicEditor-button']");
		bulkEmailElements.put("buttonSELECTRECIPIENTS", ".//button[@data-qa='selectRecipients-button']/span");
		bulkEmailElements.put("overlaySELECTRECIPIENTS", "//div[@class='new-content-container']");
		bulkEmailElements.put("radioSPECIFICINDIVIDUALS", "//md-radio-button[@data-qa='individuals-radio-button']");
		bulkEmailElements.put("tableEXPLOREUSERS", "//button[@data-qa='selectUsers-button']");
		bulkEmailElements.put("buttonSELECTUSERS", "//button[@data-qa='selectUsers-button']");
		bulkEmailElements.put("checkboxFIRSTUSER", "//td/md-checkbox");
		bulkEmailElements.put("linkCLICKTOUPDATE", "//a[contains(text(),'(click to update)')]");
		bulkEmailElements.put("dropdownSELECTTEMPLATE",
				"//pg-ui-dropdown-button[@data-qa='availableTemplates-button']/div");
		bulkEmailElements.put("optionBLANKTEMPLATE", "//a[contains(text(),'Blank Template')]");
		bulkEmailElements.put("buttonCONFIRM", "//button/span[contains(text(),'Confirm')]");
		bulkEmailElements.put("inputSUBJECT", "//input[@data-qa='subject-input']");
		bulkEmailElements.put("dropdownSENDSCHEDULE", "//span[contains(text(),'Send / Schedule')]");
		bulkEmailElements.put("optionSENDNOW", "//li/a[contains(text(),'Send Now')]");
		bulkEmailElements.put("modalEMAILCONFIRMATION", "//h4[text()='Email Confirmation']");
		bulkEmailElements.put("buttonSENDNOW", "//button[@data-qa='sendNow-button']/span");
		bulkEmailElements.put("buttonINSERTMERGETAGS", "//button/span[contains(text(),'Insert Merge')]");
		bulkEmailElements.put("optionMERGETAGFIRSTNAME", "//div/span[contains(text(),'First Name')]");
		bulkEmailElements.put("inputINTERNALTRACKINGNAME", "//input[@data-qa='internalTrackingName-input']");
		bulkEmailElements.put("inputEMAILBODY", "//div[@class='fr-inner-container fr-inner-container-medium']/p");
		return bulkEmailElements.get(xpath_name);
	}

	public void verifyDisplayOfEmailLink() {

		String emailLinkXPATH = "//a[@data-qa='title-link' and contains(text(),'" + emailLink + "')]";
		GenericMethods.assertDisplay(driver, "LINK", "Email link", emailLinkXPATH);
	}

}
