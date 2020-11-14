package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import testcases.BaseTest;
import testcases.JSAlerts;

public class JAlertsPage extends BasePage {
    private By JSAlertBtn = By.xpath("//button[contains(.,'Click for JS Alert')]");
    private By JSConfirmBtn = By.xpath("//button[.='Click for JS Confirm']");
    private By JSPromptBtn = By.xpath("//button[.='Click for JS Prompt']");
    private By resultTxt = By.id("result");

    public void JSAlert() {
        click(JSAlertBtn);
        acceptAlert();
        Assert.assertEquals(getResult(), "You successfuly clicked an alert");
    }

    public void JSConfirm() {
        click(JSConfirmBtn);
        acceptAlert();
        Assert.assertEquals(getResult(), "You clicked: Ok");
        click(JSConfirmBtn);
        dismissAlert();
        Assert.assertEquals(getResult(), "You clicked: Cancel");
    }

    public void JSPrompt(String key) {
        click(JSPromptBtn);
        sendKeytoAlert(key);
        acceptAlert();
        Assert.assertEquals(getResult(), "You entered: " + key);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeytoAlert(String withText) {
        driver.switchTo().alert().sendKeys(withText);
    }

    public String getResult() {
        return driver.findElement(resultTxt).getText().trim();
    }

}
