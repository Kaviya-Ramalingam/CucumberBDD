@RegisterPage
Feature: Register Page validation

  Background: 
    Given The user opens the browser, enters the DS Algo portal
    When The user clicks the Get Started button

  @RegisterPage_01 @positive
  Scenario: Verify that user is able to land on Register Page
    Given The user is on the user registration page
    When The user clicks Register link on the Home page
    Then The user should be redirected to Register form

  @RegisterPage_02 @positive
  Scenario Outline: Verify user is able to register successfully with valid <TestCaseName>
    Given The user is on the user registration page
    When The user enters registration details from sheet "<SheetName>" and scenario "<TestCaseName>"
    Then The user should be redirected to Home Page of DS Algo with account created message

    Examples: 
      | SheetName | TestCaseName  |
      | Register  | RegisterValid |

  @RegisterPage_03 @negative
  Scenario Outline: Verify user registration fails for invalid <TestCaseName>
    Given The user is on the user registration page
    When The user enters registration details from sheet "<SheetName>" and scenario "<TestCaseName>"
    Then The user should see the registration error message for "<TestCaseName>" from "<SheetName>"

    Examples: 
      | SheetName | TestCaseName     |
      | Register  | InvalidUsername1 |
      | Register  | InvalidPassword  |
      | Register  | PasswordMismatch |
      | Register  | ExistingUser     |

  @RegisterPage_04 @negative
  Scenario Outline: Verify user registration fails for missing fields <TestCaseName>
    Given The user is on the user registration page
    When The user enters registration details from sheet "<SheetName>" and scenario "<TestCaseName>"
    Then The user should see the registration warning message for "<TestCaseName>" from "<SheetName>"

    Examples: 
      | SheetName | TestCaseName         |
      | Register  | EmptyUsername        |
      | Register  | EmptyPassword        |
      | Register  | EmptyConfirmPassword |
