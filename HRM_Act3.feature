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
@HRM_Act3
Feature: Add multiple employees
 
  Scenario Outline: Add multiple employees using an the Examples table
    Given Open the OrangeHRM​ page and login with the given credentials
    When Find the PIM option in the menu and click it
    Then Click the Add button to add a new Employee
    And Make sure the Create Login Details checkbox is checked
    Then Fill in the "<firstName>", "<lastName>", "<userName>", "<password>", "<confirmPassword>" and click Save
    Then Verify that the employees have been created "<employeeName>"
    And Close Browser
    
Examples: 
      | firstName | lastName | userName | password | confirmPassword | employeeName | 
      | SS1 | SB1 | SS1SB1 | P@ssw0rd | P@ssw0rd | SS1 SB1 |
      | SS2 | SB2 | SS2SB2 | P@ssw0rd | P@ssw0rd | SS2 SB2 |
