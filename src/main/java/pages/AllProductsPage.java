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
    private By continueShoppingBtn = By.cssSelector("#cartModal button.btn-success");
    private By addProductMultipleTimes = By.xpath("(//a[contains(@class,\"add-to-cart\")])[1]");

    private By searchedProductsWord = By.cssSelector("h2[class=\"title text-center\"]");

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

    public boolean checkOnAllSearchResults(String searchedKeyWord) {

        List<WebElement> productsTitles = locateElements(searchedProductsTitles);

        for (int i = 0; i < productsTitles.size(); i++) {
            String searchedProductName = productsTitles.get(i).getText();

            if (searchedProductName.toLowerCase().contains(searchedKeyWord.toLowerCase()) == false) {
                return false;
            }
        }

        return true;
    }

    public ViewCartPage addProductsToCart() {
        scrollVertically(600);
        clickOnElement(addProductToCart);
        modalActionsToClick(viewCartBtn);
        return new ViewCartPage(driver);
    }

    public ViewCartPage addProductsMultipleTimesToCart(int addToCartNumber) {
        scrollVertically(600);
        for (int i = 1; i < addToCartNumber; i++) {
            clickOnElement(addProductMultipleTimes);
            modalActionsToClick(continueShoppingBtn);
        }
        clickOnElement(addProductMultipleTimes);
        modalActionsToClick(viewCartBtn);
        return new ViewCartPage(driver);
    }

    public String clickOnEnterFromKeyboardToViewSearch (String searchedKeyWord){

        typeTextInField(searchField, searchedKeyWord);
        //clickOnElement(submitSearchBtn);
        pressEnterFromKeyboard(searchField);
        return getTextOfWebElement(searchedProductsWord);
    }

}




