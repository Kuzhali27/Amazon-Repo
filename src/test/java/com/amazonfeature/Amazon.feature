
Feature: It Is An E Com Website
Scenario: HomePage

Given user Launch The Application

When user Select An Option From Dropdown
And user Search The Relevant Option
Then user Clicks On The Selected Option

Scenario: Product Page
When user Fetch The Product Title
And user Select the Fetched Product Title
Then user Cilcks On The Product and Get The Window

Scenario: Next Page
When user Compares The Selected Product Title
Then user Clicks on Addtocart

Scenario: Cart Page
When user Capture The Page
Then user Clicks On Gotocart

Scenario: Purchase Page
When Compare The Purchase Product Title
Then Close The Current Tab


  