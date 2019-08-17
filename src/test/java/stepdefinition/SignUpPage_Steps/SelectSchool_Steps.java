package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects_signup.SELECT_SCHOOL;

public class SelectSchool_Steps {
	TestContext testContext;
	SELECT_SCHOOL selectSchoolPage;

	public SelectSchool_Steps(TestContext context) {
		testContext = context;
		selectSchoolPage = testContext.getPageObjectManager().getSELECT_SCHOOL();
	}

	@Then("^user navigates to SELECT_SCHOOL Page$")
	public void user_navigates_to_SELECT_SCHOOL_page() {

		selectSchoolPage.verifyOnSelectSchoolPage();
	}

	@Then("^user enters School on Select School Page$")
	public void user_enters_School_on_Select_School_Page() {
		selectSchoolPage.selectSchool("CampusKudos");

	}

	@Then("^user enters and selects \"([^\"]*)\" in \"([^\"]*)\" field on Select School Page$")
	public void user_enters_in_field_on_Select_School_Page(String data, String element_name) throws Throwable {
		selectSchoolPage.inputAndSelect(element_name, data);
	}

	@Then("^user clicks on \"([^\"]*)\" dropdown > option \"([^\"]*)\" on Select School Page$")
	public void user_clicks_on_dropdown_option_on_Select_School_Page(String dropdown, String option) throws Throwable {
		selectSchoolPage.clickOnDropdownOption(dropdown, option);
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Select School Page$")
	public void user_clicks_on_on_Select_School_Page(String element_type, String element_name) throws Throwable {
		selectSchoolPage.clickOn(element_type, element_name);
	}

	// new
	@When("^fills school info (.*)$")
	public void userFillsSchoolInfo(String info) {
		selectSchoolPage.schoolDetails(info);

	}

}
