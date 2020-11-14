package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingTest {
    @Test
    void loadingTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        //driver.findElement(By.xpath("//button[.='Start']")).click();
        //Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(driver.findElement(By.x)))
        String finished = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")))
                .findElement(By.tagName("h4")).getText().trim();

        Assert.assertEquals(finished,"Hello World!");
    }
}
