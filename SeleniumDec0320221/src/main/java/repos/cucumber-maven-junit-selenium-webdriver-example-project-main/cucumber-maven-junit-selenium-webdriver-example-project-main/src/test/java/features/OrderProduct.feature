Feature: Place order functinality validation

@GreenKartFunctionalTest
Scenario: Order one product
Given Initialize the browser with specific sites home page
When Place order with "Brocolli" product in cart
Then Cart page populated with all information
And Order should be placed via order page 