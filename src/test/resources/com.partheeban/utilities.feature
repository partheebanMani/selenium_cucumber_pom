@Selenium
Feature: This feature file is run utilities feature files

  @Google
  Scenario: Find which site has lowest price
    Given Open google page
    When Enter product to search for "samsung s24"
    And Navigate to shopping section
    Then Find site which has lowest price


  @Assignment
  Scenario: test pratical
    Given Execute the test case