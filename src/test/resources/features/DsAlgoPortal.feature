Feature: portal validation

  @DsAlgoPortal_01
  Scenario: Verify that user is able to open the dsAlgo Portal
    Given The user has browser open
    When The user enter correct dsAlgo portal URL
    Then The user should be able to land on dsAlgo portal with Get Started button

  @DsAlgoPortal_02
  Scenario: Verify the Home page for an user without Sign in
    Given The user opens the browser, enters the DS Algo portal
    When The user clicks the Get Started button
    Then The user should be navigated to the Data Structure Introduction page, which displays the Register and Sign in links

  @DsAlgoPortal_03 @negative
  Scenario: User enters an incorrect dsAlgo portal URL
    Given The user has browser open
    When The user enters an incorrect dsAlgo portal URL
    Then The user should see an error message or a "Page not found" screen
