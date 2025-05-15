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
    When The user attempts to login with "<TestcaseName>" from sheet "<SheetName>"
    Then The user should see a error message "<TestcaseName>" from sheet "<SheetName>"

    Examples: 
      | SheetName | TestcaseName    |
      | Login     | InvalidUsername |

  @login_03 @positive
  Scenario Outline: User can log in with valid credentials
    Given The user is on the DS Algo Sign in Page
    When The user attempts to login with "<TestcaseName>" from sheet "<SheetName>"
    Then The user should land in Data Structure Home Page with success message "<TestcaseName>" from sheet "<SheetName>"

    Examples: 
      | SheetName | TestcaseName |
      | Login     | validDetails |

  @login_04 @positive
  Scenario Outline: User can log in with valid credentials
    Given The user is on the DS Algo Sign in Page
    When The user attempts to login with "<TestcaseName>" from sheet "<SheetName>"
    And The user clicks logout
    Then The user should be redirected to home page with message "Logged out successfully"

    Examples: 
      | SheetName | TestcaseName |
      | Login     | validDetails |
