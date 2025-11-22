@Amazon
Feature: This feature file to test amazon functionalities

  Scenario: Search for a product
    Given open amazon website
    Then Find product 'iphone 16'
    Then Add 'Apple iPhone 16 (128 GB) - Ultramarine' to amazon cart


  @Test
  Scenario: Add product to cart
    Given open amazon website
    Then Find product 'iphone 16'
    And open 'Apple iPhone 16 (128 GB) - Ultramarine'