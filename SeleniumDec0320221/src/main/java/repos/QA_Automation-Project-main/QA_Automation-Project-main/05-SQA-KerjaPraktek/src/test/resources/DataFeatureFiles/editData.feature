Feature: Edit Data Test

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