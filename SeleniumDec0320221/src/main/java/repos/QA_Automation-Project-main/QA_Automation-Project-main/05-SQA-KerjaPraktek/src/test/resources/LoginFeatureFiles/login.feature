Feature: login Test

	Scenario: Valid Login
		Given User on the login page
		When User fill the username "developer"
		And User fill the password "23"
		And User click the login button
		Then User get login validate "Welcome to Tele Kita"
	
	Scenario Outline: InValid Login
		Given User on the login page
		When User fill the username <username>
		And User fill the password <password>
		And User click the login button
		Then User get alert or notification "Username atau password tidak ditemukan atau akun anda tidak aktif"
		Examples:
		|	username		|	password	|
		| "developer"	| "2"				|
		| "DEVELOPER"	|	"23"			|
		| ""					| ""				|