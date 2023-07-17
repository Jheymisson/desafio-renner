#language: en

@home
@regression
Feature: Home Screen

  Background:
    Given I perform login to the QA store

  @smoke
  @selectProductsHomeScreen
  Scenario Outline: Select products
    When I select products "<item1>", "<item2>" and "<item3>" on the Home page
    And I validate the products in the cart with "Stylish Dress", "<item2>" and "<item3>"
    Then I validate my address details
    When I go to the payment screen
    And I enter my card details
    And I click the confirm button
    Then the title "<titleSuccess>" and text "<textSuccess>" are displayed

      Examples: Data
      | item1         | item2                                      | item3            | titleSuccess  | textSuccess   |
      | Stylish Dress | Beautiful Peacock Blue Cotton Linen Saree  | Men Tshirt       | ORDER PLACED! | Congratulations! Your order has been confirmed! |