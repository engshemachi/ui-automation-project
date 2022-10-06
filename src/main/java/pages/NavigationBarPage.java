package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarPage extends BasePage {

    public NavigationBarPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private By productsBtn = By.cssSelector("header a[href=\"/products\"]");
    private By cartBtn = By.cssSelector("header a[href=\"/view_cart\"]");

    //Operations
    public AllProductsPage clickOnProductsBtn (){

        clickOnElement(productsBtn);
        return new AllProductsPage(driver) ;
    }

    public ViewCartPage clickOnCartBtn () {

        clickOnElement(cartBtn);
        return new ViewCartPage(driver);
    }
}

