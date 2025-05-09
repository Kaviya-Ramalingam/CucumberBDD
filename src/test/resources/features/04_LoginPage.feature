@SignInSignOut
Feature: verifying DS Algo Portal Sign In and Sign Out

  Background:
    Given The user opens the browser, enters the DS Algo portal
    When The user clicks the Get Started button

 @login_01 @positive
  Scenario: User can navigate to the Sign in page from Home Page
    Given The user is on the DS Algo Home Page
    When The user clicks the Sign in link
    Then The user should be redirected to the Sign in page

  @login_02 @negative
  Scenario Outline: User sees error message for "<TestcaseName>"
   Given The user is on the DS Algo Sign in Page
  When The user attempts to login using "<TestcaseName>" from sheet "<SheetName>"
  Then The error message from Excel should appear below the correct field

  Examples:
    | SheetName    | TestcaseName     |
    | Login        | EmptyFields      |
    | Login        | EmptyPassword    |
    | Login        | EmptyUsername    |
    | Login        | InvalidUsername  |
    
  @login_03 @positive
  Scenario Outline: User can log in with valid credentials
   Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering valid credential from "<TestcaseName>" and "<sheetName>"
    Then The user should land in Data Structure Home Page with message 
    
    Examples:
    |SheetName   |TestcaseName|
    |Login       |validDetails|
    

  @login_04 @positive
  Scenario: User can sign out successfully
    Given The user is on the DS Algo Sign in Page
    When The user clicks "Sign out" after login using valid credentials
    Then The user should be redirected to home page with message "Logged out successfully"
