package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class USER_PROGRAMS {
	WebDriver driver;

	public USER_PROGRAMS(WebDriver driver) {
		this.driver = driver;
	}

	public static final String pageTitle = "//span[text()='FORMAL MENTORSHIP PROGRAMS']";

	public void verifyOnUserProgramsPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of User Programs Page");
		GenericMethods.assertDisplay(driver, "text", "User Programs", pageTitle);

	}

	public void enterProgramDetails(String details) {
		String info[] = details.split(",");

		System.err.println("INFO: " + info);
		clickOn("radio", "Yes");
		clickOn("button", "Select Program");
		clickOn("checkbox", "AUTOMATED ALUMNA PUBLIC PROGRAM");
		clickOn("button", "Save");
		clickOn("button", "Continue");
		clickOn("radio", "mentor");
		inputValue("AGE", info[0]);
		clickOn("checkbox", "Checkbox for Program");
		clickOnDropdownOption("Select One", info[1]);
		clickOn("button", "Select");
		clickOn("checkbox", "Cardi B");
		clickOn("checkbox", "Jet");
		clickOn("button", "Save");
		inputValue("Number Program Question", info[2]);
		inputValue("Text Program Question", info[3]);
		clickOn("button", "xContinue");

	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on User Programs Page");
		if (element_name.equalsIgnoreCase("Continue")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");

	}

	public void inputValue(String inputName, String data) {
		LogUtils.info("Inputting data in " + inputName + " on User Programs Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);

	}

	public void clickOnDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on dropdown " + dropdown);
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");
		GenericMethods.click(driver, xpathCreator("option", option), "xpath");

	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> userProgramsElements = new HashMap<String, String>();
		userProgramsElements.put("radioYES", "//md-radio-button[@data-qa='programYes-button']");
		userProgramsElements.put("buttonSELECTPROGRAM", "//button[@data-qa='select-button']");
		userProgramsElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");
		userProgramsElements.put("checkboxAUTOMATEDALUMNAPUBLICPROGRAM",
				"//span[text()=' Automated Alumna Public Program']");
		userProgramsElements.put("buttonSAVE", "//button[@ng-click='saveDialog()']");
		userProgramsElements.put("radioMENTOR", "//md-radio-button[@value='mentor']");
		userProgramsElements.put("buttonSELECT", "//button[@aria-label=\"Select\"]");
		userProgramsElements.put("inputAGE", "//input[@placeholder=\"Decimal Number\"]");
		userProgramsElements.put("checkboxCARDIB", "//span[text()=' Cardi B']");
		userProgramsElements.put("checkboxJET", "//span[text()=' Jet']");
		userProgramsElements.put("dropdownSELECTONE", "//select[@default-option='Select one for Program Placeholder']");
		userProgramsElements.put("optionYES", "//option[@label='Yes']");
		userProgramsElements.put("checkboxCHECKBOXFORPROGRAM", "//md-checkbox");
		userProgramsElements.put("inputNUMBERPROGRAMQUESTION",
				"//input[@placeholder='Number Program Question Placeholder']");
		userProgramsElements.put("inputTEXTPROGRAMQUESTION",
				"//input[@placeholder='Text Program Question Placeholder']");

		userProgramsElements.put("buttonXCONTINUE", "//span[text()='Continue']");

		return userProgramsElements.get(xpath_name);
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

}
