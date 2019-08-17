package utils;

import org.openqa.selenium.WebDriver;

import pageobjects.Map_Elements;

public class GenericPage {
	WebDriver driver;
	public GenericPage(WebDriver driver) {
		this.driver=driver;
	}

	
	public void clickOn(String button_name, String button_type, String page_key) {
		System.out.println(button_type+button_name.replace(" ", "").toUpperCase());
		
		String xpath= Map_Elements.elementMap(button_type+button_name.replace(" ", "").toUpperCase(), page_key);
		System.out.println("XPATH:"+xpath);
		GenericMethods.clickOn(button_type, button_name, driver,xpath);
		
	}

	public void verifyDisplayOf(String element_type, String element_name, String page_key) {
		String xpath=Map_Elements.elementMap(element_type+element_name.replace(" ", "").toUpperCase(), page_key);
		JSWaiter.waitForAngularLoad();
		 GenericMethods.assertDisplay(driver, element_type, element_name, xpath );
		
	}

}
