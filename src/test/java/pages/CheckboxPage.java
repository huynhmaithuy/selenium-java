package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

public class CheckboxPage extends BasePage {
    private String checkboxElemnent = "//form[@id='checkboxes']//input[%s]";


    @Override
    public void open(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public  void checkOn(String checkboxName){
        check(getCheckbox(checkboxName));
    }

    public WebElement getCheckbox(String checkBoxName){
        //return driver.findElement(By.xpath(String.format(checkboxElemnent,checkBoxName)));
        return find(How.XPATH, String.format(checkboxElemnent,checkBoxName));
    }

}
