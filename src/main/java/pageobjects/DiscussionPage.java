package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class DiscussionPage {
	WebDriver driver;

	public DiscussionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickon(String element_type, String element_name) {
		LogUtils.info("Clicking on " + element_name + " on Discussion");
		GenericMethods.click(driver, xpathCreator(element_type, element_name), "xpath");
		LogUtils.info("Done clicking");

	}
	public void enterInput(String data, String inputName) {

		LogUtils.info("Inputting data in " + inputName + " on Discussion Page");
		GenericMethods.input(driver, xpathCreator("input", inputName), "xpath", data);

	}

	public void verifyDisplayOf(String element_type, String element_name) {
		LogUtils.info("Verifying Presence of " + element_name+" on Discussion Page");
		JSWaiter.waitForAngularLoad();
		GenericMethods.assertDisplay(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	public void verifyAbsenceOf(String element_type, String element_name) {
		GenericMethods.assertAbsence(driver, element_type, element_name, xpathCreator(element_type, element_name));
	}

	private String xpathCreator(String element_type, String element_name) {
		System.out.println(element_type + element_name.replace(" ", "").toUpperCase());
		String xpath = elementMap(element_type + element_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH: " + xpath);
		return xpath;
	}
	
	public static String elementMap(String xpath_name) {
		HashMap<String, String> discussionPageElements = new HashMap<String, String>();

		discussionPageElements.put("inputASKQUESTIONHERE", "//textarea[@placeholder='Ask your question here...']");
		discussionPageElements.put("inputQUESTIONDESCRIPTION", "//div[@contenteditable='true']");
		discussionPageElements.put("buttonASKQUESTION", "//button[@ng-click='submit()']");
		discussionPageElements.put("buttonGOTIT", "//button[@ng-click='dialog.hide()']");
		discussionPageElements.put("tagPENDINGAPPROVAL", "//div[@ng-if='question.approved === null']");
		discussionPageElements.put("checkboxPOSTANONYMOUSLY?", "//md-checkbox[@ng-model='question.anonymous']");
		discussionPageElements.put("iconBOLD", "//button[@data-cmd='bold']");
		discussionPageElements.put("iconITALIC", "//button[@data-cmd='italic']");
		discussionPageElements.put("iconUNDERLINE", "//button[@data-cmd='underline']");
		discussionPageElements.put("iconINSERTLINK", "//button[@data-cmd='insertLink']");
		discussionPageElements.put("inputURL", "//input[@name='href']");
		discussionPageElements.put("inputURLNAME", "//input[@name='text']");
		discussionPageElements.put("buttonUPDATE", "//button[@data-cmd='linkInsert']");
		discussionPageElements.put("tabMYPOSTS", "//md-tab-item/span[text()='MY POSTS']");
		discussionPageElements.put("tagQUESTIONREJECTED", "//div[contains(text(),'QUESTION REJECTED')]");
		discussionPageElements.put("buttonOFFERYOURHELP", "//button[contains(@aria-label,'Offer Your Help')]");
		discussionPageElements.put("", "");
		discussionPageElements.put("", "");

		return discussionPageElements.get(xpath_name);
	}

	public void clickKey(String element_name,String key) {
		if (key.equalsIgnoreCase("Enter")) {
		driver.findElement(By.xpath(xpathCreator("input", element_name))).sendKeys(Keys.ENTER);}
		else {
			LogUtils.error("Invalid Keyboard Action passed in Step def");
		}
		
	}

	public void getPostLink(int rank) {
		driver.findElements(By.xpath("//div[@ng-click='showQuestionPage(question)']")).get((rank-1)).click();	
		driver.navigate().refresh();
	}

}
