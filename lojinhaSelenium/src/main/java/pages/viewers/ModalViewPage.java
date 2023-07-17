package pages.viewers;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalViewPage extends BasePage {

    public ModalViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href=\"/view_cart\"]")
    private WebElement linkViewCart;


}
