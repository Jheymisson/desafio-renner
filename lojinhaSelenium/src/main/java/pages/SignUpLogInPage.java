package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;
import pages.viewers.MessagesViewPage;
import pages.viewers.SelectProductsViewPage;


public class SignUpLogInPage extends BasePage {

    public SignUpLogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[data-qa=login-email]")
    protected WebElement inputEmailLogIn;

    @FindBy(css = "input[data-qa=login-password]")
    protected WebElement inputPassLogIn;

    @FindBy(css = "button[data-qa=login-button]")
    protected WebElement inputBtnLogIn;

    @FindBy(css = "input[data-qa='signup-name']")
    protected WebElement nameUserSignUp;

    @FindBy(css = "input[data-qa='signup-email']")
    protected WebElement emailUserSignUp;

    @FindBy(css = "button[data-qa='signup-button']")
    protected WebElement inputBtnSignUp;

    public void typeEmailLogIn(String email){
        inputEmailLogIn.sendKeys(email);
    }

    public void typePasswordLogIn(String pass){
        inputPassLogIn.sendKeys(pass);
    }

    public MessagesViewPage clickBtnLogInMessagesViewPage(){
        inputBtnLogIn.click();
        return new MessagesViewPage(driver);
    }

    public SelectProductsViewPage clickBtnLogInSelectProductsViewPage(){
        inputBtnLogIn.click();
        return new SelectProductsViewPage(driver);
    }

    public void typeEmailSignUp(){
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();
        emailUserSignUp.sendKeys(randomEmail);
    }

    public void typeNameUserSignUp(){
        Faker faker = new Faker();
        String randomName = faker.name().firstName();
        nameUserSignUp.sendKeys(randomName);
    }

    public RegistrationPage clickBtnSignUp(){
        inputBtnSignUp.click();
        return new RegistrationPage(driver);
    }


}
