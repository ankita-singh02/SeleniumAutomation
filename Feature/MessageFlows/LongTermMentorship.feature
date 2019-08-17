#Feature: Long Term Mentorship Flows: Send, Accept, Reject, Close
#
  #Scenario: Send Long Term Mentorship Request
    #Given User is on "Home" Tab ("vaishnavi+automatedstudent@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    #Then user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/profile/automateduservaishnavi782502peoplegrovecom"
    #And user clicks on "button" : "Lets Connect" on ProfilePage
    #And user clicks on "button" : "Long Term Mentorship" on ProfilePage
    #And user clears "TEXTAREA" and types "Hi! Ssup"
    #And user clicks on "button" : "Request Mentor" on ProfilePage
    #And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    #Then "tag" : "Pending" appears on InboxPage
#
  #Scenario: Accept Long Term Mentorship Request
    #Given User is on "Home" Tab ("vaishnavi+782502_@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    #And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    #And user clicks on "button" : "Accept Request" on InboxPage
    #And user enters "This is AMAZING!" in "Send Message" field on InboxPage
    #And user clicks on "button" : "Submit" on InboxPage
    #Then "sent" : "Message" appears on InboxPage
#
  #Scenario: Send Long Term Mentorship Request 2
    #Given User is on "Home" Tab ("vaishnavi+automatedstudent@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    #Then user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/profile/automateduservaishnavi476986peoplegrovecom"
    #And user clicks on "button" : "Lets Connect" on ProfilePage
    #And user clicks on "button" : "Long Term Mentorship" on ProfilePage
    #And user clears "TEXTAREA" and types "Hi! Ssup"
    #And user clicks on "button" : "Request Mentor" on ProfilePage
#
  #Scenario: Reject Long Term Mentorship Request
    #Given User is on "Home" Tab ("vaishnavi+476986_@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    #And user clicks on "button" : "Review Request" on HomePage
    #And user clicks on "button" : "Politely Decline" on InboxPage
    #Then "text" : "Decline Message" appears on InboxPage
#
  #Scenario: Check Rejection Message and Close Accepted Mentorship
    #Given User is on "Home" Tab ("vaishnavi+automatedstudent@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    #And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    #Then "text" : "Reject Message" appears on InboxPage
    #And user clicks on "tag" : "Ongoing" on InboxPage
    #Then "sent" : "Message" appears on InboxPage
    #And user clicks on "icon" : "Close Mentorship" on InboxPage
    #And user clicks on "button" : "Yes" on InboxPage
    #Then "text" : "Closed Conversation" appears on InboxPage
