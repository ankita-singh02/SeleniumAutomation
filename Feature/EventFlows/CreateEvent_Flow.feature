Feature: Create an Event Flow

  Scenario: Create an Event on Events Tab
    Given User is on "Event" Tab ("vaishnavi+eventcreator@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on "button" : "Create Event" on EventPage
    Then "modal" : "Event Type" appears on EventPage
    And user clicks on "Event Type" dropdown > option "TEST" in EventPage
    And user clicks on "button" : "Create Event on Modal" on EventPage
    Then "form" : "Create Event" appears on EventPage
    And user enters "Headline for the Event" in "HEADLINE" field in EventPage
    And user enters "This is AMAZING!" in Event Description on EventPage
    And user enters "19-Sep-2019" in "Start date" field in EventPage
    And user clicks on "Start Time" dropdown > option "9:00 pm" in EventPage
    And user enters "The Dope Place" in "address" field in EventPage
    And user enters "San Francisco CA, USA" in "location" field in EventPage
    And user clicks on "toggle" : "DO NOT SEND REMINDER EMAIL" on EventPage
    And user clicks on "radio" : "Show to Everyone" on EventPage
    And user clicks on "checkbox" : "SELECTALL" on EventPage
    And user clicks on "toggle" : "Unlimited" on EventPage
    And user clicks on "button" : "SUBMIT" on EventPage
    Then "modal" : "Event Created" appears on EventPage
    And saves the Event URL for reference
    And user clicks on "button" : "OK" on EventPage
    Then "tag" : "Approval Pending" appears on EventPage

  Scenario: Verify Details on Event URL
    Given User is on "Event" Tab ("vaishnavi+eventcreator@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When User navigates to Event Url
    Then "info" : "HEADLINE" matches on EventPage to "Headline for the Event"
    Then "info" : "Event Type" matches on EventPage to "Test"
    Then "info" : "Start Date" matches on EventPage to "September 19, 2019"
    Then "info" : "Event Time" matches on EventPage to "9:00 pm - 10:00 pm "
    Then "info" : "Location" matches on EventPage to "San Francisco"

  #Then "info" : "Event Description" matches on EventPage to ""
  #Then "info" : "Host Name" matches on EventPage to ""
  #Then "info" : "Host Headline" matches on EventPage to ""
  #Then "info" : "Address" matches on EventPage to ""
 #
  #Scenario: Admin Rejects Created Event and User sees Rejected Tag
    #Given admin navigates to "Approval Queues" > "Approve Events" card
    #And admin "Rejects" Event
#
  #Scenario: User sees reject tag and deletes rejected event
    #Given user: "vaishnavi+eventcreator@peoplegrove.com", "Peoplegrove@123" logs in on "https://engtesting.dev.pg-test.com/"
    #And User clicks on Profile dropdown> "Events"
    #Then "tag" : "Rejected" appears on EventPage
    #And user clicks on "button" : "Delete Event" on EventPage
    #And user clicks on "modalbutton" : "Delete" on EventPage
