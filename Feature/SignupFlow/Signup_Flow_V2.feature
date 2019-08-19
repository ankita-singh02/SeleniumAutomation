Feature: SignUp Flow

  Background: 
    Given User is on Cluster Landing Page

  Scenario Outline: Sign up flow with all steps using email
    When user navigates to signup page
    And enters all the user details <details>
    And selects Hub on Hub Select Page
    And selects <usertype> on Select Type Page
    And fills basic info page <basic_info>
    And fills work history info <work_info>
    And fills school info <school_info>
    And enters details on how can I help page <help_details>
    And fills groups details <group_details>
    And fills program details <program_details>
    And enters SMS notification details <sms_details>
    And fills custom field details <custom_details>
    And fills agreement page
    And user clicks on "button" : "Skip for Now" on Join Additional Hubs Page
    Then user lands on Home Page

    Examples: 
      | details                      | usertype | basic_info                      | work_info                                                         | school_info                                                 | help_details                 | group_details                                                             | program_details          | sms_details                                                      | custom_details                                                     |
      | Ankita,Singh,Peoplegrove@123 | Alumna   | This is my test headline,Mumbai | PeopleGrove Inc,Mumbai,February,2018,SDET,Writing automated tests | CampusKudos,TestMajor,TestMinor,test 1,2017,Test Automation | Advertising,Choosing a Major | 4545,https://www.google.com,Option 2,Peoplegrove Rockssss,8.88,I am happy | 20,Yes,8,Pheobe and Joey | New connection requests,Upcoming Meetings,New Message,3103417484 | 01234,abcd,Mumbai,https://www.google.com,This is an automated text |
