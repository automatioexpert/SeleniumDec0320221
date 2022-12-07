Feature: Transfer Funds
	I want to transfer funds from one account to other account

  Scenario Outline: Transfer Funds
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		When I click on "Transfer Funds"
		And I select account "<FromAccount>" in from account field
		And I select account "<ToAccount>" in to account field
		And I enter amount as "<Ammount>" in amount field
		And I click on transfer funds button
		Then Transfer is sucessfull message should come
		Examples:
		|FromAccount|ToAccount|Ammount|
		|12345|12456|10|
		|12567|12678|10|
		|12789|13011|10|
		|13344|15564|10|
				
