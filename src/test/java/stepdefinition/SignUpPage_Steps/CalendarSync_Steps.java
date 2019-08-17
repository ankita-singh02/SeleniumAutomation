package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects_signup.CALENDAR_SYNC;

public class CalendarSync_Steps {

	CALENDAR_SYNC calendarSyncPage;
	TestContext testContext;
	public CalendarSync_Steps(TestContext context) {
		testContext=context;
		calendarSyncPage=testContext.getPageObjectManager().getCALENDAR_SYNC();
	}

	@Then("^user navigates to CALENDAR_SYNC Page$")
	public void user_navigates_to_CALENDAR_SYNC_page() {

		calendarSyncPage.verifyOnCalendarSyncPage();
	}

	@Then("^user clicks on \"([^\"]*)\" dropdown > option \"([^\"]*)\" on Calendar Sync Page$")
	public void user_clicks_on_dropdown_option_on_Calendar_Sync_Page(String dropdown, String option) {
		calendarSyncPage.clickOnDropdownOption( dropdown,  option);
	}

	@Then("^user selects weekdays as available$")
	public void user_selects_weekdays_as_available(){
		calendarSyncPage.selectWeekdays();
	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" on Calendar Sync Page$")
	public void user_enters_in_on_Calendar_Sync_Page(String data, String inputName) {
		calendarSyncPage.clickAndinputValue( inputName, data);
	}
	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Calendar Sync Page$")
	public void user_clicks_on_on_Calendar_Sync_Page(String element_type, String element_name) {
	    calendarSyncPage.clickOn( element_type,  element_name);
	}
}
