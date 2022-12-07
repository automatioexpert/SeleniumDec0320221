
@tag
Feature: Login
	In order to perform sucessful login
	As a user
	I want to enter correct username and password

	@tag1
	Scenario: Successful Login with Valid Credentials
			Given User Lanuch Chrome Browser
			When User Open URL "http://admin-demo.nopcommerce.com/login"
			And User Enter Email as "admin@yourstore.com" and Password as "admin"
			And Click on Login button
			Then Login Page Title should be "Dashboard / nopCommerce administration"
			When User Click on logout link
			Then Home Page Title should be "Your store. Login"
			And Close Browser
	@tag2		
	Scenario Outline: Login with Data Driven
	    Given User Lanuch Chrome Browser
			When User Open URL "http://admin-demo.nopcommerce.com/login"
			And User Enter Email as "<email>" and Password as "<password>"
			And Click on Login Button
			Then Login Page Title should be "Dashboard / nopCommerce administration"
			When User Click on logout link
			Then Home Page Title should be "Your store. Login"
			And Close Browser
			
			Examples: 
	      | email | password |
	      | admin@yourstore.com |    admin |
	      | admin1@yourstore.com |   admin123 | 
				