package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HyperLinkPage;

public class HyperLinkTest extends BaseTest{
    @Test
    void ValidateHyperLink(){
        HyperLinkPage hyperLinkPage = new HyperLinkPage();
        hyperLinkPage.open();
        hyperLinkPage.isHyperLinkClicked("200");
        hyperLinkPage.isHyperLinkClicked("301");
        hyperLinkPage.isHyperLinkClicked("404");
        hyperLinkPage.isHyperLinkClicked("500");
    }
}
