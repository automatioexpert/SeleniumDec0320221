Feature: Bill Payment
  Feature to test bil payment
  @wip
  Scenario: Pay Bill 
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		When I click on "Bill Pay"
		And I fill Bill payment form with data as
		|name   | Akash |
		|Address| xyz|
		|city   |pune|
		|state  |MH|
		|zipCode|12313|
		|phone  |5645646|
		|Account|20115|
		|verifyAccount|20115|
		|Ammount|20|
		|FromAccount|18894|
		
	Scenario: Negative Check if any filed is left blank, Web Site throws relevant error
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		When I click on "Bill Pay"
		And I click on Send Payment button with out filling any fields
		Then below types of errors will be displayed for each field
		|name         |Payee name is required.    |
		|Address      |Address is required.       |
		|city         |City is required.          |
		|state        |State is required.         | 
		|zipCode      |Zip Code is required.      |
		|phone        |Phone number is required.  |
		|Account      |Account number is required.|
		|verifyAccount|Account number is required.|
		|Ammount      |The amount cannot be empty.|

		
