package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewCartPage extends BasePage {

    public ViewCartPage(WebDriver driver) {
        super(driver);
    }

    private By quantityOfAddedProduct = By.cssSelector(".cart_quantity button.disabled");
    private By cartInfoTable = By.cssSelector("#cart_info_table tr.cart_menu  td");

    public String getQuantityOfAddedProduct() {
        return getTextOfWebElement(quantityOfAddedProduct);
    }

    public int getNumberOfColumnsInCart (){

        List <WebElement> columnElements = locateElements(cartInfoTable);
        return columnElements.size();
    }

}
