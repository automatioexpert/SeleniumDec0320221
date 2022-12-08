Feature: UserSpv Test

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
		| "deVELOPER"	|	"23"			|
		| ""					| ""				|	
		
	Scenario: Valid Upload
		Given UserSpv on the login page
		When UserSpv login with valid UserSpvname "developer" and password "23"
		And UserSpv get login validate "Welcome to Tele Kita"
		And UserSpv click ok to the validate message
		And UserSpv move to table Data
		And UserSpv move to table Upload Data
		And UserSpv import excel file from directory "C:\\Users\\ASUS\\Downloads\\customers.xlsx"
		And UserSpv click Upload file
		Then UserSpv get new data import on the page or website
		And UserSpv save the new file
		And UserSpv get measurement statement Yakin Menimpan ?
		And UserSpv click SIMPAN button
		Then UserSpv get validation message "Data Berhasil Simpan"
		
	Scenario: InValid Upload
		Given UserSpv on the login page
		When UserSpv login with valid UserSpvname "developer" and password "23"
		And UserSpv get login validate "Welcome to Tele Kita"
		And UserSpv click ok to the validate message
		And UserSpv move to table Data
		And UserSpv move to table Upload Data
		And UserSpv import excel file from directory ""
		And UserSpv click Upload file
		Then UserSpv get message "File tidak dapat dibaca/ jumlah data 0"
		And UserSpv close the validation message
		And UserSpv save the new file
		And UserSpv get measurement statement Yakin Menimpan ?
		And UserSpv click SIMPAN button
		Then UserSpv get validation message "Data Kosong"
		
		
	Scenario: Valid distribute
		Given User on the login
		When User login with valid username "developer" and password "23"
		And User get login validation "Welcome to Tele Kita"
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
		And User get login validation "Welcome to Tele Kita"
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

	Scenario Outline: Valid Edit
		Given User login with username "developer" and password "23"
		When User get login msg "Welcome to Tele Kita"
		And User click ok to the validate msg
		And User move to table_Data
		And User move to table Edit Data
		And User select the <data>
		And User update or edit the data
		And User confirm or click update button
		Then User see data changed successfully
		Examples:
		| 						data	 					|
		|"earliest data"							|
		|"data from the latest table" |

	Scenario Outline: InValid Edit
		Given User login with username "developer" and password "23"
		When User get login msg "Welcome to Tele Kita"
		And User click ok to the validate msg
		And User move to table_Data
		And User move to table Edit Data
		And User select the <data>
		And User not confirm or click close button
		Then User see data not changed
		Examples:
		| 						data	 					|
		|"earliest data"							|
		|"data from the latest table" |