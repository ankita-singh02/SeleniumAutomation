package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects_signup.USER_PROGRAMS;

public class UserPrograms_Steps {
	USER_PROGRAMS userProgramsPage;
	TestContext testContext;
	public UserPrograms_Steps(TestContext context) {
		testContext=context;
		userProgramsPage=testContext.getPageObjectManager().getUSER_PROGRAMS();
	}
	
	@Then("^user navigates to USER_PROGRAMS Page$")
	public void user_navigates_to_USER_PROGRAMS_page() {
		userProgramsPage.verifyOnUserProgramsPage();
	}
	
	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on User Programs Page$")
	public void user_clicks_on_on_User_Programs_Page(String element_type, String element_name) {
	   userProgramsPage.clickOn(element_type, element_name);
	}
	
	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" field on User Programs Page$")
	public void user_enters_in_field_on_User_Programs_Page(String data, String inputName) {
	    userProgramsPage.inputValue(inputName, data);
	}
	@Then("^user clicks on \"([^\"]*)\" dropdown > option \"([^\"]*)\" on User Programs Page$")
	public void user_clicks_on_dropdown_option_on_User_Programs_Page(String dropdown, String option) throws Throwable {
	    userProgramsPage.clickOnDropdownOption(dropdown, option);
	}
	
	@Then("^fills program details (.*)$")
	public void userFillsProgramDetails(String details) throws Throwable {
	    userProgramsPage.enterProgramDetails(details);
	}



}
