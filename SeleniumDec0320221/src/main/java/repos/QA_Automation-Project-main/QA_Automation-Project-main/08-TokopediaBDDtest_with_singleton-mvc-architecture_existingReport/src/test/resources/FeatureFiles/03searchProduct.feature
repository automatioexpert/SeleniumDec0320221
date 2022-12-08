Feature: Search Product

Scenario: Search product
	When User search a product "iphone"
	And User send enter query
	Then User get the product display "iphone"