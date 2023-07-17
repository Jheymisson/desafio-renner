#language: en

@registration
@regression
Feature: Registration the new users

  @smoke
  @registrationUserSuccess
  Scenario: Completing the new user registration
    Given I click the SignUpLogin button in the Home menu
    And I enter the Name and Email in the Signup form
    And I click the Signup button
    Then I am redirected to the new user completion page
    When I provide additional information and complete the registration
    And I click finish registration
