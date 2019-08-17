Feature: Sign In Sign Out via Email FLow

  Scenario: Successful Signin with Valid Credentials
    Given User is on Cluster Landing Page
    When User clicks on Sign In button
    Then "button" : "Email" appears on Landing Page
    And User clicks on Email button
    Then "button" : "Sign In" appears on Landing Page
    And User enters UserName and Password
    And User clicks on Sign In button on modal
    And User clicks on Profile dropdown> "Sign Out"

# To cover sign in flows via other methods