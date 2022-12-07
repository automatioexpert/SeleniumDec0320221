Feature: Free CRM Login Feature

#Data driven without Examples keyword
#Scenario: Free CRM Login Test Feature
#
#Given user is already on login page
#When title of login page is Free CRM
#Then user enters "ananda" and "12345"
#Then user clicks the login button
#Then the user is on home page
#Then close the browser


#Data driven with Examples Keyword
Scenario Outline: Free CRM Login Test Feature

Given user is already on login page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks the login button
Then the user is on home page
Then close the browser

Examples:
	|username|password|
	|ananda	 |123456  |
	|test    |abc	  |

#Scenario: User is able to create new contact

#Given user is already on home page
#When user mouse over contacts link
#Then user clicks New contact link
#Then user enters firstname and lastname
#Then user clicks on save button
#Then verify new contact created