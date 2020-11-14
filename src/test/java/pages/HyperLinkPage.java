package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HyperLinkPage extends BasePage {

    private String baseUrl = "https://the-internet.herokuapp.com/status_codes/";
    private By hereTxt = By.linkText("here");

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    public void isHyperLinkClicked(String statuscode) {
        By hyperLinkTxt = By.linkText(statuscode);
        driver.findElement(By.linkText(statuscode)).click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + statuscode,
                "status 200 is not selected");
        click(hereTxt);
    }
}
