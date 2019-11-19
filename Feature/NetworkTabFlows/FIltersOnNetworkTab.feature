Feature: Network Tab Filters

  Scenario Outline: Apply FIlters on Network Tab
    Given User is on "BROWSE" Tab ("ankita+0109@peoplegrove.com","Peoplegrove@1","https://automation.demo.peoplegrove.com/")
    When user applies filter <filter>
    
   Examples:
   |filter|
   |Search:abc;Location:Mumbai,Tokyo;Major(s):Art,Computer;Expertise:Advertising,Business Development,Consulting|   
     
    