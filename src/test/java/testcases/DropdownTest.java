package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.nio.channels.SelectableChannel;

/**
 * <select id='dropdown'>
 * <option value='1'>Option 1</option>
 * <option value='2'>Option 2</option>
 * </select>
 */
public class DropdownTest extends BaseTest{

    @Test
    void validateOption1IsSelected(){
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.open();
        dropdownPage.selectDropdown("Option 1");

        Assert.assertTrue(dropdownPage.isSelected("Option 1"),"option is not selected");

    }
}
