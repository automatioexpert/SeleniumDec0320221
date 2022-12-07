Feature: Account Overview
	This feature file contains test cases related to account overview page of parabank
	
	
Scenario: Check account overview page table total amount displayed of sum of all the accounts
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
	  When I click on "Account Overview"
	  Then Account Overview page is displayed
	  And Account Overview Table is displayed
	  And Sum of all the accounts is equal to total amount displayed at the bottom of the table
		
