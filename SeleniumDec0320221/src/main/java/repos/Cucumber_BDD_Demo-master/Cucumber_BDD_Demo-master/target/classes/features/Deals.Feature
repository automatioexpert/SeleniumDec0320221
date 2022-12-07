Feature: Free CRM Deal Data creation

#Data driven using data tables where test data is immediately provided after the step
Scenario: Free CRM Create a New deal scenario

Given user is already on login page
When title of login page is Free CRM
Then user enters username and password
| ananda | 123456 |

Then user clicks the login button
Then the user is on home page
Then user moves to new deals page
Then user enters deal details and saves it
| test deal | 1000 | 100 | 50 |

Then close the browser
