@GraphPage
Feature: Graph Module Functionality in dsAlgo Portal

  Background: 
    Given The user opens the browser, enters the DS Algo portal
    And The user clicks the Get Started button

@GraphPage_01 @positive
  Scenario: User navigates to the Graph page
    Given The user is in the Home page after logged in
    When The user clicks the "Graph" link
    Then The user should be redirected to the "Graph" page

@GraphPage_02 @positive
  Scenario: User navigates to Try Editor from Graph page
    Given The user is on the "Graph" page
    When The user clicks the "Try Here" button
    Then The user should be redirected to the Try Editor page with a Run button

@GraphPage_03 @negative
  Scenario: User clicks Run without entering code in Try Editor for Graph page
    Given The user is on the "Graph" page
    When The user clicks the "Try Here" button
    And The user clicks the Run button without entering code
    Then The user should see an error message in an alert window

@GraphPage_04 @negative
  Scenario: User runs invalid Python code in Try Editor for Graph page
    Given The user is on the "Graph" page
    When The user clicks the "Try Here" button
    And The user clicks the Run button after entering invalid phython code
    Then The user should see an error message in an alert window

@GraphPage_05 @positive
  Scenario: User runs valid Python code in Try Editor for Graph page
    Given The user is on the "Graph" page
    When The user clicks the "Try Here" button
    And The user clicks the Run button after entering valid phython code
    Then The user should see the output in the console

@GraphPage_06 @positive
  Scenario: User navigates to Practice Questions from Graph page
    Given The user is on the "Graph" page
    When The user clicks the "Practice Questions" button
    And The user should be redirected to the Practice Questions page
    Then The Practice Questions page should be blank

@GraphPage_07 @positive
  Scenario: User navigates to Graph Representations page
    Given The user is on the "Graph" page
    When The user clicks the "Graph Representations" link
    Then The user should be redirected to the "Graph Representations" page

@GraphPage_08 @positive
  Scenario: User navigates to Try Editor from Graph Representations page
    Given The user is on the "Graph" page
    When The user clicks the "Graph Representations" page
    And The user clicks the "Try Here" button
    Then The user should be redirected to the Try Editor page with a Run button

@GraphPage_09 @negative
  Scenario: User clicks Run without entering code in Try Editor for Graph Representations page
    Given The user is on the "Graph" page
    When The user clicks the "Graph Representations" page
    And The user clicks the "Try Here" button
    And The user clicks the Run button without entering code
    Then The user should see an error message in an alert window

@GraphPage_10  @negative
  Scenario: User runs invalid Python code in Try Editor for Graph Representations page
    Given The user is on the "Graph" page
    When The user clicks the "Graph Representations" page
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering invalid phython code
    Then The user should see an error message in an alert window

@GraphPage_11 @positive
  Scenario: User runs valid Python code in Try Editor for Graph Representations page
    Given The user is on the "Graph" page
    When The user clicks the "Graph Representations" page
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering valid phython code
    Then The user should see the output in the console

@GraphPage_12 @positive
  Scenario: User navigates to Practice Questions from Graph Representations page
    Given The user is on the "Graph" page
    When The user clicks the "Graph Representations" page
    And The user clicks the "Practice Questions" button
    Then The user should be redirected to the blank Practice Questions page
