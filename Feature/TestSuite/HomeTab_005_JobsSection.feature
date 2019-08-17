Feature: Check functionality for Jobs section of Home Tab

  Scenario: Jobs Section Test: Browse All Link Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on "button" : "Browse All Jobs" on HomePage
    Then Verify user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/opportunities"

  Scenario: Jobs Section Test: Jobs Card Action Buttons Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on first "jobcard" : "Company" on HomePage
    Then Verify user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/company/bubble-inc/info"
    And user clicks on "button" : "Back" on HomePage
    And user clicks on first "button" : "More Info Jobs" on HomePage
    Then Verify user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/opportunities/16789/bubble-inc-test-job-title-ZWVqM0mg6R"
