package testcases;

import browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseTest {

    @Parameters({"browserName"})
    @BeforeClass
    void setup(String browserName)
    {
        Browser.launch(browserName);
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }

}
