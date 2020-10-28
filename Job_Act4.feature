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
@Job_Act4
Feature: Using Examples table to post a job

  Scenario Outline: Rewrite activity 3 using a Scenario Outline and Examples table to post a job
    Given Open browser with Alchemy Jobs site
    When Go to Post a Job page
    Then Enter the "<email>", "<jobTitle>", "<location>", "<description>", "<applicationEmail>", "<companyName>" details and click on the Preview button
    Then Click submit
    Then Go to the Jobs page
    And Confirm job listing "<jobTitle1>" is shown on page
    And Close Browser

Examples: 
      | email | jobTitle | location | description | applicationEmail | companyName | jobTitle1 |
      | uname02@gmail.com | Tester 01 | Hyd | This is test job | uname02@gmail.com | IBM India Pvt. Ltd. | Tester 01 |
      | uname03@gmail.com | Tester 02 | Bangalore | This is test job | uname03@gmail.com | IBM India Pvt. Ltd. | Tester 02 |