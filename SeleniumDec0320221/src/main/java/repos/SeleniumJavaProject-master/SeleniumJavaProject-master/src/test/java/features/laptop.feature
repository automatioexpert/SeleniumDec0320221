Feature: Find product and go comments into Application




Scenario Outline: Positive testing validating Homepage
Given Initialize the browser with chrome
And Navigate to "https://www.hepsiburada.com/" Site
When user enter product searchbox
And user click first product 
Then Verify preminum text is checked
  


    
Scenario Outline: Positive testing validating Productpage
Given Continue from homepage
When the selected product is printed
And Seller name is printed
Then Verify comment button is displayed