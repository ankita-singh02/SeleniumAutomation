package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageobjects.HubNavBar;
import pageobjects.LandingPage;

public class HubNavBar_Steps {
	
	TestContext testContext;
	LandingPage landingPage;
	HubNavBar hubNavbar;
	public HubNavBar_Steps(TestContext context) {
		testContext=context;
		landingPage=testContext.getPageObjectManager().getLandingPage();
		hubNavbar=testContext.getPageObjectManager().getHubNavBar();
	}
	
	@Given("^User is on \"([^\"]*)\" Tab \\(\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\\)$")
	public void user_is_on_Events_Tab(String tab,String email,String password,String url){
		landingPage.requiredUserSignIn(email, password,url);
		hubNavbar.clickOnTab(tab);
	}

}
