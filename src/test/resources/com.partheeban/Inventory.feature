@Selenium @Inventory
Feature: Tests to validate Inventory page

  Background:Login and navigate to inventory page
    Given Enter username as 'standard_user'
    When Enter password as 'secret_sauce'
    * Click login button
    Then verify browser navigated to inventory page

  @AddProductToCart
  Scenario: Verify items are present and add to cart
    Given verify 'Sauce Labs Backpack' is present in products page
    * Add 'Sauce Labs Backpack' to cart
    Then verify 'Sauce Labs Backpack' is added in cart
    * Verify cart count is increased to 1

  @AddMultipleProductToCart
  Scenario: Verify multiple items are present and add to cart
    Given Add 'Sauce Labs Backpack,Sauce Labs Bolt T-Shirt,Sauce Labs Onesie' to cart
    Then verify 'Sauce Labs Backpack' is added in cart
    * Verify cart count is increased to 3


  @AddProductToCartAndGoto
  Scenario: Verify items are present and add to cart
    Given verify 'Sauce Labs Backpack' is present in products page
    * Add 'Sauce Labs Backpack' to cart
    Then verify 'Sauce Labs Backpack' is added in cart
    * Verify cart count is increased to 1
    * Click shopping cart icon


  @dropDown
  Scenario Outline: Select dropdown by name
    Given sort by name '<value>'

    Examples:
      | value               |
      | Name (A to Z)       |
      | Price (low to high) |
