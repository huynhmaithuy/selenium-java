package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class JSAlerts {

    @Test
    void validatePopUpDisplay(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[contains(.,'Click for JS Alert')]")).click();
        driver.switchTo().alert().accept();
        String result = driver.findElement(By.id("result")).getText().trim();
        Assert.assertEquals(result, "You successfuly clicked an alert");

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        result = driver.findElement(By.id("result")).getText().trim();
        Assert.assertEquals(result, "You clicked: Cancel");

        driver.findElement(By.xpath("//button[.='Click f `or JS Confirm']")).click();
        driver.switchTo().alert().accept();
        result = driver.findElement(By.id("result")).getText().trim();
        Assert.assertEquals(result, "You clicked: Ok");

        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();
        result = driver.findElement(By.id("result")).getText().trim();
        Assert.assertEquals(result, "You entered: hello");

    }
}
