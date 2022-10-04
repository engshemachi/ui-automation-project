package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllProductsPage extends BasePage {

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private By searchField = By.id("search_product");
    private By submitSearchBtn = By.id("submit_search");
    private By searchedProductsTitles = By.cssSelector(".productinfo p");
    private By addProductToCart = By.xpath("(//a[contains(@class,\"add-to-cart\")])[3]");
    private By viewCartBtn = By.cssSelector(".text-center a[href=\"/view_cart\"]");


    //Operations
    public void typeSearchKeyword(String searchedKeyWord) {

        typeTextInField(searchField, searchedKeyWord);
        clickOnElement(submitSearchBtn);
    }

    public boolean checkOnFirstProductInSearchResults(String searchedKeyWord) {

        List<WebElement> productsTitles = locateElements(searchedProductsTitles);
        String firstSearchedProductName = productsTitles.get(0).getText();

        if (firstSearchedProductName.equalsIgnoreCase(searchedKeyWord) == false) {
            return false;
        } else {
            return true;
        }
    }

    public ViewCartPage addProductsToCart() {
        scrollVertically(500);
        clickOnElement(addProductToCart);
        modalActionsToClick(viewCartBtn);
        return new ViewCartPage(driver);
    }
}




