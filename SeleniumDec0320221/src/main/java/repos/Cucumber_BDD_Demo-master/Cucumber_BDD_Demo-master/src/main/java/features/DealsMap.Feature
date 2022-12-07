Feature: Free CRM Deal Data creation with Map

#Data driven using data tables with Maps where test data is immediately provided after the step
Scenario: Free CRM Create a New deal scenario

Given user is already on login page
When title of login page is Free CRM
Then user enters username and password
| username | password |
| ananda | 123456 |

Then user clicks the login button
Then the user is on home page
Then user moves to new deals page
Then user enters deal details and saves it
| title		 | amount | probability | commission |
| test deal1 | 1000 | 100 | 50 |
| test deal2 | 2000 | 80 | 75 |
| test deal3 | 3000 | 60 | 25 |

Then close the browser