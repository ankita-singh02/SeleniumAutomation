package stepdefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageobjects.DiscussionPage;

public class DiscussionPage_Steps {
	TestContext testContext;
	DiscussionPage discussionPage;

	public DiscussionPage_Steps(TestContext context) {
		testContext = context;
		discussionPage = testContext.getPageObjectManager().getDiscussionPage();

	}

	@Then("^user enters \"([^\"]*)\" in \"([^\"]*)\" field on DiscussionPage$")
	public void user_enters_in_field_on_DiscussionPage(String data, String inputName) {
		discussionPage.enterInput(data, inputName);
	}

	@Then("^user clicks on \"([^\"]*)\" : \"([^\"]*)\" on DiscussionPage$")
	public void user_clicks_on_on_DiscussionPage(String element_type, String element_name){
		discussionPage.clickon(element_type, element_name);
	}

	@Then("^\"([^\"]*)\" : \"([^\"]*)\" appears on DiscussionPage$")
	public void appears_on_DiscussionPage(String element_type, String element_name) {
		discussionPage.verifyDisplayOf(element_type, element_name);
	}

	@Then("user navigates to \"([^\"]*)\" discussion Post$")
	public void navigatesTo1stPost(int rank) {
		discussionPage.getPostLink(rank);
		
	}


	@Then("^user enters questions description using all formatting options$")
	public void user_enters_questions_description_using_all_formatting_options() {
		discussionPage.clickon("icon", "BOLD");
		discussionPage.enterInput("This is in Bold", "Question Description"); //
		discussionPage.clickon("icon", "BOLD");
		discussionPage.clickKey("Question Description", "Enter");

		discussionPage.clickon("icon", "ITALIC");
		discussionPage.enterInput(" This is ITALIC", "Question Description");
		discussionPage.clickon("icon", "ITALIC");
		discussionPage.clickKey("Question Description", "Enter");

		discussionPage.clickon("icon", "UNDERLINE");
		discussionPage.enterInput("This is UNDERLINED", "Question Description");
		discussionPage.clickon("icon", "UNDERLINE");
		discussionPage.clickKey("Question Description", "Enter");

		/*
		 * discussionPage.clickon("icon", "Insert Link");
		 * discussionPage.enterInput("google", "URL Name");
		 * discussionPage.enterInput("https://www.google.com", "URL");
		 * discussionPage.clickon("button", "Update");
		 */

	}

}
