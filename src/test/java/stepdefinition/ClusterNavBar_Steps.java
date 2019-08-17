package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ClusterNavBar;

public class ClusterNavBar_Steps {

	ClusterNavBar clusterNavBar;
	TestContext testContext;

	public ClusterNavBar_Steps(TestContext context) {
		testContext = context;
		clusterNavBar = testContext.getPageObjectManager().getClusterNavBar();
	}

	@When("^clicks on SignOut$")
	public void clicks_on_SignOut() {
		clusterNavBar.clickOnProfileDropdownOption("Sign Out");
	}

	@Then("^user lands on Home Page$")
	public void user_lands_on_Home_Page() {
		clusterNavBar.isOnHomePage();
	}
	@Given("^User clicks on Profile dropdown> \"([^\"]*)\"$")
	public void user_is_on_My(String option) {
	    clusterNavBar.goToMy(option);
	}
	
	@Given("^user closes the browser$")
	public void user_closes_the_browser() {
		clusterNavBar.driverClose();
	}
	

}
