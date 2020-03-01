@continue

  Feature: Continue Shopping
    As an end user
    I want to search for multiple products
    So that i can view the products

  Scenario: Continue Shopping
    Given I am homepage
    When I search for product "nike"
    And It should select any product randomly
    And No of quantity should be increased by "1"
    And Select Continue shopping
    Then I search for product "puma"
    And It should select any product randomly
    And No of quantity should be increased by "2"
    And Add it to trolley
    And Check the actual and expected results

