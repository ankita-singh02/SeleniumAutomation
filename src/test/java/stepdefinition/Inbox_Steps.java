package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.InboxPage;

public class Inbox_Steps {

	TestContext testContext;
	InboxPage inboxPage;

	public Inbox_Steps(TestContext context) {
		testContext = context;
		inboxPage = testContext.getPageObjectManager().getInboxPage();
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on InboxPage$")
	public void appears_on_InboxPage(String element_type, String element_name) {
		inboxPage.verifyDisplayOf(element_type, element_name);
	}

	@Given("^user enters \"([^\"]*)\" in \"([^\"]*)\" field on InboxPage$")
	public void user_enters_in_field_on_InboxPage(String data, String inputName) {
		inboxPage.input(data, inputName);
	}

	@When("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on InboxPage$")
	public void user_clicks_on_on_InboxPage(String element_type, String element_name) {
		inboxPage.clickon(element_type, element_name);
	}

	@Given("^user selects date \"([^\"]*)\"$")
	public void user_selects_date(String arg1)  {
		inboxPage.selectDate(arg1);
	}
	@Then("^user clicks on \"([^\"]*)\" dropdown > option \"([^\"]*)\" in InboxPage$")
	public void user_clicks_on_dropdown_option_in_InboxPage(String dropdown, String option){
		inboxPage.selectDropdownOption(dropdown, option);
	}
	
	@Then("^proposed time \"([^\"]*)\" appears$")
	public void proposed_times_appears(String date_time) throws Throwable {
		inboxPage.assertProposedTime(date_time);
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" overlay disappears on InboxPage$")
	public void overlay_disappears_on_InboxPage(String element_type, String element_name) {
		inboxPage.verifyAbsenceOf(element_type, element_name);
	}
	
	@Then("^verify presence of Sent Message: \"([^\"]*)\" in thread$")
	public void verify_presence_of_Sent_Message_in_thread(String arg1) {
	    inboxPage.verifyThreadMessage(arg1);
	}

}
