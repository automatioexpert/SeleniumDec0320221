
@tag
Feature: Open New Account
	I want to Open new Account 
	
  Scenario: Validate Create New Account
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		When I click on "Open New Account"
    Then Page title should come "ParaBank | Open Account"	