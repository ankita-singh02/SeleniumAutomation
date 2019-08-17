Feature: Check functionality for all sections of Home Tab

  Scenario: Recommended Section Test: Update Matching Preferences
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on "button" : "Update Matching Preferences" on HomePage
    Then "modal" : "Matching Questions" appears on HomePage
    And user enters "Mumbai Maharashtra" in location field on HomePage
    And user clicks on "button" : "Next" on HomePage
    And user clicks on "option" : "Advertising" on HomePage
    And user clicks on "option" : "Academia Research" on HomePage
    And user clicks on "button" : "Save" on HomePage
    Then multiple "card" : "Person" appears on HomePage

  Scenario: Recommended Section Test: Browse All link Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on "button" : "Browse All People" on HomePage
    Then Verify user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/people"

  Scenario: Recommended Section Test: Bookmark User
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on first "icon" : "Bookmark" on HomePage
    And user clicks on "button" : "Browse All People" on HomePage
    And user clicks on "filter" : "My Actions" on BrowsePage
    And user clicks on "filter" : "Starred People" on BrowsePage
    And user clicks on "button" : "Update" on BrowsePage
    And user clicks on "button" : "Update" on BrowsePage
    And user clicks on "bookmark" : "PRofile" on BrowsePage
    And user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/home"
    Then verify absence of "card" : "bookmarked" on HomePage

  Scenario: Recommended Section Test: Action Buttons Test
    Given User is on "Home" Tab ("vaishnavi+ultimateadmin@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    When user clicks on "button" : "Lets Connect" on HomePage
    Then "overlay" : "message box" appears on HomePage
    And user clicks on "button" : "cross" on HomePage
    And user clicks on "button" : "Full Profile" on HomePage
    Then "button" : "Lets Connect" appears on ProfilePage
