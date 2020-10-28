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
@Job_Act3
Feature: Posting a job using parameterization
  

 
  Scenario: Post a job using details passed from the Feature file 
    Given Open browser with Alchemy Jobs site
    When Go to Post a Job page
    Then Enter the "uname01@gmail.com", "Tester 01", "Hyd", "This is test job", "uname01@gmail.com", "IBM India Pvt. Ltd." details and click on the Preview button
    Then Click submit
    Then Go to the Jobs page
    And Confirm job listing "Tester 01" is shown on page
    And Close Browser

  