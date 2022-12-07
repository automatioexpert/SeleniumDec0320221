Feature: Register New User
	This feature file contains test cases to register new Users
	
	Scenario: Validate Register new User is working
		Given Navigate to Parabank with url as "http://parabank.parasoft.com/parabank/index.htm"
	  When I click on "Register"
	  And fills the form with data as below
	  |FirstName|Akash|
	  |LastName|tyagi|
	  And I click on Register Button
	  Then New User is created and User is immediatly logged in
	  And New user is able to login successfully again after logout
