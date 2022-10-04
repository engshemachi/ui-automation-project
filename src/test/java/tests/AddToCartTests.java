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
}
