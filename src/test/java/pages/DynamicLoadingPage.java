package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage extends BasePage {

    private By startBtn = By.xpath("//div[@id='start']/button");
    private By finishBtn = By.id("finish");
    private By result = By.tagName("h4");

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public boolean isdynamicLoadedSuccessful() {
        driver.findElement(startBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String finished = wait.until(ExpectedConditions.visibilityOfElementLocated(finishBtn))
                .findElement(result).getText().trim();
        return finished.equals("Hello World!");
    }
}
