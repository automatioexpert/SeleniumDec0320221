Feature: Open New Account Feature
  I want to open new account

  Scenario: Open New Account
		Given Login in to Parabank url as "http://parabank.parasoft.com/parabank/index.htm" username as "john" passowrd as "demo"
		And Fetch Balance of Account "13344"
		When I click on "Open New Account"
    And I select account type as "SAVINGS"
    And I select the account number as "13344"
    And I click on Open New Account Button
    Then Account Opened  message should come
    And New Account Number is created
    And New Account is displayed under account Overview table
    And New Account should have ammount as "$100.00"
		And Original Account ammount should get deducted by "100" from account "13344"
  