package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageobjects.ApprovalQueuesPage;

public class ApprovalQueues_Steps {
	
	ApprovalQueuesPage approvalPage;
	TestContext testContext;
/*	LandingPage landingPage;
	SiteAdminPage siteAdminPage;*/
	
	public ApprovalQueues_Steps(TestContext context) {
		testContext= context;
		approvalPage=testContext.getPageObjectManager().getApprovalPage();
	}
	
	@Given("^admin \"([^\"]*)\" Event$")
	public void admin_Event(String action) {
	   approvalPage.eventAction(action);
	}

}
