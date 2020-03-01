@category
  Feature: Filter the products
    As  As an end user
    I want to search for products with filter conditions
    So that i can view the products
  Scenario: Filter the products
    Given I am homepage
    When I search for product "nike"
    And I need to apply filter techniques "Backpacks"
    Then I should be able to see the products for "Backpacks"

