#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@louginout
Feature: User Login and Logout

@loginout
Scenario Outline: User successfully Login with Valid Credentials
Given User is on the home page
When User clicks the login button, nevigates to login page
And User enters valid <username> and <password>
Then User successfully login
When User clicks the logout button
Then User successfully Logout

Examples:
    | username  | password |
    | "hugotest" | "N17dNE^QpEz3HdfA" |


