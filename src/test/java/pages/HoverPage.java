package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HoverPage extends BasePage{

    private By squareBoxBtn = By.id("hot-spot");

    @Override
    public void open(){
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    public void open(String url){
        driver.get(url);
    }

    public void checkLabelPresent(String userid){
        Actions mouse = new Actions(driver);
        mouse
                .moveToElement(driver
                        .findElement(By.xpath(String.format("//div[@id='content']//div[@class='figure'][%s]",userid))))
                .perform();

        System.out.println("String.format(\"//div[@id='content']//div[@class='figure'][%s]\",userid)"
                +String.format("//div[@id='content']//div[@class='figure'][%s]",userid));

        //Assert.assertTrue(driver.findElement(By.className("figcaption")).isDisplayed());
        Assert.assertEquals(getResult(), "name: user"+userid+"\n" +
                "View profile");

    }
    public String getResult(){
        return driver.findElement(By.xpath("//*[@class ='figcaption']")).getText();
    }

    public void dragAndDrop(WebElement a, WebElement b){
        Actions mouse = new Actions(driver);
        mouse.dragAndDrop(a,b).build().perform();
    }

    public void rightClickCheck(){
        Actions mouse = new Actions(driver);
        WebElement squareBox = driver.findElement(squareBoxBtn);
        mouse.contextClick(squareBox).perform();
        driver.switchTo().alert().accept();
    }

    public void keyPressCheck(Keys key ){
        Actions keyboard = new Actions(driver);
        keyboard.sendKeys(key).perform();
    }
}
