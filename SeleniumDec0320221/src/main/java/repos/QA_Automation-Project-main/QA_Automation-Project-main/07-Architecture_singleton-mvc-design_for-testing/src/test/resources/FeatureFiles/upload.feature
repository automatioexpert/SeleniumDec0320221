Feature: Upload Data Test

	Scenario: Valid Upload
#		Given User access the URL sqa peluang kerjaku
		When User click ok to the validation message
		And User move to data table and then upload data table
		And User import the excel file from directory
		And User click upload button and then get new data on the page equals with data from excel file
		And User save the data and validate the message
		Then User get validation msg "Data Berhasil Simpan"
		
	Scenario: InValid Upload
#		Given User access the URL sqa peluang kerjaku
		When User click ok to the validation message
		And User move to data table and then upload data table
		And User doesnt import any excel file format
		And User click upload button and then get alert "File tidak dapat dibaca/ jumlah data 0"
		And User save the data and validate the message
		Then User get alert msg "Data Kosong"