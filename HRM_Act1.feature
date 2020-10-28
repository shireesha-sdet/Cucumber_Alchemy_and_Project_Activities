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
@HRM_Act1
Feature: Creating a job vacancy
  
Scenario: To create a job vacancy for “DevOps Engineer”
    Given Open the OrangeHRM​ page and login with credentials provided
    When Navigate to the Recruitment page
    Then Click on the Vacancies menu item to navigate to the vacancies page
    And Click on the Add button to navigate to the Add Job Vacancy form
    Then Fill out the necessary details
    And Click the “Save” button to save the vacancy
		Then Verify that the vacancy was created    
    And Close Browser	

  