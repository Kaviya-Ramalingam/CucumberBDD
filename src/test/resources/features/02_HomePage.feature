@HomePage
Feature: Home Page validation

Background: 
    Given The user opens the browser, enters the DS Algo portal
    When The user clicks the Get Started button

@HomePage_01 @positive
 Scenario: Verify that user is able to view options for Data Structures dropdown on home page without Sign in
    Given The user is on the Home page
    When The user clicks the Data Structures dropdown
    Then The user should see the following options in the dropdown:
    | Arrays      |
    | Linked List |
    | Stack       |
    | Queue       |
    | Tree        |
    | Graph       |
    
@HomePage_02 @negative
 Scenario Outline: Verify warning message when selecting "<DataStructure>" from the dropdown without Sign in
  Given The user is on the Home page
    When The user selects "<DataStructure>" from the drop down without Sign in.
    Then The user should able to see an warning message "<WarningMessage>"

  Examples:
    | DataStructure | WarningMessage           |
    | Arrays       | You are not logged in    |
    | Linked List  | You are not logged in    |
    | Stack        | You are not logged in    |
    | Queue        | You are not logged in    |
    | Tree         | You are not logged in    |
    | Graph        | You are not logged in    |
    
    
@HomePage_03 @negative
 Scenario Outline: Verify warning message on clicking Get Started button for "<Section>" on the homepage without Sign in
  Given The user is on the Home page
   When The user clicks Get Started buttons of "<Section>" on the homepage without Sign in
   Then The user should able to see an warning message "<WarningMessage>"

  Examples:
    | Section                  | WarningMessage           |
    | Data Structures-Introduction | You are not logged in |
    | Array                    | You are not logged in    |
    | Linked List              | You are not logged in    |
    | Stack                    | You are not logged in    |
    | Queue                    | You are not logged in    |
    | Tree                     | You are not logged in    |
    | Graph                    | You are not logged in    |