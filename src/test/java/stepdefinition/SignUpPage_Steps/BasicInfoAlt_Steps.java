package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects_signup.BASIC_INFO_ALT;

public class BasicInfoAlt_Steps {
	TestContext testContext;		
	BASIC_INFO_ALT basicInfoAltPage;
	
	public BasicInfoAlt_Steps(TestContext context) {
		 testContext=context;
		 basicInfoAltPage=testContext.getPageObjectManager().getBASIC_INFO_ALT();
	}
	@Then("^user navigates to BASIC_INFO_ALT Page$")
	public void user_navigates_to_BASIC_INFO_ALT_page(){
	
		basicInfoAltPage.verifyOnBasicInfoAltPage();

	}
	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" field on Basic Info Alt Page$")
	public void user_enters_in_field_on_Basic_Info_Alt_Page(String data, String element_name){
	   basicInfoAltPage.input(element_name,data);
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Basic Info Alt Page$")
	public void user_clicks_on_on_Basic_Info_Alt_Page(String element_type, String element_name){
	    basicInfoAltPage.clickOn(element_type,element_name);
	}

}
