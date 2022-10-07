package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import static fileReaderManager.ReadFromFiles.getPropertyByKey;


public class BaseTests {

    WebDriver driver;

    public static String configPropertyFileName = "configurationData.properties";

    @BeforeMethod
    public void setupWebpage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(getPropertyByKey(configPropertyFileName, "APP_URL"));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void takeScreenShot (ITestResult result)
    {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        if(result.getStatus()==ITestResult.FAILURE)
        {
            try
            {
                FileUtils.copyFile(screenshot, new File("screenshot/"+result.getName()+".png"));
            }
            catch (IOException exception)
            {
                exception.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void zcloseWebBrowser() {
        driver.quit();
    }


}
