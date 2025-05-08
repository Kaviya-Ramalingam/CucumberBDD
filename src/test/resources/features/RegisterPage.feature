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
  Scenario Outline: Verify user is able to register successfully with valid <TestScenario>
    Given The user is on the user registration page
    When The user enters valid registration details from sheet "<SheetName>" and scenario "<TestScenario>"
    Then The user should be redirected to Home Page of DS Algo with account created message

    Examples: 
      | SheetName     | TestScenario     |
      | RegisterTests | RegisterValid    |
      | RegisterTests | EdgeUsername1    |
      | RegisterTests | EdgeUsernameLong |

  @RegisterPage_03 @negative
  Scenario Outline: Verify user registration fails for invalid <TestScenario>
    Given The user is on the user registration page
    When The user enters invalid registration details from sheet "<SheetName>" and scenario "<TestScenario>"
    Then The user should see the registration error message

    Examples: 
      | SheetName     | TestScenario     |
      | RegisterTests | EmptyUsername    |
      | RegisterTests | EmptyPassword    |
      | RegisterTests | EmptyConfirmPwd  |
      | RegisterTests | InvalidUsername1 |
      | RegisterTests | InvalidUsername2 |
      | RegisterTests | InvalidPassword1 |
      | RegisterTests | PasswordMismatch |
      | RegisterTests | ExistingUser     |

  @RegisterPage_04 @positive
  Scenario: Verify that user is able to land on login page from register page
    Given The user is on the user registration page
    When The user clicks the Signin link in the register page
    Then The user should be redirected to login form
