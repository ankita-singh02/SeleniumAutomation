Feature: Flash Mentorship Flows(Calendar Not Synced)

  Scenario: Send Flash Mentorship Request (Calendar Not Synced)
    Given User is on "Home" Tab ("vaishnavi+123cc4@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    Then user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/profile/automateduservaishnavi724048peoplegrovecom"
    And user clicks on "button" : "Lets Connect" on ProfilePage
    And user clicks on "button" : "Flash Mentorship" on ProfilePage
    And user clicks on "checkbox" : "Resume" on ProfilePage
    And user clicks on "button" : "Next" on ProfilePage
    And user clicks on "radio" : "Online Video Call" on ProfilePage
    And user clicks on "duration" dropdown > option "1 hour" in ProfilePage
    And user clicks on "button" : "Next" on ProfilePage
    And user clicks on "button" : "Confirm & Continue" on ProfilePage
    And user clears "TEXTAREA" and types "Hi! Ssup"
    And user clicks on "button" : "Send" on ProfilePage
    And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    Then "tag" : "Pending Meeting" appears on InboxPage
    Then "alert" : "Pending Meeting" appears on InboxPage

  Scenario: Mentee Proposes Additional Time (Calendar Not Synced)
    Given User is on "Home" Tab ("vaishnavi+123cc4@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    And user clicks on "button" : "Review And Schedule" on InboxPage
    And user clicks on "button" : "Propose Other Times" on InboxPage
    And user clicks on "icon" : "Date" on InboxPage
    And user selects date "January 2 2019"
    And user clicks on "Time" dropdown > option "2:00PM" in InboxPage
    And user clicks on "button" : "Send New Times" on InboxPage
    And user clicks on "button" : "Review And Schedule" on InboxPage
    Then proposed time "January 2, 2019 2:00 pm - 2:30 pm" appears

  Scenario: Mentor Declines Request (Calendar Not Synced)
    Given User is on "Home" Tab ("vaishnavi+724048_@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    And user clicks on "button" : "Review And Schedule" on InboxPage
    #Then time in proper timezone appears that was proposed in above scenario
    And user clicks on "link" : "Click Here" on InboxPage
    And user clears "TEXTAREA" and types "Sorry to Cancel the meeting"
    And user clicks on "button" : "Cancel Meeting" on InboxPage
    Then "text" : "Meeting Declined" appears on InboxPage
    And user clicks on "button" : "Close" on InboxPage
    Then "alert" : "Pending Meeting" overlay disappears on InboxPage

  Scenario: Mentee Proposes new meeting from Inbox with Timezone Change(Calendar Not Synced)
    Given User is on "Home" Tab ("vaishnavi+123cc4@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    And user clicks on "icon" : "Calendar" on InboxPage
    And user clicks on "radio" : "Phone Call" on InboxPage
    And user enters "123456789" in "Phone Number" field on InboxPage
    And user clicks on "link" : "change" on InboxPage
    And user clicks on "dropdown" : "Timezone" on InboxPage
    And user enters "Kolkata" in "Timezone" field on InboxPage
    And user clicks on "option" : "Kolkata" on InboxPage
    And user clicks on "icon" : "1stcross" on InboxPage
    And user clears "date" and types "01-Apr-2019"
    And user clicks on "Time" dropdown > option "3:00PM" in InboxPage
    And user clicks on "button" : "Send Request" on InboxPage
    And user clicks on "button" : "Review And Schedule" on InboxPage
    Then proposed time "Monday, April 1, 2019 2:30 am - 3:00 am" appears

  Scenario: Mentor Accepts Request (Calendar Not Synced)
    Given User is on "Home" Tab ("vaishnavi+724048_@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    And user clicks on "button" : "Review And Schedule" on InboxPage
    And user clicks on "radio" : "Time" on InboxPage
    And user enters "The meeting is on" in "Textarea" field on InboxPage
    And user clicks on "button" : "Schedule Meeting" on InboxPage
    Then "text" : "Phone Call" appears on InboxPage
    Then "text" : "Phone Number" appears on InboxPage
    And user clicks on "button" : "Return To Inbox" on InboxPage
    Then "alert" : "Upcoming Meeting" appears on InboxPage

  Scenario: Mentor Cancels Scheduled Request (Calendar Not Synced)
    Given User is on "Home" Tab ("vaishnavi+724048_@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/inbox"
    And user clicks on "button" : "Cancel/Reschedule" on InboxPage
    And user clicks on "button" : "Cancel" on InboxPage
    And user enters "Sorry Had to Cancel this scheduled meeting" in "Textarea" field on InboxPage
    And user clicks on "button" : "Confirm Cancellation" on InboxPage
    And user clicks on "icon" : "Close" on InboxPage
    And user clicks on "icon" : "Close Mentorship" on InboxPage
    
  Scenario: Mentee checks presence of all sent messages in previous scenario and closes the Mentorship
    Given User is on "Home" Tab ("vaishnavi+123cc4@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/inbox"
		Then verify presence of Sent Message: "Hi! Ssup" in thread
		Then verify presence of Sent Message: "Sorry to Cancel the meeting" in thread
		Then verify presence of Sent Message: "The meeting is on" in thread
		Then verify presence of Sent Message: "Sorry Had to Cancel" in thread
    And user clicks on "icon" : "Close Mentorship" on InboxPage  
    And user clicks on "button" : "Yes" on InboxPage 
     
    