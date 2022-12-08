Feature: User Supervisor

	Scenario Outline: Invalid Login
		Given User access the URL sqa peluang kerjaku
		When User login with invalid <username> and <password>
		And User click submit
		Then User get alert
	Examples:
		|	username		|	password	|
		| "developer"	| "2"				|
		| "deVELOPEER"|	"23"			|
		| ""					| ""				|
		
	Scenario: Valid Login
		Given User access the URL sqa peluang kerjaku
		When User login with valid username and password
		And User click submit
		Then User get notification