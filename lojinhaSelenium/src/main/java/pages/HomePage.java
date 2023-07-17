package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.shop-menu > ul > li:nth-child(4) > a")
    protected WebElement btnSignInLogIn;

    public SignUpLogInPage clickBtnSignIn(){
        btnSignInLogIn.click();
        return new SignUpLogInPage(driver);
    }

}
