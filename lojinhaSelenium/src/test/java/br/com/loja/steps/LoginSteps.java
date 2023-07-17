package br.com.loja.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignUpLogInPage;
import br.com.loja.utils.BaseTest;
import pages.viewers.MessagesViewPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private HomePage homePage = new HomePage(BaseTest.getDriver());
    private SignUpLogInPage signUpLogInPage;
    private MessagesViewPage messagesViewPage;

    @Given("I am on the login screen")
    public void iAmOnTheLoginScreen() {
        homePage = new HomePage(BaseTest.getDriver());
        signUpLogInPage = homePage.clickBtnSignIn();
    }

    @When("I enter {string} and {string}")
    public void iEnterCredentials(String email, String password) {
        signUpLogInPage.typeEmailLogIn(email);
        signUpLogInPage.typePasswordLogIn(password);
    }

    @When("I click the Sign In button")
    public void iClickSignInButton() {
        messagesViewPage = signUpLogInPage.clickBtnLogInMessagesViewPage();
    }

    @Then("I validate the user name {string}")
    public void iValidateUserName(String expectedUserName) {
        String username = messagesViewPage.verifyTextLoggerUserSuccess();
        assertEquals(expectedUserName, username, "O título não corresponde ao esperado");

    }

}
