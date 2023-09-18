@Inventory
Feature: Tests to validate Inventory page

  Background:Login and navigate to inventory page
    Given Enter username as 'standard_user'
    When Enter password as 'secret_sauce'
    * Click login button
    Then verify browser navigated to inventory page

  Scenario: Verify back bag is present and add to cart
    Given is it back Bag present
    * Add back bag to cart
    Then verify back bag is added in cart

  @dropDown
  Scenario Outline: Select dropdown by name
    Given sort by name '<value>'

    Examples:
      | value               |
      | Name (A to Z)       |
      | Price (low to high) |
