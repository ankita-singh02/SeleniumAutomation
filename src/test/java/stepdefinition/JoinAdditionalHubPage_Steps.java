package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects.JoinAdditionalHubPage;

public class JoinAdditionalHubPage_Steps {

	TestContext testContext;
	JoinAdditionalHubPage joinAdditionalHubPage;

	public JoinAdditionalHubPage_Steps(TestContext context) {
		testContext = context;
		joinAdditionalHubPage = testContext.getPageObjectManager().getJoinAdditionalHubPage();
	}
	
	@Then("^user navigates to JOIN_ADDITIONAL_HUBS Page$")
	public void user_navigates_to_JOIN_ADDITIONAL_HUBS_Page() {
		System.out.println("Inside verify on Join Additional Hub Page");
		joinAdditionalHubPage.verifyOnJoinAdditionalHubPage();
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Join Additional Hubs Page$")
	public void user_clicks_on_on_Join_Additional_Hubs_Page(String element_type, String element_name) {
	    joinAdditionalHubPage.clickOn(element_type, element_name);
	}
}
