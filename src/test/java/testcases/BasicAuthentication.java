package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasicAuthenticationPage;


public class BasicAuthentication extends BaseTest{
    @Test
    void BasicAuthenticationTest(){
        BasicAuthenticationPage basicAuthenticationPage = new BasicAuthenticationPage();
        basicAuthenticationPage.open();
    }
}
