Feature: Products Page Functionality

  Background:
    Given user launches the application
   

  Scenario: Validate products page title
    Then Products page title should be "Products"
  
  Scenario:Validate single product name
  Then Product name should be "Sauce Labs Backpack"

  Scenario:
    When user selects filter "Name (Z to A)"
    Then product should be sorted in descending order "Test.allTheThings() T-Shirt (Red)"
 
  Scenario:  
    When user selects filter "Name (A to Z)"
    Then product should be sorted in ascending order "Sauce Labs Backpack"
 
  Scenario:
    When user selects filter "Price (low to high)"
    Then products should be sorted by low to high price "7.99"
  
  Scenario:
    When user selects filter "Price (high to low)"
    Then products should be sorted by high to low price "49.99"

  Scenario: Verify remove button functionality
    When user clicks Add To Cart button
    Then Remove button should be displayed
 
  Scenario: Verify cart icon display
    Then cart icon should be visible

  Scenario: Verify cart item count
    When user adds 1 product to cart
    Then cart badge count should be 1
   
  Scenario: Verify cart icon click function
  Then user clicks cart icon
  

 