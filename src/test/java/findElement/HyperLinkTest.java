package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkTest {
    @Test
    void ValidateHyperLink() throws InterruptedException {
        String baseUrl = "https://the-internet.herokuapp.com/status_codes/";
        WebDriver driver = new ChromeDriver();
        WebElement gohere;
        driver.get("https://the-internet.herokuapp.com/status_codes");

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "200",
                "status 200 is not selected");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "301",
                "status 301 is not selected");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "404",
                "status 404 is not selected");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "500",
                "status 500 is not selected");
        driver.findElement(By.linkText("here")).click();


        driver.quit();


    }
}
