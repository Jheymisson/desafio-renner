package pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import pages.viewers.MessagesViewPage;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    private WebElement mrRadioElement;

    @FindBy(id = "id_gender2")
    private WebElement mrsRadioElement;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "days")
    private WebElement selectDay;

    @FindBy(id = "months")
    private WebElement selectMonth;

    @FindBy(id = "years")
    private WebElement selectYear;

    @FindBy(id = "newsletter")
    private WebElement checkboxNewsletter;

    @FindBy(id = "optin")
    private WebElement checkboxSpecialOffers;

    // Address information section elements
    @FindBy(id = "first_name")
    private WebElement inputFirstName;

    @FindBy(id = "last_name")
    private WebElement inputLastName;

    @FindBy(id = "company")
    private WebElement inputCompany;

    @FindBy(id = "address1")
    private WebElement inputAddress1;

    @FindBy(id = "address2")
    private WebElement inputAddress2;

    @FindBy(id = "country")
    private WebElement selectCountry;

    @FindBy(id = "state")
    private WebElement inputState;

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "zipcode")
    private WebElement inputZipcode;

    @FindBy(id = "mobile_number")
    private WebElement inputMobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement buttonCreateAccount;


    public void selectMrRadioElement() {
        mrRadioElement.click();
    }

    public void selectMrsRadioElement() {
        mrsRadioElement.click();
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        Select dayDropdown = new Select(selectDay);
        dayDropdown.selectByVisibleText(day);

        Select monthDropdown = new Select(selectMonth);
        monthDropdown.selectByVisibleText(month);

        Select yearDropdown = new Select(selectYear);
        yearDropdown.selectByVisibleText(year);
    }

    public void checkNewsletter() {
        checkboxNewsletter.click();
    }

    public void checkSpecialOffers() {
        checkboxSpecialOffers.click();
    }

    public void enterFirstName() {
        Faker faker = new Faker();
        String randomFirstName = faker.name().firstName();
        inputFirstName.sendKeys(randomFirstName);
    }

    public void enterLastName() {
        Faker faker = new Faker();
        String randomLastName = faker.name().lastName();
        inputLastName.sendKeys(randomLastName);
    }

    public void enterCompany() {
        Faker faker = new Faker();
        String randomCompany = faker.company().name();
        inputCompany.sendKeys(randomCompany);
    }

    public void enterAddress1() {
        Faker faker = new Faker();
        String randomAddress1 = faker.address().streetAddress();
        inputAddress1.sendKeys(randomAddress1);
    }

    public void enterAddress2() {
        Faker faker = new Faker();
        String randomAddress2 = faker.address().secondaryAddress();
        inputAddress2.sendKeys(randomAddress2);
    }

    public void selectCountry(String country) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", selectCountry);
        Select countryDropdown = new Select(selectCountry);
        countryDropdown.selectByVisibleText(country);
    }

    public void enterState(String state) {
        inputState.sendKeys(state);
    }

    public void enterCity(String city) {
        inputCity.sendKeys(city);
    }

    public void enterZipcode() {
        Faker faker = new Faker();
        String randomZipcode = faker.address().zipCode();
        inputZipcode.sendKeys(randomZipcode);
    }

    public void enterMobileNumber() {
        Faker faker = new Faker();
        String randomMobileNumber = faker.phoneNumber().cellPhone();
        inputMobileNumber.sendKeys(randomMobileNumber);
    }

    public MessagesViewPage clickCreateAccount(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buttonCreateAccount);
        buttonCreateAccount.click();
        return new MessagesViewPage(driver);
    }
}
