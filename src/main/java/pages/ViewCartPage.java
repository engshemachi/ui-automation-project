package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage extends BasePage {

    public ViewCartPage(WebDriver driver) {
        super(driver);
    }

    private By quantityOfAddedProduct = By.cssSelector(".cart_quantity button.disabled");

    public String getQuantityOfAddedProduct() {
        return getTextOfWebElement(quantityOfAddedProduct);
    }

}
