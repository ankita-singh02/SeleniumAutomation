Feature: Check functionality for Resources section of Home Tab

  Scenario: Resources Section Test: Browse All Link Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on "button" : "Browse All Resources" on HomePage
    Then Verify user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/resources"

  Scenario: Resources Section Test: Click on Resources Post Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    Then user clicks on first "card" : "RESOURCES" on HomePage
    Then verify absence of "warning" : "404" on HomePage
    