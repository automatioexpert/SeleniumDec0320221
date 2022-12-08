Feature: Cek Price Product

Scenario: Cek Product Name
	When User search a product "iphone"
	And User send enter query
	Then User see all product price is not null 0