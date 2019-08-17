package pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.JavascriptUtils;
import utils.LogUtils;
import utils.WaitTool;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickon(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Event Page");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
		LogUtils.info("Done clicking");

	}

	public void input(String data, String inputName) {

		LogUtils.info("Inputting data in " + inputName + " on Home Tab");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);
	}

	public void verifyDisplayOf(String element_type, String element_name) {
		LogUtils.info("Verifying Presence of " + element_name);
		JSWaiter.waitForAngularLoad();
		GenericMethods.assertDisplay(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	public void verifyAbsenceOf(String element_type, String element_name) {
		GenericMethods.assertAbsence(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	public void verifyInfo(String element_type, String element_name, String element_value) {

		String value = driver.findElement(By.xpath(xpathCreator(element_type, element_name))).getText();
		LogUtils.info("Value from DOM: " + value);
		LogUtils.info("Value from Feature file: " + element_value);
		LogUtils.info("Matching DOM value to Feature file element value (Case Insensitive)");
		Boolean condition = value.toLowerCase().contains(element_value.toLowerCase());
		System.out.println("MATCHING CONDITION: " + condition);
		Assert.assertTrue(condition);
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.print(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println(" XPATH: " + xpath);
		return xpath;
	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> homePageElements = new HashMap<String, String>();

		// >>>>>>>>>>>>>>>>>>>> RECOMMENDED SECTION <<<<<<<<<<<<<<<<<<<<<<<<<

		homePageElements.put("buttonUPDATEMATCHINGPREFERENCES", "//span[@ng-click='showMatchingPreferences()']");
		homePageElements.put("buttonBROWSEALLPEOPLE", "//span[@ng-click=\"goToPath('/people')\"]");
		homePageElements.put("modalMATCHINGQUESTIONS", "//h4[text()='MATCHING QUESTIONS']");
		homePageElements.put("buttonNEXT", "//span[@ng-if='model.step !== model.totalSteps']");
		homePageElements.put("buttonSAVE", "//button[@ng-click='nextStep()']");
		homePageElements.put("cardPERSON", "//div[@user='person']");
		homePageElements.put("iconBOOKMARK", "//div[@class='bookmark']");
		homePageElements.put("buttonSKIP", "//div[@class='skip-button']");
		homePageElements.put("buttonCROSS", "//i[@ng-click='close()']");
		homePageElements.put("buttonFULLPROFILE", "//div[@ng-analytics='Profile Card - Full Profile Clicked']");
		homePageElements.put("buttonLETSCONNECT", "//div[@ng-analytics='Connect Button Clicked']");
		homePageElements.put("buttonGETRECCOMENDATIONS", "//button[@ng-click='showMatchingPreferences()']");
		homePageElements.put("inputLOCATION", "//input[@options='locationOptions']");
		homePageElements.put("optionADVERTISING", "//div[text()='Advertising']");
		homePageElements.put("optionACADEMIARESEARCH", "//div[text()='Academia / Research']");
		homePageElements.put("text404", "//div[@class='tagline']");
		homePageElements.put("cardBOOKMARKED", "//i[@class=\"star-icon campuskudos-star-9 yellow\"] ");
		homePageElements.put("overlayMESSAGEBOX", "//div[@class='compose-message-body']");

		// >>>>>>>>>>>>>>>>>>>> DISCUSSION SECTION <<<<<<<<<<<<<<<<<<<<<<<<<

		homePageElements.put("buttonBROWSEALLDISCUSSION", "//span[@ng-click=\"$root.goToPath('/discussion')\"]");
		homePageElements.put("buttonGETUPDATES", "//span[@ng-if='!question.following']");
		homePageElements.put("buttonFOLLOWING", "//span[@ng-if='question.following']");
		homePageElements.put("warning404", "//div[@class='tagline']");
		homePageElements.put("cardDISCUSSION", "//div[@class='question-card-container ck-card']");

		// >>>>>>>>>>>>>>>>>>>> RESOURCES SECTION <<<<<<<<<<<<<<<<<<<<<<<<<

		homePageElements.put("cardRESOURCES", "//div[@class='career-resource-thumb']");
		homePageElements.put("bookmarkRESOURCES", "//div[@bookmark-click='resource']");
		homePageElements.put("buttonBROWSEALLRESOURCES", "//span[@ng-click=\"$root.goToPath('/resources')\"]");
		homePageElements.put("", "");

		// >>>>>>>>>>>>>>>>>>>> EVENTS SECTION <<<<<<<<<<<<<<<<<<<<<<<<<

		homePageElements.put("buttonBROWSEALLEVENTS", "//span[@ng-click=\"$root.goToPath('/events')\"]");
		homePageElements.put("buttonREGISTER", "//span[text()='Register ']");
		homePageElements.put("modalEVENTREGISTRATION", "//h1[text()='REGISTER']");
		homePageElements.put("buttonMOREINFOEVENT", "//div[@ng-click='openEvent(ev)']/span[text()='More Info']");
		homePageElements.put("buttonNO", "//button[@ng-click='hideDialogBox()']");
		homePageElements.put("buttonBACK", "//button[@ng-click='back()']");

		// >>>>>>>>>>>>>>>>>>>> JOBS SECTION <<<<<<<<<<<<<<<<<<<<<<<<<
		homePageElements.put("buttonBROWSEALLJOBS",
				"//span[@ng-click=\"$root.getModuleSetting('opportunities', 'enableNewJobBoard') ? $root.goToPath('/job/list/all-job') : $root.goToPath('/opportunities')\"]");
		homePageElements.put("buttonMOREINFOJOBS", "//div[@ng-click='showFullPagePost(job)']");
		homePageElements.put("jobcardCOMPANY", "//div[@class='company-info']");
		
		
		// >>>>>>>>>>>>>>>>>>>> CARDS SECTION <<<<<<<<<<<<<<<<<<<<<<<<<
		homePageElements.put("buttonREVIEWREQUEST", "//span[contains(text(),'Review Request')]");
		homePageElements.put("", "");
		homePageElements.put("", "");
		homePageElements.put("", "");

		return homePageElements.get(xpath_name);
	}

	public void enterLocation(String locationData) {
		List<WebElement> existingLocation = driver.findElements(By.xpath("//i[@class='campuskudos-cross delete-loc']"));
		for (WebElement e : existingLocation) {
			e.click();
		}
		JSWaiter.waitForAngularLoad();
		input(locationData, "LOCATION");
		WebElement inputLocation = driver.findElement(By.xpath(xpathCreator("input", "LOCATION")));
		inputLocation.sendKeys(Keys.RETURN);

	}

	public void verify(String pageUrl) {
		LogUtils.info("Verifying Navigation");
		String driverURL = driver.getCurrentUrl();
		LogUtils.info("Driver URL: " + driverURL);
		LogUtils.info("Asserting the Page URL after navigation");
		Assert.assertEquals(pageUrl.toLowerCase(), driverURL.toLowerCase());
		LogUtils.info("Assertion Passed");

	}

	public void getListOfWebElementsAssert(String element_type, String element_name) {
		String xpath = xpathCreator(element_type, element_name);
		JSWaiter.waitForAngularLoad();
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		LogUtils.info("Verifying visibiliy of :" + element_type + element_name + " XPATH: " + xpath);
		GenericMethods.assertDisplay(elements.get(0));
	}

	public void navigateTo(String pageUrl) {
		JSWaiter.waitForAngularLoad();
		driver.get(pageUrl);
		JSWaiter.waitForAngularLoad();
	}

	public void getListOfWebElementsClick(String element_type, String element_name) {
		String xpath = xpathCreator(element_type, element_name);
		JSWaiter.waitForAngularLoad();
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		LogUtils.info("Clicking on 1st :" + element_type + element_name + " XPATH: " + xpath);
		WaitTool.waitForElement(driver, By.xpath(xpath), 5);
		JavascriptUtils.bringIntoView(elements.get(0));
		elements.get(0).click();
		JSWaiter.waitForAngularLoad();

	}

	static String text;

	public void getTextOf(String xpath) {
		System.out.println("Text: " + text);
		LogUtils.info("Getting text from xpath: " + xpath);
		text = driver.findElements(By.xpath(xpath)).get(0).getText();
		LogUtils.info(text);

	}

}
