package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TodoPage extends BasePage {
////    WebDriver driver;
    private By itemLeftLbl = By.xpath("//span[@class='todo-count']/strong");
    private By newTodoTxt = By.className("new-todo");
//
//    public TodoPage(WebDriver driver) {
//        this.driver = driver;
//    }

    @Override
    public void open(){
        driver.get("http://todomvc.com/examples/vanillajs/");
    }

    public WebElement getTask(String byName) {
        return driver.findElement(By.xpath(String.format("//label[.='%s']", byName)));

        //return find(How.XPATH, String.format("//label[.='%s']",byName));
    }

    public void selectTab(String name) {
        //driver.findElement(By.xpath(String.format("//a[.='%s']", name))).click();
        click(By.xpath(String.format("//a[.='%s']",name)));
    }

    public int getItemLeft() {
        int itemleft = 0;
        //if(find(itemLeftLbl).isDisplayed())
        if (driver.findElement(itemLeftLbl).isDisplayed()) {

            itemleft = Integer.valueOf(driver.findElement(itemLeftLbl).getText());
        }
        return itemleft;
    }

    public void createNewTask(String byName) {

        driver.findElement(By.xpath("//*[@class='new-todo']")).sendKeys(byName + "\n");
        //fill
    }


}
