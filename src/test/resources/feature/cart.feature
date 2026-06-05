Feature: cart page functionality
Background: 
Given user launches the application for cart page
Scenario: verify cart functionality
When user navigates to cart page
And Your Cart label is visible
Then list of added products should be visible
Scenario: remove product from cart
When user navigates to cart page
And Remove button should be visible 
And user clicks on Remove button
Then product "Sauce Labs Backpack" should be removed from cart
Scenario: verify Checkout button 
When user navigates to cart page
And Checkout button should be visible
Then user clicks the Checkout button
Scenario: verify Continue Shopping button 
When user navigates to cart page
And Continue Shopping button should be visible
Then  user clicks Continue Shopping button
And navigates to Products page "Products"



