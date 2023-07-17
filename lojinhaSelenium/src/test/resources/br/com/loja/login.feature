#language: en

@login
@regression
Feature: Login Screen

  @smoke
  @LoginSuccess
  Scenario: Successful login
    Given I am on the login screen
    When I enter "isobel.connelly@yahoo.com" and "Teste@qa!99"
    And I click the Sign In button
    Then I validate the user name "Bertha"
