package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.NavigationBarPage;
import pages.ViewCartPage;

public class AddToCartTests extends BaseTests {

    @Test
    public void testAddedProductToCart() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        AllProductsPage allProductsPage = navigationBarPage.clickOnProductsBtn();
        ViewCartPage viewCartPage = allProductsPage.addProductsToCart();
        Assert.assertEquals(viewCartPage.getQuantityOfAddedProduct(), "1", "The quantity should be 1");
    }

    @Test
    public void testQuantityOfProductAdded() {

        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        AllProductsPage allProductsPage = navigationBarPage.clickOnProductsBtn();
        ViewCartPage viewCartPage = allProductsPage.addProductsMultipleTimesToCart(4);
        Assert.assertEquals(viewCartPage.getQuantityOfAddedProduct(),"4","The quantity should be 4");
    }

    @Test
    public void testNumberOfColumnsInCart () {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        AllProductsPage allProductsPage = navigationBarPage.clickOnProductsBtn();
        ViewCartPage viewCartPage = allProductsPage.addProductsToCart();
        Assert.assertEquals(viewCartPage.getNumberOfColumnsInCart(),6,"Number of columns should be 6");
    }
}

