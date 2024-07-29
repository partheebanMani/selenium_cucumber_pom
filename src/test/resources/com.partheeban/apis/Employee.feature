Feature: Feature file to test Employee Rest API.

  @Employee
  Scenario: Test case to verify GET employee API
    Given Call get all employee API
    When verify response code is 200
    Then verify total data is equal to per_page