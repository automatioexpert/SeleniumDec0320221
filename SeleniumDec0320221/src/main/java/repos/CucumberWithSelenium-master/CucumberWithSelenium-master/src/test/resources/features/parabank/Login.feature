Feature: Parabank Login feature
  I want to test parabank login functionality

  Scenario: Validate Login
    Given Browser is  invoked
    And navigate to URL "http://parabank.parasoft.com/parabank/index.htm"
    When I enter username as "john"
    And I enter password as "demo"
    And I click on submit button
    Then Page title should come "ParaBank | Accounts Overview"
   
  @trial 
	Scenario: Validate Create New Account
		Given Browser is  invoked
		And navigate to URL "http://parabank.parasoft.com/parabank/index.htm"
		When I enter username as "john"
		And I enter password as "demo"
		And I click on submit button
		And I click on "Open New Account"
    Then Page title should come "ParaBank | Open Account"
    


