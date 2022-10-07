package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.NavigationBarPage;

public class ProductsTests extends BaseTests {

    @Test
    public void testVisibilityOfFirstELement() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        AllProductsPage allProductsPage = navigationBarPage.clickOnProductsBtn();
        allProductsPage.typeSearchKeyword("winter top");
        Assert.assertTrue(allProductsPage.checkOnFirstProductInSearchResults("winter top"), "First Item doesn't match search keyword");
    }

    @Test
public void testAllSearchResults () {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        AllProductsPage allProductsPage = navigationBarPage.clickOnProductsBtn();
        allProductsPage.typeSearchKeyword("White");
        Assert.assertTrue(allProductsPage.checkOnAllSearchResults("White"), "Searched Products doesn't match the search keyword");

    }

    @Test
    public void testEnterFromKeyboard () {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        AllProductsPage allProductsPage = navigationBarPage.clickOnProductsBtn();
        Assert.assertEquals(allProductsPage.clickOnEnterFromKeyboardToViewSearch("White"),"SEARCHED PRODUCTS");
    }
}
