package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.TodoPage;

public class TodoTest extends BaseTest{
//    WebDriver driver;
//
//    @BeforeTest
//    void openBrowser() {
//        driver.get("http://todomvc.com/examples/vanillajs/");
//    }

    @Test
    void addNewTask() {
//        driver = new ChromeDriver();
        TodoPage todoPage = new TodoPage();
        todoPage.open();

//        driver.findElement(By.linkText("All")).click();
//        WebElement task = driver.findElement(By.xpath("//label[.='task 1']"));
//        Assert.assertTrue(task.isDisplayed());
        int currentItemLeft = todoPage.getItemLeft();
        todoPage.createNewTask("task 1");
        todoPage.selectTab("All");
        Assert.assertTrue(todoPage.getTask("task 1").isDisplayed());
        Assert.assertEquals(todoPage.getItemLeft(), currentItemLeft+1);

        todoPage.selectTab("Active");
        Assert.assertTrue(todoPage.getTask("task 1").isDisplayed());
        Assert.assertEquals(todoPage.getItemLeft(), currentItemLeft+1);
    }
}
