package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCartPage extends BasePage {

    private By quantityOfAddedProduct = By.cssSelector(".cart_quantity button.disabled");

    public ViewCartPage(WebDriver driver) {
        super(driver);
    }

    public String getQuantityOfAddedProduct() {
        return getTextOfWebElement(quantityOfAddedProduct);
    }

}
