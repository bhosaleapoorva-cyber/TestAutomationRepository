@tag1
Feature: I want to purchase the products from an ecommerce website


Background: 
Given I landed on ecommerce page


@Regression
Scenario Outline:To add the products into the shopping cart 
Given Logged in with username <username> and password <password> 
When I add product <productname> to the cart
Then complete the purchase of <productname>
Examples:
|username			 |		password   | productname|
|apurvatest@gmail.com|		Elixir123! | ZARA COAT 3|





Scenario Outline:To perform an invalid login using the wrong credentials
Given Logged in with username <username> and password <password> in the 
When submit button is clicked 
Then verify the invalid credential message "Invalid username and password"

Examples:
|username			 |		password   |
|apurvatest@gmail.com|		Eliyxir123!|
|apurvatest2@gmail.com|		Eliyxir123!|