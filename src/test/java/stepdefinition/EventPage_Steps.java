package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.EventsPage;
import pageobjects.HubNavBar;
import pageobjects.LandingPage;

public class EventPage_Steps {
	TestContext testContext;
	EventsPage eventpage;
	LandingPage landingPage;
	HubNavBar hubNavbar;

	public EventPage_Steps(TestContext context) {
		testContext = context;
		eventpage = testContext.getPageObjectManager().getEventPage();
		landingPage = testContext.getPageObjectManager().getLandingPage();
		hubNavbar = testContext.getPageObjectManager().getHubNavBar();
	}

	@When("^User navigates to Event Url$")
	public void user_navigates_to_event_url() {
		eventpage.goToEventUrl();
	}

	@When("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on EventPage$")
	public void user_clicks_on_EventPage(String element_type, String element_name) {
		eventpage.clickon(element_type, element_name);
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on EventPage$")
	public void appears_on_EventPage(String element_type, String element_name) {
		eventpage.verifyDisplayOf(element_type, element_name);
	}
	
	@Then("^\"([^\"]*)\" : \"([^\"]*)\" matches on EventPage to \"([^\"]*)\"$")
	public void matches_on_EventPage(String element_type, String element_name,String element_value) {
		eventpage.verifyInfo(element_type, element_name,element_value);
	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" field in EventPage$")
	public void user_enters_in_field_in_EventPage(String input, String field) {
		eventpage.input(input, field);
	}

	@Then("^user clicks on \"([^\"]*)\" dropdown > option \"([^\"]*)\" in EventPage$")
	public void user_clicks_on_dropdown_option_in_EventPage(String dropdown, String option) throws Throwable {
		eventpage.selectDropdownOption(dropdown, option);
	}


	@Then("^user enters \"([^\"]*)\" in Event Description on EventPage$")
	public void user_enters_in_Event_Description_on_EventPage(String arg1) {
		eventpage.enterDescription(arg1);
	}

	@Then("^saves the Event URL for reference$")
	public void saves_the_Event_URL_for_reference() throws Throwable {
		eventpage.copyEventURL();
	}


}
