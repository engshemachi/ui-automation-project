package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


//import static fileReaderManager.ReadFromFiles.getPropertyByKey;


public class BaseTests {

    WebDriver driver;

    @BeforeMethod
    public void setupWebpage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void closeWebBrowser() {
        driver.quit();
    }

}
