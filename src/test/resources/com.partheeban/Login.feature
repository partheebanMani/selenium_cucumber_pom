@LoginPage
Feature:  This feature file is to sourceLab website

  @LoginPositive
  Scenario: Valid Login scenario
    Given Enter username as 'standard_user'
    When Enter password as 'secret_sauce'
    * Click login button
    Then verify login is successful


  @LoginNegative
  Scenario: Invalid Login scenario
    Given Enter username as 'standard_user'
    When Enter password as 'secre45t_sauce'
    * Click login button
    Then verify browser remains in login page