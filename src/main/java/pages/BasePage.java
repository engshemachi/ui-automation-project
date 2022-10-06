package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement locateElement(By elementLocator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return driver.findElement(elementLocator);

    }

    public List<WebElement> locateElements(By elementLocator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return driver.findElements(elementLocator);
    }

    public void clickOnElement(By elementLocator) {

        locateElement(elementLocator).click();
    }

    public void typeTextInField(By elementLocator, String text) {
        locateElement(elementLocator).sendKeys(text);
    }

    public String getTextOfWebElement(By elementLocator) {

        return locateElement(elementLocator).getText();
    }

    public void scrollVertically(int deltaY) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, deltaY).perform();
    }

    public void modalActionsToClick(By elementLocator) {

        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        clickOnElement(elementLocator);
        driver.switchTo().defaultContent();
    }

}
