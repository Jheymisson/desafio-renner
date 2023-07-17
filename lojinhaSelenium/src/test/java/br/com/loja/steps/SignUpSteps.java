package br.com.loja.steps;

import br.com.loja.utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignUpLogInPage;
import pages.viewers.MessagesViewPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.enums.UrlsSite.URL_SIGNUP_LOGIN;

public class SignUpSteps {

    private HomePage homePage = new HomePage(BaseTest.getDriver());
    private SignUpLogInPage signUpPage;
    private RegistrationPage registrationPage;
    private MessagesViewPage messagesViewPage;

    @Given("I click the SignUpLogin button in the Home menu")
    public void clickSignupLoginButton() {
        signUpPage = homePage.clickBtnSignIn();
    }

    @And("I enter the Name and Email in the Signup form")
    public void enterNameAndEmail() {
        signUpPage.typeNameUserSignUp();
        signUpPage.typeEmailSignUp();
    }

    @And("I click the Signup button")
    public void clickSignupButton() {
        registrationPage = signUpPage.clickBtnSignUp();
    }

    @Then("I am redirected to the new user completion page")
    public void verifyRedirectToCompletionPage() {
        String urlAtual = BaseTest.getDriver().getCurrentUrl();
        assertEquals(URL_SIGNUP_LOGIN, urlAtual, "A URL atual não corresponde à URL esperada");
    }

    @When("I provide additional information and complete the registration")
    public void provideAdditionalInformation() {
        registrationPage.selectMrRadioElement();
        registrationPage.enterPassword("Teste@qa!99");
        registrationPage.selectDateOfBirth("1", "January", "2000");
        registrationPage.enterFirstName();
        registrationPage.enterLastName();
        registrationPage.enterCompany();
        registrationPage.enterAddress1();
        registrationPage.enterAddress2();
        registrationPage.selectCountry("Canada");
        registrationPage.enterState("Seila");
        registrationPage.enterCity("PirouOQa");
        registrationPage.enterZipcode();
        registrationPage.enterMobileNumber();
    }

    @And("I click finish registration")
    public void IClickFinishRegistration() {
        messagesViewPage = registrationPage.clickCreateAccount();
        String title = messagesViewPage.verifyTitleRegistrationUserSuccess();
        String text = messagesViewPage.verifyTextRegistrationUserSuccess();

        assertEquals("ACCOUNT CREATED!", title, "O título não corresponde ao esperado");
        assertEquals("Congratulations! Your new account has been successfully created!", text, "O texto não corresponde ao esperado");
    }


}
