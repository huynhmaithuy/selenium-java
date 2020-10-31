package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest {
    @Test
    void verifyLabelPresent(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions mouse = new Actions(driver);
        mouse
                .moveToElement(driver.findElement(By.xpath("//div[@id='content']//div[@class='figure'][1]")))
                .perform();
        //Assert.assertTrue(driver.findElement(By.className("figcaption")).isDisplayed());
        String avatarCaption = driver.findElement(By.xpath("//*[@class ='figcaption']")).getText();
        Assert.assertEquals(avatarCaption, "name: user1\n" +
                "View profile");

    }

    @Test
    void dragDrop(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions mouse = new Actions(driver);
        WebElement A = driver.findElement(By.id("column-a"));
        WebElement B = driver.findElement(By.id("column-b"));
        mouse.dragAndDrop(A,B).build().perform();
    }

    @Test
    void rightClick(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions mouse = new Actions(driver);
        WebElement squareBox = driver.findElement(By.id("hot-spot"));
        mouse.contextClick(squareBox).perform();
        driver.switchTo().alert().accept();
    }

    @Test
    void keyPress(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions keyboard = new Actions(driver);
        keyboard.sendKeys(Keys.ARROW_DOWN).perform();
    }
}
