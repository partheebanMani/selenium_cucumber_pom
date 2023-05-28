@Inventory
Feature: Tests to validate Inventory page

  Background:Login and navigate to inventory page
    Given Enter username as 'standard_user'
    When Enter password as 'secret_sauce'
    * Click login button
    Then verify browser navigated to inventory page



