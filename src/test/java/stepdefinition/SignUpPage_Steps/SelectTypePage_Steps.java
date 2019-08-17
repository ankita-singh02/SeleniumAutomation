package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects_signup.SELECT_TYPE;

public class SelectTypePage_Steps {

	TestContext testContext;
	SELECT_TYPE selectTypePage;

	public SelectTypePage_Steps(TestContext context) {
		testContext = context;
		selectTypePage = testContext.getPageObjectManager().getSELECT_TYPE();
	}

	@Then("^user navigates to SELECT_TYPE Page$")
	public void user_navigates_to_SELECT_TYPE_page() {

		selectTypePage.verifyOnSelectTypePage();

	}

	@Then("^user clicks on \"([^\"]*)\" on Select Type Page$")
	public void user_clicks_on_on_Select_Type_Page(String usertype) {
		selectTypePage.selectUserType(usertype);
	}

	// new

	@When("^selects (.*) on Select Type Page$")
	public void selectUserType(String usertype) {
		selectTypePage.selectUserType(usertype);
	}

}
