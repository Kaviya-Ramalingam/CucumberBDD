@GraphPage
Feature: Graph Module Functionality in dsAlgo Portal

  Background: 
    Given The user opens the browser, enters the DS Algo portal
    When The user clicks the Get Started button
    And The user is in the Home page after logged in

  @GraphPage_01 @positive
  Scenario: User navigates to the Graph page
    When The user clicks the Graph link
    Then The user should be redirected to the Graph page

  @GraphPage_02 @positive
  Scenario: User navigates to Try Editor from Graph page
    Given The user is on the Graph page
    When The user clicks the Try Here button
    Then The user should be redirected to a page having a try Editor with a Run button to test

  @GraphPage_03 @negative
  Scenario: User clicks Run without entering code in Try Editor for Graph page
    Given The user is on the Graph page
    When The user clicks the Try Here button
    And The user clicks the Run button without entering the code in the Editor
    Then The user should see an error message in alert window

  @GraphPage_04 @negative
  Scenario Outline: User runs invalid Python code in Try Editor for Graph page
    Given The user is on the Graph page
    When The user clicks the Try Here button
    And The user writes code for "<TestcaseName>" from "<SheetName>" in the Editor and clicks the Run button.
    Then The user should see expected error for "<TestcaseName>" from "<SheetName>" in the alert window

    Examples: 
      | TestcaseName | SheetName      |
      | InvalidCode  | DataStructures |

  @GraphPage_05 @positive
  Scenario Outline: User runs valid Python code in Try Editor for Graph page
    Given The user is on the Graph page
    When The user clicks the Try Here button
    And The user writes code for "<TestcaseName>" from "<SheetName>" in the Editor and clicks the Run button
    Then The user should see expected output for "<TestcaseName>" from "<SheetName>" in the console

    Examples: 
      | TestcaseName | SheetName      |
      | ValidCode    | DataStructures |

  @GraphPage_06 @positive
  Scenario: User navigates to Practice Questions from Graph page
    Given The user is on the Graph page
    When The user clicks the Practice Questions button
    Then The user should be redirected to Practice Questions of graph

  @GraphPage_07 @positive
  Scenario: User navigates to Graph Representations page
    Given The user is on the Graph page
    When The user clicks the Graph Representations link
    Then The user should be redirected to the Graph Representations page

  @GraphPage_08 @positive
  Scenario: User navigates to Try Editor from Graph Representations page
    Given The user is on the Graph page
    When The user clicks the Graph Representations page
    And The user clicks the Try Here button
    Then The user should be redirected to a page having a try Editor with a Run button to test

  @GraphPage_09 @negative
  Scenario: User clicks Run without entering code in Try Editor for Graph Representations page
    Given The user is on the Graph page
    When The user clicks the Graph Representations page
    And The user clicks the Try Here button
    And The user clicks the Run button without entering the code in the Editor
    Then The user should see an error message in alert window

  @GraphPage_10 @negative
  Scenario Outline: User runs invalid Python code in Try Editor for Graph Representations page
    Given The user is on the Graph page
    When The user clicks the Graph Representations page
    And The user clicks the Try Here button
    And The user writes code for "<TestcaseName>" from "<SheetName>" in the Editor and clicks the Run button.
    Then The user should see expected error for "<TestcaseName>" from "<SheetName>" in the alert window

    Examples: 
      | TestcaseName | SheetName      |
      | InvalidCode  | DataStructures |

  @GraphPage_11 @positive
  Scenario Outline: User runs valid Python code in Try Editor for Graph Representations page
    Given The user is on the Graph page
    When The user clicks the Graph Representations page
    And The user clicks the Try Here button
    And The user writes code for "<TestcaseName>" from "<SheetName>" in the Editor and clicks the Run button
    Then The user should see expected output for "<TestcaseName>" from "<SheetName>" in the console

    Examples: 
      | TestcaseName | SheetName      |
      | ValidCode    | DataStructures |
