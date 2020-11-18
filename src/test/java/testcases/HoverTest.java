package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverPage;

public class HoverTest extends BaseTest {
    private By columnALbl = By.id("column-a");
    private By columnBLbl = By.id("column-b");

    @Test
    void verifyLabelPresent(){
        HoverPage hoverPage = new HoverPage();
        hoverPage.open("https://the-internet.herokuapp.com/hovers");
        hoverPage.checkLabelPresent("1");
    }

    @Test
    void dragDrop(){
        //WebDriver driver = new ChromeDriver();
        HoverPage hoverPage = new HoverPage();
        hoverPage.open("https://the-internet.herokuapp.com/drag_and_drop");
        hoverPage.dragAndDrop(hoverPage.find(columnALbl), hoverPage.find(columnBLbl));

    }

    @Test
    void rightClick(){
        HoverPage hoverPage = new HoverPage();
        hoverPage.open("https://the-internet.herokuapp.com/context_menu");
        hoverPage.rightClickCheck();
    }

    @Test
    void keyPress(){
        WebDriver driver = new ChromeDriver();
        HoverPage hoverPage = new HoverPage();
        hoverPage.open("https://the-internet.herokuapp.com/key_presses");
        hoverPage.keyPressCheck(Keys.ARROW_DOWN);


    }
}
