@DSIntro
Feature: Data Structures - Introduction

  Background: 
    Given The user opens the browser, enters the DS Algo portal
    And The user clicks the Get Started button

  @DSIntro_01 @positive
  Scenario: User can navigate to "Data Structures - Introduction" page
    Given The user is in the Home page after logged in
    When The user clicks the "Get Started" button in Data Structures - Introduction
    Then The user should land in "Data Structures- Introduction Page"

  @DSIntro_02 @positive
  Scenario: User can navigate to "Time Complexity" page
    Given The user is in Data structures-indroduction page
    When The user clicks the "Time Complexity" button
    Then The user should be redirected to "Time Complexity" of Data Structures - Introduction

  @DSIntro_03 @positive
  Scenario: User can navigate to "Practice Questions" page
    Given The user is in Data structures-indroduction page
    When The user clicks the "Time Complexity" button
    And The user clicks the "Practice Questions" button
    Then The user should be redirected to "Practice Questions" of Data Structures - Introduction

  @DSIntro_04 @positive
  Scenario: User can navigate to "Try Editor" page
    Given The user is in Data structures-indroduction page
    When The user clicks the "Time Complexity" button
    And The user clicks the "Try Here" button
    Then The user should be redirected to a page having a try Editor with a Run button to test

  @DSIntro_05 @negative
  Scenario: User receives error when clicking Run button without entering code
    Given The user is in Data structures-indroduction page
    When The user clicks the "Time Complexity" button
    And The user clicks the "Try Here" button
    And The user clicks the Run Button without entering the code in the Editor
    Then The user should see an error message in alert window

  @DSIntro_06 @negative
  Scenario: User receives error for invalid python code
    Given The user is in Data structures-indroduction page
    When The user clicks the "Time Complexity" button
    And The user clicks the "Try Here" button
    And The user writes invalid code in the Editor and clicks the Run Button
    Then The user should see an error message in alert window

  @DSIntro_07 @positive
  Scenario: User sees output for valid python code
    Given The user is in Data structures-indroduction page
    When The user clicks the "Time Complexity" button
    And The user clicks the "Try Here" button
    And The user writes valid code in the Editor and clicks the Run Button
    Then The user should see output in the console
