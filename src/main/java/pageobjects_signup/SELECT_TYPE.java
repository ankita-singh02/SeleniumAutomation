package pageobjects_signup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import utils.GenericMethods;
import utils.JSWaiter;
import utils.LogUtils;

public class SELECT_TYPE {
	WebDriver driver;
	
	public SELECT_TYPE(WebDriver driver) {
		this.driver=driver;
	}
	public static final String btnSTUDENT = "//h3[contains(text(),'Student /')]";
	public static final String btnPROSPECTIVESTUDENT = "//h3[contains(text(),'Prospective Student')]";
	public static final String btnALUMNA = "//h3[contains(text(),'Alum')]";
	public static final String btnFACULTY ="//h3[contains(text(),'Faculty')]";
	public static final String btnFRIENDOFUNIVERSITY ="//h3[contains(text(),'Friend')]";
	public static final String pageTitle="//span[contains(text(),' joining as a...')]";

	public static final String Xpath = "xpath";

	public void verifyOnSelectTypePage() {
		JSWaiter.waitForAngularLoad();
		LogUtils.info("Verifying title of Select Usertype Page");
		//GenericMethods.assertDisplay(driver, "text", "Select User Type Title",pageTitle );
	}

	public void selectUserType(String usertype) {
		LogUtils.info("Selecting usertype: "+usertype);
		String xpath=xpathCreator("text", usertype);
		GenericMethods.clickOn("text", usertype	, driver, xpath);
		JSWaiter.waitForAngularLoad();
		
	}
	private String xpathCreator(String button_type, String button_name) {
		System.out.println(button_type+button_name.replace(" ", "").toUpperCase());
		String xpath= elementMap(button_type+button_name.replace(" ", "").toUpperCase());
		System.out.println("XPATH:"+xpath);
		return xpath;
	}
	
	public static String elementMap(String xpath_name) {
		HashMap<String, String > selectTypePageElements= new HashMap<String, String >();
		selectTypePageElements.put("textALUMNA", "//h3[text()='Alum/na']");
		selectTypePageElements.put("textSTUDENT", "//h3[text()='Student / Recent Grad']");
		selectTypePageElements.put("textPROSPECTIVESTUDENT", "//h3[text()='Prospective Student']");
		
		
		return selectTypePageElements.get(xpath_name);
	}

}
