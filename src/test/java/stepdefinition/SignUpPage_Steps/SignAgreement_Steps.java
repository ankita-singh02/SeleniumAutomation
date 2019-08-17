package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects_signup.SIGN_AGREEMENT;

public class SignAgreement_Steps {
	TestContext testContext;
	SIGN_AGREEMENT signAgreementPage;

	public SignAgreement_Steps(TestContext context) {

		testContext=context;
		signAgreementPage=testContext.getPageObjectManager().getSIGN_AGREEMENT();
	}
	@Then("^user navigates to SIGN_AGREEMENT Page$")
	public void user_navigates_to_SIGN_AGREEMENT_page() {
		signAgreementPage.verifyOnSignAgreementPage();
	}

	@Then("^user checks the Agreement checkbox on Agreement Page$")
	public void user_checks_the_Agreement_checkbox_on_Agreement_Page() {
		signAgreementPage.checkAgreement();
	}

	@Then("^user draws sign on Agreement Page$")
	public void user_draws_sign_on_Agreement_Page() {
		signAgreementPage.drawSign();
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on  Agreement Page$")
	public void user_clicks_on_on_Agreement_Page(String element_type, String element_name) {
		signAgreementPage.clickOn(element_type,element_name);
	}
}
