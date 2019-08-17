Feature: Check functionality for Events section of Home Tab

  Scenario: Events Section Test: Browse All Link Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on "button" : "Browse All Events" on HomePage
    Then Verify user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/events"

  Scenario: Events Section Test: Event Card Action Buttons Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on first "button" : "More Info Event" on HomePage
    Then Verify user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/event/1875"
    And user clicks on "button" : "Back" on HomePage
    And user clicks on first "button" : "Register" on HomePage
    Then "modal" : "Event Registration" appears on HomePage
    And user clicks on "button" : "No" on HomePage

