package testcases;

import browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import javax.security.auth.login.FailedLoginException;

public class LoginTest extends BaseTest{

    @Test
    void withValidCredentials(){
       // WebDriver driver = new ChromeDriver();
       //Browser.launch(browserName);
        //driver.get("https://the-internet.herokuapp.com/login");
       // driver.findElement(By.id("username")).sendKeys("tomsmith");
      /*  driver.findElement(By.xpath("//label[.='Username']/following-sibling::input"))
                .sendKeys("tomsmith");*/
       /* driver.findElement(By.xpath("//label[.='Username']/following-sibling::*"))
                .sendKeys("tomsmith");*/
        //driver.findElement(By.xpath("//label[.='Username']/../input")).sendKeys("tomsmith");
        //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        /*driver.findElement(By.xpath("//label[.='Username']/../../..//input[@id='password']"))
                .sendKeys("SuperSecretPassword!");*/
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        //driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        //driver.findElement(By.xpath("//button//*[contains(text(),'Login')]")).click();
        //driver.findElement(By.xpath("//i[contains(.,'Login')]")).click();
        //driver.findElement(By.xpath("//i[.=' Login']")).click();

        LoginPage loginpage = new LoginPage();
        loginpage.open();
        //loginpage.login();
        loginpage.login("tomsmith","SuperSecretPassword!");
//        Assert.assertEquals(loginpage.getCurrentUrl(),
//                "https://the-internet.herokuapp.com/secure",
//                "Failed :(");

        Assert.assertTrue(loginpage.isLogin(),"login failed");
//        Browser.quit();
    }
}
