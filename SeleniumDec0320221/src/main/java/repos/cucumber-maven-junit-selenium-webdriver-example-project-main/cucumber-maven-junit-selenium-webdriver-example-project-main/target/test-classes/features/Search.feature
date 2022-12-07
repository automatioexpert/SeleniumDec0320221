Feature: Searching functionality with multiple data passing validation 

@GreenKartSearchTest
Scenario Outline: Positive search with multiple value
Given User is on home page
When User search with valid <productname>
Then Search page is populated with exact <productname>

Examples:
|productname 		|
|Brocolli			|
|Capsicum			|


@GreenKartSearchTest
Scenario Outline: Negative search with multiple value
Given User is on home page
When User search with invalid <productname>
Then Search page is populated with "no products matched" message

Examples:
|productname 		|
|Fish			    |
|Chicken		    |

@GreenKartSearchTest
Scenario: Home page UI validation
Given User is on home page
When User search with specific "ot" letters for multiple product
Then Search page is populated with multiple products which contains "ot" letters