package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{

    @Override
    public void open(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectDropdown(String option){
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText(option);
    }

    public boolean isSelected(String option){
        return driver.findElement(By.xpath("//option[.='"+ option+"']")).isSelected();
    }
}
