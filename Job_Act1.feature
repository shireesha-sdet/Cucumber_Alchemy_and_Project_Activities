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
@Job_Act1
Feature: Create New User
  I want to use this template for my feature file

  
  Scenario: Visit the site’s backend and create a new user
    Given Open a browser
    When Navigate to Alchemy Jobs and log in
    Then Locate the left hand menu and click the menu item that says Users
    And Locate the Add New button and click it
    Then Fill in the necessary details
    And Click the Add New User button
    Then Verify that the user was created
    And Close the browser

  
