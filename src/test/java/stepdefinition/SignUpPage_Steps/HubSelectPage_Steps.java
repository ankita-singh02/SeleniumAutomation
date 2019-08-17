package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects_signup.HUB_SELECT;

public class HubSelectPage_Steps {

	HUB_SELECT hubSelectPage;
	TestContext testContext;

	public HubSelectPage_Steps(TestContext context) {
		testContext = context;
		hubSelectPage = testContext.getPageObjectManager().getHUB_SELECT();
	}

	@Then("^user navigates to HUB_SELECT Page$")
	public void user_navigates_to_HUB_SELECT_page() {
		System.out.println("Inside verify on hub select");
		hubSelectPage.verifyOnHubSelectPage();
	}

	@Then("^user clicks on \"([^\"]*)\" on Hub Select Page$")
	public void user_clicks_on_on_Hub_Select_Page(String arg1) {

		hubSelectPage.selectAutomationHub();
	}

	// new

	@When("^selects Hub on Hub Select Page$")
	public void selectHub() {

		hubSelectPage.selectAutomationHub();
	}

}
