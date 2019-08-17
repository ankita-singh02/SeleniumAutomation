package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects_signup.CUSTOM_FIELDS;

public class CustomFields_Steps {
	TestContext testContext;
	CUSTOM_FIELDS customFieldsPage;

	public CustomFields_Steps(TestContext context) {
		testContext = context;
		customFieldsPage = testContext.getPageObjectManager().getCUSTOM_FIELDS();
	}

	@Then("^user navigates to CUSTOM_FIELDS Page$")
	public void user_navigates_to_CUSTOM_FIELDS_page() {
		customFieldsPage.verifyOnCustomFieldsPage();
	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" on Custom fields Page$")
	public void user_enters_in_on_Custom_fields_Page(String data, String inputName) {
		customFieldsPage.enterInput(inputName, data);
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Custom fields Page$")
	public void user_clicks_on_on_Custom_fields_Page(String elementType, String elementName) {
		customFieldsPage.clickOn(elementType, elementName);
	}

	@Then("^user selects Custom Date Field on Custom Field Page$")
	public void user_selects_Custom_Date_Field_on_Custom_Field_Page() {
		customFieldsPage.selectDate();
	}

	@Then("^user enters location \"([^\"]*)\" on Custom fields Page$")
	public void user_enters_location_on_Custom_fields_Page(String location) {
		customFieldsPage.inputLocation(location);
	}

}
