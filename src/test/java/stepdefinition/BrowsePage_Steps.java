package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.BrowsePage;

public class BrowsePage_Steps {
	
	
	TestContext testContext;
	BrowsePage browsePage;
	
	public BrowsePage_Steps(TestContext context) {
		testContext=context;
		browsePage=testContext.getPageObjectManager().getBrowsePage();
	}

	@When("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on BrowsePage$")
	public void user_clicks_on_on_BrowsePage(String element_type, String element_name) {
	    browsePage.clickon(element_type, element_name);
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on BrowsePage$")
	public void appears_on_BrowsePage(String element_type, String element_name){
	    browsePage.verifyDisplayOf(element_type, element_name);
	}


	@Then("^\"([^\"]*)\" : \"([^\"]*)\" disappears on BrowsePage$")
	public void disappears_on_BrowsePage(String element_type, String element_name) throws Throwable {
	    browsePage.verifyAbsenceOf(element_type, element_name);
	}
	
	
	@When("^user applies filter (.*)$")
	public void userAppliesFilter(String filter) {
		browsePage.applyFiters(filter);
	}

}
