Feature: Search
  As an end user
  I want to search a product
  So that i can view product i wish

Scenario:Add to basket
  Given I am homepage
  When  I search for product "nike"
  And It should randomly select one product
  Then Add it to trolley
  And Check the selected page is in trolley page