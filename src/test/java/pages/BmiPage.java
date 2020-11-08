package pages;

import browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BmiPage extends BasePage{

    public BmiPage() {

        PageFactory.initElements(Browser.getDriver(),this);
    }
//    public BmiPage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver,this);
//    }

    @FindBy(xpath = "//a[contains(.,'Metric Units')]")
    WebElement metricUnitTab; //==~ driver.findElement(By.xpath("//a[contains(.,'Metric Units')]"));

    @FindBy(id="cage")
    WebElement ageTxt;

    @FindBy(id="csex1")
    WebElement maleRad;

    @FindBy(id="csex2")
    WebElement femaleRad;

    @FindBy(id="cheightmeter")
    WebElement heightTxt;

    @FindBy(id="ckg")
    WebElement weightTxt;

    @FindBy(xpath ="//input[@value='Calculate']")
    WebElement calculatorBtn;

    @FindBy(className = "bigtext")
    WebElement result;

    @Override
    public void open() {
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab(){
        metricUnitTab.click();
    }

    public void fillForm(String age, String gender, String height, String weight){
        ageTxt.clear();
        ageTxt.sendKeys(age);

        if(gender.equalsIgnoreCase("male")) {
            maleRad.click();
        }
        else femaleRad.click();

        heightTxt.clear();
        heightTxt.sendKeys(height);

        weightTxt.clear();
        weightTxt.sendKeys(weight);

        calculatorBtn.click();
    }

    public String getResult(){
        return  result.getText();
    }
}
