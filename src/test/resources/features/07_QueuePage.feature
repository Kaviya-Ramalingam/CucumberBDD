@QueuePage
Feature: Queue Module Functionality in dsAlgo Portal

  Background: 
    Given The user opens the browser, enters the DS Algo portal
    And The user clicks the Get Started button

  @GraphPage_01 @positive
  Scenario: User navigates to the Graph page
    Given The user is in the Home page after logged in
    When The user clicks the "Queue" link
    Then The user should be redirected to the "Queue" page

  @Queue_01 @positive
  Scenario: User navigates to "Implementation of Queue in Python" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation of Queue in Python" button
    Then The user should be redirected to the "Implementation of Queue in Python" page

  @Queue_02 @positive
  Scenario: User navigates to Try Editor from "Implementation of Queue in Python" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation of Queue in Python" button
    And The user clicks the "Try Here" button
    Then The user should be redirected to the Try Editor page with a Run button

  @Queue_03 @negative
  Scenario: User clicks Run without entering code in Try Editor for "Implementation of Queue in Python"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation of Queue in Python" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button without entering code
    Then The user should see an error message in an alert window

  @Queue_04 @negative
  Scenario: User runs invalid Python code in Try Editor for "Implementation of Queue in Python"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation of Queue in Python" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering invalid python code
    Then The user should see an error message in an alert window

  @Queue_05 @positive
  Scenario: User runs valid Python code in Try Editor for "Implementation of Queue in Python"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation of Queue in Python" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering valid python code
    Then The user should see output in the console

  @Queue_06 @positive
  Scenario: User navigates to Practice Questions from "Implementation of Queue in Python" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation of Queue in Python" button
    And The user clicks the "Practice Questions" button
    Then The user should be redirected to the blank Practice page

  @Queue_07 @positive
  Scenario: User navigates to "Implementation using collections.deque" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using collections.deque" button
    Then The user should be redirected to the "Implementation using collections.deque" page

  @Queue_08 @positive
  Scenario: User navigates to Try Editor from "Implementation using collections.deque" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using collections.deque" button
    And The user clicks the "Try Here" button
    Then The user should be redirected to the Try Editor page with a Run button

  @Queue_09 @negative
  Scenario: User clicks Run without entering code in Try Editor for "Implementation using collections.deque"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using collections.deque" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button without entering code
    Then The user should see an error message in an alert window

  @Queue_10 @negative
  Scenario: User runs invalid Python code in Try Editor for "Implementation using collections.deque"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using collections.deque" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering invalid python code
    Then The user should see an error message in an alert window

  @Queue_11 @positive
  Scenario: User runs valid Python code in Try Editor for "Implementation using collections.deque"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using collections.deque" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering valid python code
    Then The user should see output in the console

  @Queue_12 @positive
  Scenario: User navigates to Practice Questions from "Implementation using collections.deque" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using collections.deque" button
    And The user clicks the "Practice Questions" button
    Then The user should be redirected to the blank Practice page

  @Queue_13 @positive
  Scenario: User navigates to "Implementation using array" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using array" button
    Then The user should be redirected to the "Implementation using array" page

  @Queue_14 @positive
  Scenario: User navigates to Try Editor from "Implementation using array" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using array" button
    And The user clicks the "Try Here" button
    Then The user should be redirected to the Try Editor page with a Run button

  @Queue_15 @negative
  Scenario: User clicks Run without entering code in Try Editor for "Implementation using array"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using array" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button without entering code
    Then The user should see an error message in an alert window

  @Queue_16 @negative
  Scenario: User runs invalid Python code in Try Editor for "Implementation using array"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using array" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering invalid python code
    Then The user should see an error message in an alert window

  @Queue_17 @positive
  Scenario: User runs valid Python code in Try Editor for "Implementation using array"
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using array" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering valid python code
    Then The user should see output in the console

  @Queue_18 @positive
  Scenario: User navigates to Practice Questions from "Implementation using array" page
    Given The user is on the "Queue" page
    When The user clicks the "Implementation using array" button
    And The user clicks the "Practice Questions" button
    Then The user should be redirected to the blank Practice page

  @Queue_19 @positive
  Scenario: User navigates to "Queue Operations" page
    Given The user is on the "Queue" page
    When The user clicks the "Queue Operations" button
    Then The user should be redirected to the "Queue Operations" page

  @Queue_20 @positive
  Scenario: User navigates to Try Editor from "Queue Operations" page
    Given The user is on the "Queue" page
    When The user clicks the "Queue Operations" button
    And The user clicks the "Try Here" button
    Then The user should be redirected to the Try Editor page with a Run button

  @Queue_21 @negative
  Scenario: User clicks Run without entering code in Try Editor for "Queue Operations"
    Given The user is on the "Queue" page
    When The user clicks the "Queue Operations" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button without entering code
    Then The user should see an error message in an alert window

  @Queue_22 @negative
  Scenario: User runs invalid Python code in Try Editor for "Queue Operations"
    Given The user is on the "Queue" page
    When The user clicks the "Queue Operations" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering invalid python code
    Then The user should see an error message in an alert window

  @Queue_23 @positive
  Scenario: User runs valid Python code in Try Editor for "Queue Operations"
    Given The user is on the "Queue" page
    When The user clicks the "Queue Operations" button
    And The user clicks the "Try Here" button
    And The user clicks the Run button after entering valid python code
    Then The user should see output in the console

  @Queue_24 @positive
  Scenario: User navigates to Practice Questions from "Queue Operations" page
    Given The user is on the "Queue" page
    When The user clicks the "Queue Operations" button
    And The user clicks the "Practice Questions" button
    Then The user should be redirected to the blank Practice page
