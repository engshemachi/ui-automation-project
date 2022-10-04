package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.BasePage;
import pages.NavigationBarPage;

public class ProductsTests extends BaseTests {

    @Test
    public void testVisibilityOfFirstELement() {

        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        AllProductsPage allProductsPage = navigationBarPage.clickOnProductsBtn();
        allProductsPage.typeSearchKeyword("winter top");
        Assert.assertTrue(allProductsPage.checkOnFirstProductInSearchResults("winter top"), "First Item doesn't match search keyword");
    }

}
