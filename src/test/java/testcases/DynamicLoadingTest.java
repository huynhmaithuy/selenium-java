package testcases;

import browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;


public class DynamicLoadingTest extends BaseTest{
    @Test
    void loadingTest() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();
        Assert.assertTrue(dynamicLoadingPage.isdynamicLoadedSuccessful());
        Browser.captureWebPage();
    }
}
