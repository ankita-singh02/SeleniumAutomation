package pageobjects;

import java.util.HashMap;

public class LandingPage_Elements {
	public static final String XPATH="xpath";
	
	/* >>>>>>>>>>>>>>>>>>>>>>> Sign In Flow Elements <<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
	//public static final String btn_hub_SIGNIN="//div[@class='hub-header']/div/div/a[contains(text(),'Sign in')]";
	public static final String btn_hub_SIGNIN="//div[@class='hub-header']/div/div[2]/button[contains(text(),'Sign in')]";
	public static final String btn_LINKEDIN="//span[contains(text(),'LinkedIn')]";
	public static final String btn_FACEBOOK="//span[contains(text(),'Facebook')]";
	public static final String btn_EMAIL="//button[@aria-label='Sign in with Email']/span";
	public static final String btn_modalSIGNIN="//span[contains(text(),'Sign in')]";
	public static final String btn_SIGNUPHERE="//a[contains(text(),'Sign up here')]";
	public static final String btn_FORGOTPASSWORD="//a[contains(text(),'Forgot password')]";
	
	public static final String input_EMAIL="//input[@type='email']";
	public static final String input_PASSWORD="//input[@type='password']";
	
	/* >>>>>>>>>>>>>>>>>>>>>>> Sign Up Flow Elements <<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
	public static final String btn_CREATEACCOUNT="//span[contains(text(),'Create Account')]";
	//Sign Up method button same as Sign in
	
	//Sign Up inputs email,password same as Sign in
	public static final String input_FIRSTNAME="//input[@name='firstName']";
	public static final String input_LASTNAME="//input[@name='lastName']";
	/*public static final String ="";
	public static final String ="";
	public static final String ="";*/
	public static String elementMap(String xpath_name) {
		HashMap<String, String > landingPageElements= new HashMap<String, String >();
		
		landingPageElements.put("buttonJOINCOMMUNITY", "//div[text()='JOIN OUR COMMUNITY']");
		landingPageElements.put("buttonCREATEACCOUNT", "//span[contains(text(),'Create Account')]");
		landingPageElements.put("buttonEMAIL", "//span[contains(text(),'Email')]");
		landingPageElements.put("modalAUTH", "//span[text()='Please select a login method below.']");
		landingPageElements.put("modalEMAILSIGNUP", "//p[text()='Welcome to Ultimate Mentoring! ']");
		landingPageElements.put("buttonSIGNIN", "//button[@type='submit']");



		return landingPageElements.get(xpath_name);
	}
	

}
