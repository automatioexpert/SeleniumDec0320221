Feature: Cek Display Product

Scenario: Cek Product Display(size)
	When User search a product "iphone"
	And User send enter query
	Then User see all product display is equals 60