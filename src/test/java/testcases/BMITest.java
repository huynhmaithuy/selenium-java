package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BmiPage;
import testcases.BaseTest;

public class BMITest extends BaseTest {


    @Test(description = "validate body mass index calculator")
    void should_be_normal_category() {
        BmiPage bmiPage = new BmiPage();
        bmiPage.open();
        bmiPage.selectMetricTab();
        bmiPage.fillForm("25", "male", "180", "65");
        Assert.assertEquals(bmiPage.getResult(), "BMI = 20.1 kg/m2   (Normal)");
    }

    @Test(description = "validate body mass index calculator")
    void should_be_obese_category() {
        BmiPage bmiPage = new BmiPage();
        bmiPage.open();
        bmiPage.selectMetricTab();
        bmiPage.fillForm("25", "male", "180", "100");
        Assert.assertEquals(bmiPage.getResult(), "BMI = 30.9 kg/m2   (Obese Class I)");
    }


}
