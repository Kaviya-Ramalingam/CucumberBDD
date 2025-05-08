@RegisterPage
Feature: Register Page validation

  Background:
    Given The user opens the browser, enters the DS Algo portal
    When The user clicks the Get Started button

  @Register1
  Scenario: Verify that user is able to land on Register Page
    When The user clicks Register link on the Home page
    Then The user should be redirected to Register form

 @ValidRegistration
  Scenario Outline: Verify user is able to register successfully with valid <TestScenario>
    When The user enters valid registration details from sheet "<SheetName>" and scenario "<TestScenario>"
    Then The user should be redirected to Home Page of DS Algo with account created message

    Examples:
      | SheetName      | TestScenario         |                                              
      | RegisterTests  | RegisterValid        |
      | RegisterTests  | EdgeUsername1        | 
      | RegisterTests  | EdgeUsernameLong     | 

  @InvalidRegistration
  Scenario Outline: Verify user registration fails for invalid <TestScenario>
    When The user enters invalid registration details from sheet "<SheetName>" and scenario "<TestScenario>"
    Then The user should see the registration error message 

    Examples:
      | SheetName      | TestScenario        | 
      | RegisterTests  | EmptyUsername       | 
      | RegisterTests  | EmptyPassword       | 
      | RegisterTests  | EmptyConfirmPwd     | 
      | RegisterTests  | InvalidUsername1    | 
      | RegisterTests  | InvalidUsername2    | 
      | RegisterTests  | InvalidPassword1    | 
      | RegisterTests  | PasswordMismatch    | 
      | RegisterTests  | ExistingUser        | 

  @RegisterRedirect
  Scenario: Verify that user is able to land on login page from register page
    When The user clicks the Signin link in the register page
    Then The user should be redirected to login form