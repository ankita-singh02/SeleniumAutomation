package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class USER_GROUPS {
	WebDriver driver;

	public USER_GROUPS(WebDriver driver) {
		this.driver = driver;
	}

	public static final String pageTitle = "//span[text()='Select all Groups']";

	public void verifyOnUserGroupsPage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of User Groups Page");
		GenericMethods.assertDisplay(driver, "text", "User Groups", pageTitle);

	}

	public void enterGroupDetails(String details) {
		
		

		String info[] = details.split(",");
		
		System.err.println("INFO: " + info);
		clickOn("radio", "Yes");
		clickOn("button", "Select Group");
		clickOn("checkbox", "Automated Public Group");
		clickOn("button", "Save");
		clickOn("button", "Continue");
		inputValue("NUMBER GROUP QUESTION", info[0]);
		inputValue("LINK GROUP QUESTION", info[1]);
		clickOn("button", "Select");
		clickOn("checkbox", "Option X");
		clickOn("checkbox", "Option Y");
		clickOn("button", "Save");
		clickOnDropdownOption("List of Option", info[2]);
		clickOn("checkbox", "Checkbox for Group");
		inputValue("LONG TEXT GROUP QUESTION", info[3]);
		inputValue("DECIMAL NUMBER GROUP QUESTION", info[4]);
		inputValue("TEXT GROUP QUESTION", info[5]);
		clickOn("button", "xContinue");
		
		
		
	}

	public void clickOn(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on User Groups Page");
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
		LogUtils.info("Inputting data in " + inputName + " on User Groups Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);

	}

	public void clickOnDropdownOption(String dropdown, String option) {
		LogUtils.info("Clicking on dropdown " + dropdown);
		GenericMethods.click(driver, xpathCreator("dropdown", dropdown), "xpath");
		GenericMethods.click(driver, xpathCreator("option", option), "xpath");

	}

	public static String elementMap(String xpath_name) {
		HashMap<String, String> userGroupsElements = new HashMap<String, String>();
		userGroupsElements.put("radioYES", "//md-radio-button[@data-qa='groupYes-button']");
		userGroupsElements.put("buttonSELECTGROUP", "//button[@aria-label='Select']");
		userGroupsElements.put("checkboxAUTOMATEDPUBLICGROUP",
				"//span[contains(text(),' Automated Public Group for')]");
		userGroupsElements.put("buttonSAVE", "//button[@aria-label='Save']");
		userGroupsElements.put("buttonSELECTGROUP", "//button[@aria-label='Choose the Groups you want to join.']");
		userGroupsElements.put("buttonCONTINUE", "//button[@data-qa='continue-button']");
		userGroupsElements.put("inputNUMBERGROUPQUESTION", "//input[@placeholder='Number Group Question Placeholder']");
		userGroupsElements.put("inputLINKGROUPQUESTION", "//input[@placeholder='Link Question Placeholder']");
		userGroupsElements.put("buttonSELECT", "//span[text()='Select']");
		userGroupsElements.put("checkboxOPTIONX", "//span[text()=' Option X']");
		userGroupsElements.put("checkboxOPTIONY", "//span[text()=' Option Y']");
		userGroupsElements.put("dropdownLISTOFOPTION", "//select");
		userGroupsElements.put("optionOPTION2", "//option[@label='Option 2']");

		userGroupsElements.put("checkboxCHECKBOXFORGROUP", "//div[@class='md-label']");
		userGroupsElements.put("inputLONGTEXTGROUPQUESTION", "//p[@placeholder='Long text Question Placeholder']");
		userGroupsElements.put("inputDECIMALNUMBERGROUPQUESTION",
				"//input[@placeholder='Decimal Number Group Question Placeholder']");
		userGroupsElements.put("inputTEXTGROUPQUESTION", "//input[@placeholder='Text Group Question Placeholder']");
		userGroupsElements.put("buttonXCONTINUE", "//button[@aria-label='Continue']");

		return userGroupsElements.get(xpath_name);
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}

}
