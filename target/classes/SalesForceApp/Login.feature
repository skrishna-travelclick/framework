@login @all @user
Feature: Test Login

Scenario Outline: Login Success and Failure
	Given I navigate to the insite application
	When I try to login with '<type>' credentials
	Then I should see that I logged in '<status>'
	
Examples:
	| type		| status	     |	
	| valid		| successfully   |