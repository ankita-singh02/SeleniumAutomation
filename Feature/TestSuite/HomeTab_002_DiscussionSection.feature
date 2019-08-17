Feature: Check functionality for Discussion section of Home Tab

  Scenario: Discussion Section Test: Browse All Link Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on "button" : "Browse All Discussion" on HomePage
    Then Verify user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/discussion"

  Scenario: Discussion Section Test: Action Buttons Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    Then user clicks on first "button" : "Get Updates" on HomePage
    Then "button" : "Following" appears on HomePage
    Then user clicks on first "button" : "Following" on HomePage
    Then verify absence of "button" : "Following" on HomePage
    

  Scenario: Discussion Section Test: Click on Discussion Post Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    Then user clicks on first "card" : "DISCUSSION" on HomePage
    Then verify absence of "warning" : "404" on HomePage
