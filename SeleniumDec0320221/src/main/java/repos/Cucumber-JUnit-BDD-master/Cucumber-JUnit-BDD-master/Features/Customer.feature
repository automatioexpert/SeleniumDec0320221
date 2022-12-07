
@tag
Feature: Customers
	In order to perform a sucessful add customer
	As a user
	I want to add new customer
	
	In order to perfomr a successful customer serach
	As a User
	I want to serach customer by emailID
	
	In ordert to perform a successful customer serach
	As a User
	I want to serach customer by First name & Last Name
  
  @tag1
  Scenario: Add New Cusotmer
    Given User Lanuch Chrome Browser
		When User Open URL "http://admin-demo.nopcommerce.com/login"
		And User Enter Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login button
		Then User can view Dashboard
		When User click on customers Menu
		And Click on customers Menu Item
		And Click on Add new button
		Then User can view Add new customer page
		When User enter customer info
		And Click on Save button
		Then User can view confirmation message "The new customer has been added successfully"
		And Close Browser
		
	@tag2
	Scenario: Search Cusotmer By EmailID
	  Given User Lanuch Chrome Browser
		When User Open URL "http://admin-demo.nopcommerce.com/login"
		And User Enter Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login button
		Then User can view Dashboard
    When User click on customers Menu
		And Click on customers Menu Item
	  And Enter customer email
	  When Click on serach button
	  Then User should found email in the serach table
	  And Close Browser
	  
	@tag3
	Scenario: Search Cusotmer By Firs Name & Last Name
	  Given User Lanuch Chrome Browser
		When User Open URL "http://admin-demo.nopcommerce.com/login"
		And User Enter Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login button
		Then User can view Dashboard
    When User click on customers Menu
		And Click on customers Menu Item
	  And Enter customer First name 
	  And Enter customer Last name
	  When Click on serach button
	  Then User should found Name in the serach table
	  And Close Browser    
