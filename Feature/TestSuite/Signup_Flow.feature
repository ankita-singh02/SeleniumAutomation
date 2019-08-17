Feature: SignUp Flow

  Scenario: Sign up flow with all steps using email
    Given User is on Cluster Landing Page
    When user clicks on "button" : "Join Community" on Landing Page
    Then "modal" : "auth" appears on Landing Page
    And user clicks on "button" : "Email" on Landing Page
    Then "modal" : "email signup" appears on Landing Page
    And user enters correct signup credentials
    And user clicks on "button" : "Create Account" on Landing Page
    Then user navigates to HUB_SELECT Page
    And user clicks on "Automation Hub" on Hub Select Page
   
    Then user navigates to SELECT_TYPE Page
    And user clicks on "Alumna" on Select Type Page
    Then user navigates to BASIC_INFO Page
    And user enters "This is my test Headline" in "Headline" field on Basic Info Page
    And user enters location "Mumbai" on Basic Info Page
    And user clicks on "button" : "Continue" on Basic Info Page
    
    Then user navigates to WORK_HISTORY Page
    And user enters "PeopleGrove Inc." in "Company Name" field on Work History Page
    And user clicks on "button" : "Search" on Work History Page
    And user clicks on "button" : "Select" on Work History Page
    And user enters location "Mumbai" on Work History Page
    And user selects start date month: "February" year: "2018"
    And user clicks on "checkbox" : "I currently work here" on Work History Page
    And user enters "SDET" in "Current Role" field on Work History Page
    And user enters "Writing automated tests" in "Role Description" field on Work History Page
    And user clicks on "button" : "+Save" on Work History Page
    
    And user clicks on "button" : "Add Another Company" on Work History Page
		And user enters "Bubble Inc" in "Company Name" field on Work History Page
    And user clicks on "button" : "Search" on Work History Page
    And user clicks on "button" : "Select" on Work History Page
    And user enters location "New York" on Work History Page  
    And user selects start date month: "April" year: "2016"      
    And user selects end date month: "December" year: "2017"    
 		And user enters "Application Support" in "Current Role" field on Work History Page
    And user enters "Tech Support for Clients" in "Role Description" field on Work History Page   
    And user clicks on "button" : "+Save" on Work History Page       
		Then "companytitle" : "Bubble Inc" appears on Work History Page
		Then "companytitle" : "PeopleGrove Inc." appears on Work History Page
    And user clicks on "button" : "Continue" on Work History Page

    
    Then user navigates to SELECT_SCHOOL Page
    And user enters School on Select School Page
    And user enters and selects "TestMajor" in "Majors" field on Select School Page
    And user enters and selects "TestMinor" in "Minors" field on Select School Page
    And user clicks on "Degree Type" dropdown > option "test 1" on Select School Page
    And user clicks on "Graduation Year" dropdown > option "2017" on Select School Page
    And user clicks on "Specialization Branch" dropdown > option "Test Automation" on Select School Page
    And user clicks on "button" : "Continue" on Select School Page
    
    Then user navigates to CALENDAR_SYNC Page
    And user clicks on "Calendar Setup" dropdown > option "Manage Calendar Locally" on Calendar Sync Page
    And user clicks on "Default Meeting Duration" dropdown > option "30 minutes" on Calendar Sync Page
    And user clicks on "Minimum Notice" dropdown > option "1 day" on Calendar Sync Page
    And user clicks on "Maximum Notice" dropdown > option "2 weeks" on Calendar Sync Page
    And user selects weekdays as available
    And user clicks on "button" : "Save Settings" on Calendar Sync Page
   
    Then user navigates to HOW_CAN_I_HELP Page
    And user clicks on "checkbox" : "Advertising" on How Can I Help Page
    And user clicks on "checkbox" : "Choosing a Major" on How Can I Help Page
    And user clicks on "button" : "Continue" on How Can I Help Page
   
    Then user navigates to USER_GROUPS Page
    And user clicks on "radio" : "Yes" on User Groups Page
    And user clicks on "button" : "Select Group" on User Groups Page
    And user clicks on "checkbox" : "Automated Public Group" on User Groups Page
    And user clicks on "button" : "Save" on User Groups Page
    And user clicks on "button" : "Continue" on User Groups Page
    And user enters "4545" in "NUMBER GROUP QUESTION" field on User Groups Page
    And user enters "https://www.google.com" in "LINK GROUP QUESTION" field on User Groups Page
    And user clicks on "button" : "Select" on User Groups Page
    And user clicks on "checkbox" : "Option X" on User Groups Page
    And user clicks on "checkbox" : "Option Y" on User Groups Page
    And user clicks on "button" : "Save" on User Groups Page
    And user clicks on "List Of Option" dropdown > option "Option 2" on User Groups Page
    And user clicks on "checkbox" : "Checkbox for Group" on User Groups Page
    And user enters "Peoplegrove Rockssss" in "LONG TEXT GROUP QUESTION" field on User Groups Page
    And user enters "8.88" in "DECIMAL NUMBER GROUP QUESTION" field on User Groups Page
    And user enters "I am happy" in "TEXT GROUP QUESTION" field on User Groups Page
    And user clicks on "button" : "xContinue" on User Groups Page
    
    Then user navigates to USER_PROGRAMS Page
    And user clicks on "radio" : "Yes" on User Programs Page
    And user clicks on "button" : "Select Program" on User Programs Page
    And user clicks on "checkbox" : "AUTOMATED ALUMNA PUBLIC PROGRAM" on User Programs Page
    And user clicks on "button" : "Save" on User Programs Page
    And user clicks on "button" : "Continue" on User Programs Page
    And user clicks on "radio" : "Mentor" on User Programs Page
    And user enters "20" in "AGE" field on User Programs Page
    And user clicks on "checkbox" : "Checkbox for Program" on User Programs Page
    And user clicks on "Select One" dropdown > option "Yes" on User Programs Page
    And user clicks on "button" : "Select" on User Programs Page
    And user clicks on "checkbox" : "Cardi B" on User Programs Page
    And user clicks on "checkbox" : "Jet" on User Programs Page
    And user clicks on "button" : "Save" on User Programs Page
    And user enters "8" in "Number Program Question" field on User Programs Page
    And user enters "Pheobe and Joey" in "Text Program Question" field on User Programs Page
    And user clicks on "button" : "xContinue" on User Programs Page
   
    Then user navigates to SMS_NOTIFICATIONS Page
    And user clicks on "checkbox" : "New connection requests" on Sms Notifications Page
    And user clicks on "checkbox" : "Upcoming Meetings" on Sms Notifications Page
    And user clicks on "checkbox" : "New Message" on Sms Notifications Page
    And user enters "3103417484" in "Phone Number" on Sms Notifications Page
    And user clicks on "button" : "Continue" on Sms Notifications Page
    
    Then user navigates to ALUMNI_ADVICE Page
    And user clicks on "button" : "Continue" on Alumni Advice Page
   
    Then user navigates to CUSTOM_FIELDS Page
    And user enters "01234" in "Number Custom Field" on Custom fields Page
    And user enters "abcd" in "Text Custom Field" on Custom fields Page
    And user enters location "Mumbai" on Custom fields Page
    And user enters "https://www.google.com" in "Link Custom Field" on Custom fields Page
    And user enters "This is an automated text" in "Long Custom Field" on Custom fields Page
    And user clicks on "checkbox" : "Checkbox Custom Field" on Custom fields Page
    And user clicks on "button" : "Select" on Custom fields Page
    And user clicks on "checkbox" : "Test 2" on Custom fields Page
    And user clicks on "button" : "Save" on Custom fields Page
    And user selects Custom Date Field on Custom Field Page
    And user clicks on "button" : "Continue" on Custom fields Page
    
    Then user navigates to SIGN_AGREEMENT Page
    And user checks the Agreement checkbox on Agreement Page
    And user draws sign on Agreement Page
    And user clicks on "button" : "Next" on  Agreement Page
   
    Then user navigates to JOIN_ADDITIONAL_HUBS Page
    And user clicks on "button" : "Skip for Now" on Join Additional Hubs Page 
    
    Then user lands on Home Page
