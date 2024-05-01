Feature: This feature file is to test User functionalities

  @user
  Scenario: verify create user function
    Given Create user with below details
      | name | salary | age |
      | Dane | 20000  | 26  |
    When verify response code is 201