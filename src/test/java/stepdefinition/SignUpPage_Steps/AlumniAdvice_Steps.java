package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects_signup.ALUMNI_ADVICE;

public class AlumniAdvice_Steps {
	ALUMNI_ADVICE alumniAdvicePage;
	TestContext testContext;

	public AlumniAdvice_Steps(TestContext context) {
		testContext=context;
		alumniAdvicePage=testContext.getPageObjectManager().getALUMNI_ADVICE();
	}
	
	@Then("^user navigates to ALUMNI_ADVICE Page$")
	public void user_navigates_to_ALUMNI_ADVICE_page() {
		
		alumniAdvicePage.verifyOnAlumniAdvicePage();
	}
	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Alumni Advice Page$")
	public void user_clicks_on_on_Alumni_Advice_Page(String element_type, String element_name) {
	   alumniAdvicePage.clickOn( element_type,  element_name);
	}

}
