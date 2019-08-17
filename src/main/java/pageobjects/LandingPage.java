package pageobjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		System.out.println("Landing page drivers: " + this.driver);
		System.out.println(driver);
	}

	public void getLandingPage() {
		GenericMethods.setUpLog4j();

		LogUtils.info("Navigating to Cluster Landing Page");
		String URL = "https://automation.demo.peoplegrove.com/";

		LogUtils.info("Navigating to: " + URL);
		GenericMethods.navigate(driver, URL);
		JSWaiter.waitForAngularLoad();

	}

	public void getLandingPage(String URL) {
		GenericMethods.setUpLog4j();

		LogUtils.info("Navigating to Cluster Landing Page");
		LogUtils.info("Navigating to: " + URL);
		GenericMethods.navigate(driver, URL);
		JSWaiter.waitForAngularLoad();

	}

	public void clickOnBtnHubSignIn() {

		LogUtils.info("Clicking On Hub Sign In Button");
		GenericMethods.click(driver, LandingPage_Elements.btn_hub_SIGNIN, "xpath");

	}

	public void clickOnBtnEmail() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LogUtils.info("Clicking on Email Button");
		GenericMethods.click(driver, LandingPage_Elements.btn_EMAIL, "xpath");

	}

	public void enterSignInCredentials(String email, String password) {

		LogUtils.info("Entering correct Email ID");
		GenericMethods.input(driver, LandingPage_Elements.input_EMAIL, LandingPage_Elements.XPATH, email);
		LogUtils.info("Entering correct Password");
		GenericMethods.input(driver, LandingPage_Elements.input_PASSWORD, LandingPage_Elements.XPATH, password);

	}

	public void clickOnBtnModalSignIn() {

		LogUtils.info("Clicking on Modal Sign In Button");
		GenericMethods.click(driver, LandingPage_Elements.btn_modalSIGNIN, LandingPage_Elements.XPATH);
		JSWaiter.waitForAngularLoad();

	}

	public void isSignInButtonVisible() {

		LogUtils.info("Checking for Sign In Button on Nav Bar");
		Boolean visible = GenericMethods.isElementVisible(driver, LandingPage_Elements.btn_hub_SIGNIN);
		Assert.assertTrue(visible);
	}

	public void adminSignIn(String URL) {
		getLandingPage(URL);
		clickOnBtnHubSignIn();
		clickOnBtnEmail();
		enterSignInCredentials("vaishnavi+ultimateadmin@peoplegrove.com", "Peoplegrove@123");
		clickOnBtnModalSignIn();

	}

	public void clickOn(String button_type, String button_name) {
		String xpath = xpathCreator(button_type, button_name);
		GenericMethods.clickOn(button_type, button_name, driver, xpath);

	}
	
	public void clickOn(String buttonName) {
		String xpath = xpathCreator("button", buttonName);
		GenericMethods.clickOn(driver, xpath);

	}

	private String xpathCreator(String button_type, String button_name) {
		System.out.println(button_type + button_name.replace(" ", "").toUpperCase());
		String xpath = LandingPage_Elements.elementMap(button_type + button_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH:" + xpath);
		return xpath;
	}

	public void verifyDisplayOf(String element_type, String element_name) {
		LogUtils.info("Verifying Presence of " + element_name + " on Landing Page");
		JSWaiter.waitForAngularLoad();
		GenericMethods.assertDisplay(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	public void enterEmailSignupCredentials() {

		String email = createUniqueTestEmailID();
		LogUtils.info("Entering first Name");
		GenericMethods.input(driver, LandingPage_Elements.input_FIRSTNAME, "xpath", "Automated_User");
		LogUtils.info("Entering last Name");
		GenericMethods.input(driver, LandingPage_Elements.input_LASTNAME, "xpath", email);
		LogUtils.info("Entering Email ID");
		GenericMethods.input(driver, LandingPage_Elements.input_EMAIL, "xpath", email);
		LogUtils.info("Entering Password");
		GenericMethods.input(driver, LandingPage_Elements.input_PASSWORD, "xpath", "Peoplegrove@123");

	}

	public void enterEmailSignupDetails(String details) {

		String email = createUniqueTestEmailID();
		String[] signupDetails = details.split(",");
		GenericMethods.input(driver, LandingPage_Elements.input_FIRSTNAME, "xpath", signupDetails[0]);
		LogUtils.info("Entering last Name");
		GenericMethods.input(driver, LandingPage_Elements.input_LASTNAME, "xpath", signupDetails[1]);
		LogUtils.info("Entering Email ID");
		GenericMethods.input(driver, LandingPage_Elements.input_EMAIL, "xpath", email);
		LogUtils.info("Entering Password");
		GenericMethods.input(driver, LandingPage_Elements.input_PASSWORD, "xpath", signupDetails[2]);

	}

	public String createUniqueTestEmailID() {

		Random rand = new Random();
		String email = "Ankita+" + rand.nextInt(1000000) + "_@peoplegrove.com";
		return email;
	}

	public void requiredUserSignIn(String email, String password, String url) {
		getLandingPage(url);
		clickOnBtnHubSignIn();
		clickOnBtnEmail();
		enterSignInCredentials(email, password);
		clickOnBtnModalSignIn();
	}

	public void adminSignIn() {
		getLandingPage();
		clickOnBtnHubSignIn();
		clickOnBtnEmail();
		enterSignInCredentials("vaishnavi+ultimateadmin@peoplegrove.com", "Peoplegrove@123");
		clickOnBtnModalSignIn();

	}

	public void userLogIn(String email, String password, String url) {
		getLandingPage(url);
		clickOnBtnHubSignIn();
		clickOnBtnEmail();
		enterSignInCredentials(email, password);
		clickOnBtnModalSignIn();

	}

}
