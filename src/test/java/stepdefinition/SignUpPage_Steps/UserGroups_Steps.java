package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects_signup.USER_GROUPS;

public class UserGroups_Steps {

	TestContext testContext;
	USER_GROUPS userGroupsPage;

	public UserGroups_Steps(TestContext context) {
		testContext = context;
		userGroupsPage = testContext.getPageObjectManager().getUSER_GROUPS();
	}

	@Then("^user navigates to USER_GROUPS Page$")
	public void user_navigates_to_USER_GROUPS_page() {
		userGroupsPage.verifyOnUserGroupsPage();

	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on User Groups Page$")
	public void user_clicks_on_on_User_Groups_Page(String element_type, String element_name) {
		userGroupsPage.clickOn(element_type, element_name);
	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" field on User Groups Page$")
	public void user_enters_in_field_on_User_Groups_Page(String data, String inputName) {
		userGroupsPage.inputValue(inputName, data);
	}

	@Then("^user clicks on \"([^\"]*)\" dropdown > option \"([^\"]*)\" on User Groups Page$")
	public void user_clicks_on_dropdown_option_on_User_Groups_Page(String dropdown, String option) throws Throwable {
		userGroupsPage.clickOnDropdownOption(dropdown, option);
	}

	// new
	@When("^fills groups details (.*)$")
	public void userEntersGroupDetails(String details) {
		userGroupsPage.enterGroupDetails(details);

	}
}
