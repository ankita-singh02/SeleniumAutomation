package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageobjects.LandingPage;
import pageobjects.SiteAdminPage;

public class SiteAdmin_Steps {
	
	TestContext testContext;
	LandingPage landingPage;
	SiteAdminPage siteAdminPage;
	
	public SiteAdmin_Steps(TestContext context) {
		testContext= context;
		landingPage=testContext.getPageObjectManager().getLandingPage();
		siteAdminPage=testContext.getPageObjectManager().getSiteAdminPage();
	}
	@Given("^admin navigates to \"([^\"]*)\" > \"([^\"]*)\" card$")
	public void user_is_on_Approve(String adminLink, String settingCard) {
		landingPage.adminSignIn("https://automation.demo.peoplegrove.com/");
		siteAdminPage.goToHubAdminCard(adminLink, settingCard);
	}
	@Given("^admin clicks on \"([^\"]*)\" : \"([^\"]*)\"$")
	public void admin_clicks_on(String element_type, String element_name) throws Throwable {
		siteAdminPage.clickon(element_type, element_name);
	}
}
