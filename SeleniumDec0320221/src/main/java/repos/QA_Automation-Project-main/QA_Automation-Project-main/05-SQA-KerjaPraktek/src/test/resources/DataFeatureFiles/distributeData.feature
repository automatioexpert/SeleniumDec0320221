Feature: Distribute Data Test

	Scenario: Valid distribute
		Given User on the login
		When User login with valid username "developer" and password "23"
		And User get login validate "Welcome to Tele Kita"
		And User click ok to the validate message
		And User move to table Data
		And User move to table Distribute Data
		And User select the agent "true"
		And User fill the quantity "10"
		And User select the New status
		And User push the distribute button
		Then User get validation message "Apa Yakin Distribusi ?"
		
	Scenario Outline: InValid distribute
		Given User on the login
		When User login with valid username "developer" and password "23"
		And User get login validate "Welcome to Tele Kita"
		And User click ok to the validate message
		And User move to table Data
		And User move to table Distribute Data
		And User select the agent <agent boolean>
		And User fill the quantity <quantity>
		And User select the New status
		And User push the distribute button
		Then User get validation message <message>
		Examples:
		|		agent boolean			|	quantity	|							message										|
		| 		"false"					| "2"				|	"Pilih User yang akan didistribusikan"|	
		| 		"true"					|	""				|	"Jumlah tidak boleh Kosong"						|
		|			"false"					| ""				|	"Pilih User yang akan didistribusikan"|