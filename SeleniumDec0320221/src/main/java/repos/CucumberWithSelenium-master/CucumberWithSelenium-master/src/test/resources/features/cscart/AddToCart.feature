@add_to_cart
Feature: To check Add to cart feature

  Scenario Outline: Check Add to cart is working for Single Product
    Given I open "Chrome" Browser and browser is navigated to "http://demo.cs-cart.com/"
		And I enter text in search text box as "laptop"
		When I click on Add to Cart for "<ProductSeq>" product
		Then Product should get added in the my cart section with default quantity as 1
		Examples:
		|ProductSeq|
		|1         |
		|2         |
		|3         |
		
	Scenario Outline: Check Add to cart is working for Single Product
    Given I open "Chrome" Browser and browser is navigated to "http://demo.cs-cart.com/"
		And I enter text in search text box as "laptop"
		When I click on Add to Cart for "<ProductCode>" product
		Then Product should get added in the my cart section
		Examples:
		|ProductID |
		|F0208V084C|
		|D0210M5AN1|
		|P0222KUH4T|
	
	Scenario Outline: Check Add to cart is working for multiple Product
    Given I open "Chrome" Browser and browser is navigated to "http://demo.cs-cart.com/"
		And I enter text in search text box as "laptop"
		When I click on Add to Cart for "<ProductSeq>" product with quanity as "<Quantity>"
		Then Product should get added in the my cart section
		Examples:
		|ProductSeq|Quantity|
		|1         |2       |
		|2         |5       |
		|3         |2       | 
		

		