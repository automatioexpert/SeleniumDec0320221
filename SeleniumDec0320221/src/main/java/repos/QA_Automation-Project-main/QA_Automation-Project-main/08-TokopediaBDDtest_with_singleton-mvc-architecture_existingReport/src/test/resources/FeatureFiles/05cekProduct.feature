Feature: Cek Product

Scenario: Cek Product Name
	When User search a product "iphone"
	And User send enter query
	Then User see all product "iphone"