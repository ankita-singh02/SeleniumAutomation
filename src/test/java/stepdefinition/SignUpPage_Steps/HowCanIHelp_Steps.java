package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects_signup.HOW_CAN_I_HELP;

public class HowCanIHelp_Steps {

	TestContext testContext;
	HOW_CAN_I_HELP howCanIHelpPage;

	public HowCanIHelp_Steps(TestContext context) {

		testContext = context;
		howCanIHelpPage = testContext.getPageObjectManager().getHOW_CAN_I_HELP();
	}

	@Then("^user navigates to HOW_CAN_I_HELP Page$")
	public void user_navigates_to_HOW_CAN_I_HELP_page() {
		howCanIHelpPage.verifyOnHowCanIHelp();
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on How Can I Help Page$")
	public void user_clicks_on_on_How_Can_I_Help_Page(String element_type, String element_name) {
		howCanIHelpPage.clickOn(element_type, element_name);
	}

	// new
	@When("^enters details on how can I help page (.*)$")
	public void howCanIHelpDetails(String details) {
		
		howCanIHelpPage.enterHowCanIHelpDetails(details);
	}

}
