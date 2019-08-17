package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects_signup.WORK_HISTORY;

public class WorkHistory_Steps {

	TestContext testContext;
	WORK_HISTORY workHistoryPage;

	public WorkHistory_Steps(TestContext context) {
		testContext = context;
		workHistoryPage = testContext.getPageObjectManager().getWORK_HISTORY();
	}

	@Then("^user navigates to WORK_HISTORY Page$")
	public void user_navigates_to_WORK_HISTORY_Page() {
		workHistoryPage.verifyOnWorkHistoryPage();
	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" field on Work History Page$")
	public void user_enters_in_field_on_Work_History_Page(String data, String element_name) {
		workHistoryPage.input(element_name, data);
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Work History Page$")
	public void user_clicks_on_on_Work_History_Page(String element_type, String element_name) {
		workHistoryPage.clickOn(element_type, element_name);
	}

	@Then("^user enters location \"([^\"]*)\" on Work History Page$")
	public void user_enters_location_on_Work_History_Page(String location) {
		workHistoryPage.enterLocation(location);
	}

	@Then("^user selects start date month: \"([^\"]*)\" year: \"([^\"]*)\"$")
	public void user_selects_start_date_month_year(String month, String year) {
		workHistoryPage.clickOnDropdownOption("startmonth", month);
		workHistoryPage.clickOnDropdownOption("startyear", year);

	}

	@Then("^user selects end date month: \"([^\"]*)\" year: \"([^\"]*)\"$")
	public void user_selects_end_date_month_year(String month, String year) {
		workHistoryPage.clickOnDropdownOption("endmonth", month);
		workHistoryPage.clickOnDropdownOption("endyear", year);
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on Work History Page$")
	public void appears_on_Work_History_Page(String element_type, String element_name) {
		workHistoryPage.verifyDisplayOf(element_type, element_name);

	}

	// new

	@When("fills work history info (.*)")
	public void appears_on_Work_History_Page(String workInfo) {
		workHistoryPage.enterWorkInfoData(workInfo);

	}
}
