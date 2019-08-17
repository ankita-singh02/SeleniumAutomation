package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.BulkEmailPage;
import pageobjects.ClusterNavBar;
import pageobjects.LandingPage;
import pageobjects.SiteAdminPage;

public class BulkClassicEmail_Steps {
	String emailTitle;

	TestContext testContext;
	BulkEmailPage bulkEmailPage;
	SiteAdminPage siteAdminPage;
	LandingPage landingPage;
	ClusterNavBar clusterNavBar;

	public BulkClassicEmail_Steps(TestContext context) {

		testContext = context;
		bulkEmailPage = testContext.getPageObjectManager().getBulkEmailPage();
		siteAdminPage = testContext.getPageObjectManager().getSiteAdminPage();
		landingPage = testContext.getPageObjectManager().getLandingPage();
		clusterNavBar = testContext.getPageObjectManager().getClusterNavBar();
	}

	@Given("^User is on Bulk Emails$")
	public void user_is_on_Bulk_Emails() {

		landingPage.adminSignIn();

		siteAdminPage.goToHubAdminCard("EMAILANDNOTIFICATIONS", "BULKEMAILS");

	}

	@When("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on BulkEmailPage$")
	public void user_clicks_on_on_BulkEmailPage(String elementType, String elementName) throws Throwable {
		bulkEmailPage.clickon(elementType, elementName);
	}

	@Then("^user clicks on \"([^\"]*)\" dropdown > option \"([^\"]*)\" on BulkEmailPage$")
	public void user_clicks_on_dropdown_option(String dropdown, String option) {
		bulkEmailPage.clickOnDropdownOption(dropdown, option);
	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" field on BulkEmailPage$")
	public void user_enters(String inputName, String data) {
		bulkEmailPage.enterInput(inputName, data);
	}

	@Then("^user enters email body$")
	public void user_enters_email_body() {
		bulkEmailPage.enterEmailBody();
	}

	@Then("^user enters internal tracking$")
	public void user_enters_internal_tracking() {
		emailTitle = bulkEmailPage.enterInternalTracking();

	}

	@Then("^link appears on Bulk Messaging Page$")
	public void email_link_appears_on_Bulk_Messaging_Page() {
		bulkEmailPage.verifyDisplayOfEmailLink();

	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on BulkEmailPage$")
	public void appears_on_BulkEmailPage(String element_type, String element_name) {
		bulkEmailPage.verifyDisplayOf(element_type, element_name);
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" overlay disappears on BulkEmailPage$")
	public void overlay_disappears_on_BulkEmailPage(String element_type, String element_name) throws Throwable {
		bulkEmailPage.verifyAbsenceOf(element_type, element_name);
	}

}
