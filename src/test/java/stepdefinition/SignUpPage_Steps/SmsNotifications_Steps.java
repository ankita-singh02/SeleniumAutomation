package stepdefinition.SignUpPage_Steps;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects_signup.SMS_NOTIFICATIONS;

public class SmsNotifications_Steps {
	TestContext testContext;
	SMS_NOTIFICATIONS smsNotificationsPage;

	public SmsNotifications_Steps(TestContext context) {
		testContext=context;
		smsNotificationsPage= testContext.getPageObjectManager().getSMS_NOTIFICATIONS();
	}

	@Then("^user navigates to SMS_NOTIFICATIONS Page$")
	public void user_navigates_to_SMS_NOTIFICATIONS_page() {
		smsNotificationsPage.verifyOnSmsNotificationsPage();
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on Sms Notifications Page$")
	public void user_clicks_on_on_Sms_Notifications_Page(String element_type, String element_name) {
		smsNotificationsPage.clickOn( element_type,  element_name);
	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" on Sms Notifications Page$")
	public void user_enters_in_on_Sms_Notifications_Page(String data, String inputName){
		smsNotificationsPage.input(inputName,data);
	}

}
