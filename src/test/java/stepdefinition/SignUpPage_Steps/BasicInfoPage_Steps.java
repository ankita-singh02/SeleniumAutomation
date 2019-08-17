package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects_signup.BASIC_INFO;
import utils.JSWaiter;

public class BasicInfoPage_Steps {
	TestContext testContext;
	BASIC_INFO basicInfoPage;

	public BasicInfoPage_Steps(TestContext context) {
		testContext = context;
		basicInfoPage = testContext.getPageObjectManager().getBASIC_INFO();
	}

	@Then("^user navigates to BASIC_INFO Page$")
	public void user_navigates_to_BASIC_INFO_page() {

		basicInfoPage.verifyOnBasicInfoPage();

	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" field on Basic Info Page$")
	public void user_enters_in_field_on_Basic_Info_Page(String data, String inputName) {
		basicInfoPage.enterInput(data, inputName);

	}

	@Then("^user enters location \"([^\"]*)\" on Basic Info Page$")
	public void user_enters_location_on_Basic_Info_Page(String location) {
		basicInfoPage.enterLocation(location);
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Basic Info Page$")
	public void user_clicks_on_on_Basic_Info_Page(String element_type, String element_name) throws Throwable {
		basicInfoPage.clickOn(element_type, element_name);
	}

	@Then("^user selects \"([^\"]*)\" in \"([^\"]*)\" field on Basic Info Page$")
	public void user_selects_in_field_on_Basic_Info_Page(String arg1, String arg2) {
		JSWaiter.waitForAngularLoad();
		basicInfoPage.clickOn("button", "Mumbai");
	}

	// new

	@When("^fills basic info page (.*)$")
	public void user_enters_in_field_on_Basic_Info_Page(String basicInfo) {
		basicInfoPage.basicInfoData(basicInfo);
		basicInfoPage.clickOn("Continue");

	}

}
