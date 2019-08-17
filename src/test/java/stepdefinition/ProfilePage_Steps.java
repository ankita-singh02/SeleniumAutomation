package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ProfilePage;

public class ProfilePage_Steps {
	
	
	TestContext testContext;
	ProfilePage profilePage;

	public ProfilePage_Steps(TestContext context) {
		testContext = context;
		profilePage=testContext.getPageObjectManager().getProfilePage();
	}
	
	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on ProfilePage$")
	public void appears_on_HomePage(String element_type, String element_name) {
		profilePage.verifyDisplayOf(element_type, element_name);
	}
	@When("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on ProfilePage$")
	public void user_clicks_on_on_HomePage(String element_type, String element_name) {
		profilePage.clickon(element_type, element_name);
	}
	
	@Then("^user clears \"([^\"]*)\" and types \"([^\"]*)\"$")
	public void user_clears_placeholder_and_types( String element_name, String data) {
	    profilePage.clearText(element_name);
	    profilePage.input(data, element_name);
	    
	}

	@Then("^user clicks on \"([^\"]*)\" dropdown > option \"([^\"]*)\" in ProfilePage$")
	public void user_clicks_on_dropdown_option_in_profilePage(String dropdown, String option) {
		profilePage.selectDropdownOption(dropdown, option);
	}
}
