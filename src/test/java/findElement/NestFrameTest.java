package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestFrameTest {
    @Test
    void validateLeftFrame() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        //driver.switchTo().frame(0);
        //driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame("frame-left");
        String leftFrameBody = driver.findElement(By.xpath("html/body")).getText().trim();
        System.out.println(leftFrameBody);
        Assert.assertEquals(leftFrameBody, "LEFT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        String middleFrameBody = driver.findElement(By.id("content")).getText().trim();
        Assert.assertEquals(middleFrameBody, "MIDDLE");

        driver.switchTo().parentFrame();
        //driver.switchTo().frame("frame-right");
        driver.switchTo().frame(2);
        String rightFrameBody = driver.findElement(By.xpath("html/body")).getText().trim();
        Assert.assertEquals(rightFrameBody, "RIGHT");

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        String bottomFrameBody = driver.findElement(By.xpath("html/body")).getText().trim();
        Assert.assertEquals(bottomFrameBody, "BOTTOM");

        driver.quit();
    }
}
