package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.HomePage;

public class HomePage_Steps {
	TestContext testContext;
	HomePage homePage;

	public HomePage_Steps(TestContext context) {
		testContext = context;
		homePage=testContext.getPageObjectManager().getHomePage();
	}

	@When("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on HomePage$")
	public void user_clicks_on_on_HomePage(String element_type, String element_name) {
		homePage.clickon(element_type, element_name);
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on HomePage$")
	public void appears_on_HomePage(String element_type, String element_name) {
		homePage.verifyDisplayOf(element_type, element_name);
	}

	@Then("^user enters \"([^\"]*)\" in location field on HomePage$")
	public void user_enters_in_location_field_on_HomePage(String location) {
		homePage.enterLocation(location);
	}
	
	@Then("^multiple \"([^\"]*)\" : \"([^\"]*)\" appears on HomePage$")
	public void multiple_appears_on_HomePage(String element_type, String element_name) {
	   homePage.getListOfWebElementsAssert(element_type, element_name);
	}

	@Then("^Verify user navigates to \"([^\"]*)\"$")
	public void verify_user_navigates_to(String pageUrl){
		homePage.verify(pageUrl);
	}
	@When("^user clicks on first \"([^\"]*)\" : \"([^\"]*)\" on HomePage$")
	public void user_clicks_on_st_on_HomePage(String element_type, String element_name) {
	    homePage.getListOfWebElementsClick(element_type, element_name);
	}
	@Then("^user navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String pageUrl){
		homePage.navigateTo(pageUrl);
	}
	@Then("^get text for \"([^\"]*)\"$")
	public void getBookmarkedPerson(String xpath){
		homePage.getTextOf(xpath);
	}
	@Then("^verify absence of \"([^\"]*)\" : \"([^\"]*)\" on HomePage$")
	public void verify_absence_of_on_HomePage(String element_type, String element_name) {
	    homePage.verifyAbsenceOf(element_type, element_name);
	}

}
