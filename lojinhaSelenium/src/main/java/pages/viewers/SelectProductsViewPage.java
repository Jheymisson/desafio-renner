package pages.viewers;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;

import java.util.List;
import java.util.Map;

public class SelectProductsViewPage extends BasePage {

    public SelectProductsViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.close-modal")
    protected WebElement btnContinuePay;

    @FindBy(css = "a[href=\"/view_cart\"]")
    private WebElement linkViewCart;

    public void selectProducts(Map<String, Integer> productsWithQuantities) {
        List<WebElement> produtos = driver.findElements(By.cssSelector("div.productinfo p"));
        List<WebElement> addToCartLinks = driver.findElements(By.cssSelector(".product-overlay a.add-to-cart"));

        for (int i = 0; i < produtos.size(); i++) {
            String nome = produtos.get(i).getText();

            if (!nome.isEmpty() && productsWithQuantities.containsKey(nome)) {
                int quantidade = productsWithQuantities.get(nome);

                if (addToCartLinks.size() > i) {
                    WebElement produto = driver.findElements(By.cssSelector(".product-image-wrapper")).get(i);
                    js.executeScript("arguments[0].scrollIntoView();", produto);

                    for (int j = 0; j < quantidade; j++) {
                        Actions actions = new Actions(driver);

                        actions.moveToElement(produto).perform();
                        js.executeScript("arguments[0].click();", addToCartLinks.get(i));

                        WebDriverWait wait = new WebDriverWait(driver, 10);

                        try {
                            wait.until(ExpectedConditions.visibilityOf(btnContinuePay));
                            btnContinuePay.click();
                        } catch (TimeoutException e) {
                            System.out.println("Timeout ao clicar no botão 'Add to Cart' para o produto: " + nome);
                        }
                    }
                } else {
                    System.out.println("O link 'Add to Cart' não está disponível para o produto: " + nome);
                }
            }
        }
    }

    public CartPage clickViewCart(){
        linkViewCart.click();
        return new CartPage(driver);
    }


}
