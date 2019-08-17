Feature: Discussion Flows

  Scenario: User Posts on Discussion Tab (Anonymous)
    Given User is on "Home" Tab ("vaishnavi+637121_@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/discussion"
    And user enters "This is Anon Question" in "Ask Question Here" field on DiscussionPage
    And user enters "This question will be accepted by Admin" in "Question Description" field on DiscussionPage
    And user clicks on "button" : "Ask Question" on DiscussionPage
    And user clicks on "button" : "Got It" on DiscussionPage
    And user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/discussion/myposts"
    Then "tag" : "Pending Approval" appears on DiscussionPage

  Scenario: Admin Approves Post
    Given admin navigates to "Approval Queues" > "Approve Questions" card
    And admin clicks on "button" : "Approve"

  Scenario: User Posts Discussion Post using all formatting options (Not Anonymous )
    Given User is on "Home" Tab ("vaishnavi+637121_@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/discussion"
    And user enters "This is a Signed Question" in "Ask Question Here" field on DiscussionPage
    And user enters questions description using all formatting options
    And user clicks on "checkbox" : "Post Anonymously?" on DiscussionPage
    And user clicks on "button" : "Ask Question" on DiscussionPage

  Scenario: Admin Rejects Post
    Given admin navigates to "Approval Queues" > "Approve Questions" card
    And admin clicks on "button" : "Reject"

  Scenario: User facing consequences of Admin's Rejection and Approval of Questions
    Given User is on "Home" Tab ("vaishnavi+637121_@peoplegrove.com","Peoplegrove@123","https://automation.demo.peoplegrove.com/")
    And user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/discussion/myposts"
    And user navigates to "1" discussion Post
    Then "tag" : "Question Rejected" appears on DiscussionPage
    And user navigates to "https://automation.demo.peoplegrove.com/hub/automation-hub/discussion/myposts"
    And user navigates to "2" discussion Post
    Then "button" : "Offer Your Help" appears on DiscussionPage
# Test: Tagging @discussionGuy, check identifier in ANswer
# Test: Answer anon and non-anon
#Test: Bold,itlaic,underline display on site
# Click "Offer your help" and check UI change and same for stop offering your help
# Like, edit, delete button, notify me, unsubscribe
