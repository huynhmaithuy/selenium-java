package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JAlertsPage;

import java.sql.Driver;

public class JSAlerts extends BaseTest {
    @Test
    void validatePopUpDisplay(){

        JAlertsPage jAlertsPage = new JAlertsPage();

        jAlertsPage.open();
        jAlertsPage.JSAlert();
        jAlertsPage.JSConfirm();
        jAlertsPage.JSPrompt("hello");


    }
}
