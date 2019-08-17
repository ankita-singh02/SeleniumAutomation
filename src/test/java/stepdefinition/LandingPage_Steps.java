package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.LandingPage;
import utils.JSWaiter;

public class LandingPage_Steps {

	TestContext testContext;
	LandingPage landingPage;

	public LandingPage_Steps(TestContext context) {
		testContext = context;
		landingPage = testContext.getPageObjectManager().getLandingPage();
	}

	@Given("^User is on Cluster Landing Page$")
	public void user_is_on_Cluster_Landing_Page() throws Throwable {

		landingPage.getLandingPage();
		Thread.sleep(3000);
		JSWaiter.waitForAngularLoad();
		System.out.println("LAnding Page Steps Page" + landingPage);

	}

	

	@When("^User clicks on Sign In button$")
	public void user_clicks_on_Sign_In_button() throws Throwable {
		landingPage.clickOnBtnHubSignIn();
	}

	@When("^User clicks on Email button$")
	public void user_clicks_on_Email_button() throws Throwable {
		landingPage.clickOnBtnEmail();

	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		landingPage.enterSignInCredentials("vaishnavi+1234@peoplegrove.com", "Peoplegrove@123");

	}

	@When("^User clicks on Sign In button on modal$")
	public void user_clicks_on_Sign_In_button_on_modal() throws Throwable {
		landingPage.clickOnBtnModalSignIn();

	}

	@When("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Landing Page$")
	public void user_clicks_on_on_Landing_Page(String button_type, String button_name) {
		landingPage.clickOn(button_type, button_name);
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on Landing Page$")
	public void appears_on_Landing_Page(String element_type, String element_name) {
		landingPage.verifyDisplayOf(element_type, element_name);
	}

	@Then("^user enters correct signup credentials$")
	public void user_enters_correct_signup_credentials() throws Throwable {
		landingPage.enterEmailSignupCredentials();
	}

	@Given("^user: \"([^\"]*)\", \"([^\"]*)\" logs in on \"([^\"]*)\"$")
	public void user_logs_in(String email, String password, String url) throws Throwable {
		landingPage.userLogIn(email, password, url);
	}
	
	
	//new 
	
	
	@When("^user navigates to signup page$")
	public void navigateToSignupPage() throws Throwable {
		landingPage.clickOn("Join Community");
		landingPage.clickOn("Email");
	}
	
	@When("^enters all the user details (.*)$")
	public void enters_correct_signup_credentials(String details) throws Throwable {
		landingPage.enterEmailSignupDetails(details);
		landingPage.clickOn("Create Account");


	}

}
