Feature: Adactin Hotel Booking Application
@smoketest1
Scenario: Login Function
Given user Launch The Adactin App
When user Enter The Username In Inputbox
And user Enter The Password In Inputbox
Then user Click Login Button And Navigate To The Next Page
@smoketest2
Scenario: Search Hotel Functionality
When user Select The Location From Dropdown
And user Select Hotels From Dropdown
And user Select Roomtype From Dropdown
And user Select No Of Rooms From The Dropdown
And user Enter The Check In Date In Inputbox
And user Enter Check Out Date In Inputbox
And user Select Adult Per Room From Dropdown
And user Select Children Per Room From Dropdown
Then user Click The Search Button

Scenario: Hotel Details 
When user Click The Radiobutton
Then user Click The Continue Option

Scenario: Booking Hotel Functionality
When user Enters  The First Name In Inputbox
And user Enters  The Last Name In Inputbox
And user Enters  The Billing Address In Inputbox
And user Enter Credit Card Num In The Inputbox
And user Enter Credit Card Type In The Inputbox
And user Enter Expiry Date By Selecting Month And Year From Dropdown
And user Enter CVV Num In The Inputbox
Then user Click The Book Now Button

Scenario: Booking Confirmation Functionality
Then user Clicks On The My Itinerary Button

Scenario: Logout Confirmation Functionality
Then user Clicks On The Logout Button 
