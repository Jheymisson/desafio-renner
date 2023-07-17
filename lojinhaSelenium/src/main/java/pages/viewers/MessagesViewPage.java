package pages.viewers;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagesViewPage extends BasePage {

    public MessagesViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2 > b")
    protected WebElement TitleSuccess;

    @FindBy(css = "div > div > div > p:nth-child(2)")
    protected WebElement TextSuccess;

    @FindBy(css = "li a i.fa.fa-user + b")
    private WebElement loggedInUserName;

    public String verifyTitleRegistrationUserSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(TitleSuccess));
        return TitleSuccess.getText();
    }

    public String verifyTextRegistrationUserSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(TextSuccess));
        return TextSuccess.getText();
    }

    public String verifyTextLoggerUserSuccess() {
        return loggedInUserName.getText();
    }

    public String verifyTitlePaySuccess() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(TitleSuccess));
        return TitleSuccess.getText();
    }

    public String verifyTextPaySuccess() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(TextSuccess));
        return TextSuccess.getText();
    }
}
