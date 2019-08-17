Feature: Bulk Email

Scenario: Send Bulk email using Classic Editor
	Given User is on Bulk Emails 
	When user clicks on "button" : "New Message" on BulkEmailPage
		Then "overlay" : "choose editor" appears on BulkEmailPage 
	And user clicks on "button" : "Use Classic Email Editor" on BulkEmailPage
		Then "overlay" : "choose editor" overlay disappears on BulkEmailPage
	And user clicks on "button" : "Select Recipients" on BulkEmailPage
		Then "overlay" : "Select Recipients" appears on BulkEmailPage
	And user clicks on "radio" : "Specific Individuals" on BulkEmailPage
		Then "table" : "Explore Users" appears on BulkEmailPage
	And user clicks on "checkbox" : "First User" on BulkEmailPage
	And user clicks on "button" : "Select Users" on BulkEmailPage
		Then "link" : "click to update" appears on BulkEmailPage
	And user clicks on "Select Template" dropdown > option "Blank Template" on BulkEmailPage
	And user clicks on "button" : "Confirm" on BulkEmailPage
	And user enters "Test Subject !" in "subject" field on BulkEmailPage
	And user enters internal tracking 
	And user enters email body
	And user clicks on "Send Schedule" dropdown > option "Send Now" on BulkEmailPage
		Then "modal" : "Email Confirmation" appears on BulkEmailPage
	And user clicks on "button" : "Send Now" on BulkEmailPage
		Then link appears on Bulk Messaging Page
	
	