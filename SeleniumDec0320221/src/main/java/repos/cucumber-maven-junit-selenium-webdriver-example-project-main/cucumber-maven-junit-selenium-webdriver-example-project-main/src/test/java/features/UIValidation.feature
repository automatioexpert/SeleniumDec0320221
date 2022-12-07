Feature: UI validation

@GreenKartUITest
Scenario: Home page UI validation
Given Initialize the browser with specific site
When Browse to home page
Then Home page is populated with all of its elements

@GreenKartUITest
Scenario: Cart page UI validation
Given Initialize the browser with specific site
When Navigate to cart page after adding one product 
Then Cart page is populated with all of its elements
And Selected product information should be the same as home page