package br.com.loja.steps;

import br.com.loja.utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.SignUpLogInPage;
import pages.viewers.MessagesViewPage;
import pages.viewers.SelectProductsViewPage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HomeSteps {

    private HomePage homePage = new HomePage(BaseTest.getDriver());
    private SignUpLogInPage signUpLogInPage;
    private SelectProductsViewPage selectProductsViewPage;
    private CartPage cartPage;
    private MessagesViewPage messagesViewPage;

    @Given("I perform login to the QA store")
    public void performLoginToQAStore() {
        homePage = new HomePage(BaseTest.getDriver());
        signUpLogInPage = homePage.clickBtnSignIn();
        signUpLogInPage.typeEmailLogIn("isobel.connelly@yahoo.com");
        signUpLogInPage.typePasswordLogIn("Teste@qa!99");
        selectProductsViewPage = signUpLogInPage.clickBtnLogInSelectProductsViewPage();
    }

    @When("I select products {string}, {string} and {string} on the Home page")
    public void selectProductsOnHomePage(String item1, String item2, String item3) {
        Map<String, Integer> productsWithQuantities = new HashMap<>();
        productsWithQuantities.put(item1, 3);
        productsWithQuantities.put(item2, 2);
        productsWithQuantities.put(item3, 1);

        selectProductsViewPage.selectProducts(productsWithQuantities);
    }


    @When("I validate the products in the cart with {string}, {string} and {string}")
    public void validateProductsInCart(String item1, String item2, String item3) {
        cartPage = selectProductsViewPage.clickViewCart();
        List<String> products = Arrays.asList(item1, item2, item3);
        for (String product : products) {
            boolean isProductInCart = cartPage.isProductInCart(product);
            assertTrue(isProductInCart, "Product '" + product + "' is not in the cart.");
        }
        cartPage.clickButtonChecout();
    }


    @Then("I validate my address details")
    public void validateAddressDetails() {
        String expectedFullName = "Mr. Noriko Ernser";
        List<String> expectedAddressLines = Arrays.asList("Zulauf, Harris and Hamill", "508 Jeremy Curve", "Apt. 711");
        String expectedCityStatePostcode = "PirouOQa Seila 55232";
        String expectedCountry = "Canada";
        String expectedPhone = "1-340-214-8546";

        String actualFullName = cartPage.getFullName();
        List<String> actualAddressLines = cartPage.getAddressLines();
        String actualCityStatePostcode = cartPage.getCityStatePostcode();
        String actualCountry = cartPage.getCountry();
        String actualPhone = cartPage.getPhone();

        assertEquals(expectedFullName, actualFullName, "Full name mismatch");
        assertEquals(expectedAddressLines, actualAddressLines, "Address lines mismatch");
        assertEquals(expectedCityStatePostcode, actualCityStatePostcode, "City, state, and postcode mismatch");
        assertEquals(expectedCountry, actualCountry, "Country mismatch");
        assertEquals(expectedPhone, actualPhone, "Phone mismatch");
    }



    @When("I go to the payment screen")
    public void goToPaymentScreen() {
        cartPage.clickButtonChecout();
        //cartPage.clickDismissButton();
        cartPage.navigateToPaymentPage();
    }

    @When("I enter my card details")
    public void enterCardDetails() {
        cartPage.enterNameOnCard();
        cartPage.enterCardNumber();
        cartPage.enterCVC();
        cartPage.enterExpiryMonth();
        cartPage.enterExpiryYear();
    }


    @When("I click the confirm button")
    public void clickConfirmButton() {
        messagesViewPage = cartPage.clickButtonPay();
    }

    @Then("the title {string} and text {string} are displayed")
    public void verifyTitleAndText(String titleSuccess, String textSuccess) {
        String title = messagesViewPage.verifyTitleRegistrationUserSuccess();
        String text = messagesViewPage.verifyTextRegistrationUserSuccess();

        assertEquals(titleSuccess, title, "O título não corresponde ao esperado");
        assertEquals(textSuccess, text, "O texto não corresponde ao esperado");
    }


}
