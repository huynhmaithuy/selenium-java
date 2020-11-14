package testcases;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import testcases.BaseTest;

public class CheckboxTest extends BaseTest {
    @Test
    void validateCheckBoxesChecked(){
        CheckboxPage checkboxPage = new CheckboxPage();
        checkboxPage.open();
        checkboxPage.checkOn("1");
        Assert.assertTrue(checkboxPage.getCheckbox("1").isSelected());
    }
}
