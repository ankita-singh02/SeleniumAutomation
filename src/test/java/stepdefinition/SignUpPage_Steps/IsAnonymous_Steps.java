package stepdefinition.SignUpPage_Steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import manager.PageObjectManager;
import manager.WebDriverManager;
import pageobjects_signup.IS_ANONYMOUS;

public class IsAnonymous_Steps {
	WebDriver driver;
	PageObjectManager pageObjectManager;	
	WebDriverManager webDriverManager;
	IS_ANONYMOUS isAnonPage;
	
	@Then("^user navigates to IS_ANONYMOUS Page$")
	public void user_navigates_to_IS_ANONYMOUS_page()  {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		isAnonPage=pageObjectManager.getIS_ANONYMOUS();
		
		isAnonPage.verifyOnIsAnonPage();	}

}
