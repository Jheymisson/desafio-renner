package pages;

import com.github.javafaker.Faker;
import core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.viewers.MessagesViewPage;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tr[id^='product-'] .cart_description h4 a")
    private List<WebElement> productNameList;

    @FindBy(css = "a.check_out")
    protected WebElement btnCheckout;

    @FindBy(css = "#address_delivery .address_firstname.address_lastname")
    private WebElement fullNameElement;

    @FindBy(css = "#address_delivery .address_address1.address_address2")
    private List<WebElement> addressLinesElements;

    @FindBy(css = "#address_delivery .address_city.address_state_name.address_postcode")
    private WebElement cityStatePostcodeElement;

    @FindBy(css = "#address_delivery .address_country_name")
    private WebElement countryElement;

    @FindBy(css = "#address_delivery .address_phone")
    private WebElement phoneElement;

    @FindBy(css = "#payment-form > div:nth-child(2) > div > input")
    private WebElement nameOnCardInput;

    @FindBy(css = "#payment-form > div:nth-child(3) > div > input")
    private WebElement cardNumberInput;

    @FindBy(css = "#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input")
    private WebElement cvcInput;

    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(2) > input")
    private WebElement expiryMonthInput;

    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(3) > input")
    private WebElement expiryYearInput;

    @FindBy(css = "#submit")
    private WebElement btnPay;

    @FindBy(css = "div#dismiss-button")
    private WebElement btnDimiss;

    @FindBy(css = "div iframe#ad_iframe")
    private WebElement cssIframe;

    public boolean isProductInCart(String productName) {
        for (WebElement product : productNameList) {
            if (product.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clickButtonChecout() {
        js.executeScript("arguments[0].scrollIntoView();", btnCheckout);
        btnCheckout.click();
    }

    public void clickDismissButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement iframe = wait.until(ExpectedConditions.visibilityOf(cssIframe));
            driver.switchTo().frame(iframe);

            WebElement dismissButton = wait.until(ExpectedConditions.visibilityOf(btnDimiss));
            if (dismissButton.isDisplayed()) {
                btnDimiss.click();
            } else {
                System.out.println("Botão de fechar não está visível, não é necessário clicar");
            }

            // Retorna para o contexto padrão.
            driver.switchTo().defaultContent();
        } catch (TimeoutException e) {
            System.out.println("Botão de fechar não está visível, não é necessário clicar");
        }
    }

    public void navigateToPaymentPage() {
        String newUrl = "https://automationexercise.com/payment";
        driver.get(newUrl);
    }

    public String getFullName() {
        return fullNameElement.getText();
    }

    public List<String> getAddressLines() {
        return addressLinesElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getCityStatePostcode() {
        return cityStatePostcodeElement.getText();
    }

    public String getCountry() {
        return countryElement.getText();
    }

    public String getPhone() {
        return phoneElement.getText();
    }

    public void enterNameOnCard() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        nameOnCardInput.sendKeys(name);
    }

    public void enterCardNumber() {
        Faker faker = new Faker();
        String cardNumber = faker.business().creditCardNumber();
        cardNumberInput.sendKeys(cardNumber);
    }

    public void enterCVC() {
        Faker faker = new Faker();
        String cvc = faker.numerify("###");
        cvcInput.sendKeys(cvc);
    }

    public void enterExpiryMonth() {
        Faker faker = new Faker();
        String expiryMonth = faker.numerify("##");
        expiryMonthInput.sendKeys(expiryMonth);
    }

    public void enterExpiryYear() {
        Faker faker = new Faker();
        String expiryYear = faker.numerify("####");
        expiryYearInput.sendKeys(expiryYear);
    }

    public MessagesViewPage clickButtonPay(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnPay);
        btnPay.click();
        return new MessagesViewPage(driver);
    }



}
