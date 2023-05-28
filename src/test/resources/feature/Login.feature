@LoginPage
Feature:  This feature file is to sourceLab website

  Scenario: Valid Login scenario
    Given Enter username as 'standard_user'
    When Enter password as 'secret_sauce'
    Then Click login button
    * verify login is successful


  Scenario: Invalid Login scenario
    Given Enter username as 'standard_user'
    When Enter password as 'secre45t_sauce'
    Then Click login button
    * verify browser remains in login page