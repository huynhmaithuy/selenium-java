package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.yaml.snakeyaml.events.Event;

public class LoginPage extends BasePage {

    /**
     * suffix for location naming
     * txt --> text box
     * btn --> button
     * lbl label
     * lnk link
     * rad radio button
     * chk checkbox
     * dropdown  drop down
     */
//
//    private String usernameTxt ="username";
//    private String passwordTxt = "password";
//    private String loginBtn ="//button[@type='submit']";
    private By usernameTxt = By.id("username");
    private By passwordTxt = By.id("password");
    private By loginBtn = By.xpath("//button[@type='submit']");



    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public boolean isLogin(){
        return getCurrentUrl().equals("https://the-internet.herokuapp.com/secure");
    }

    public  void login(String username,String password){

//        driver.findElement(By.id(usernameTxt)).sendKeys("tomsmith");
//        driver.findElement(By.id(passwordTxt)).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath(loginBtn)).click();

        fill(usernameTxt,username);
        fill(passwordTxt,password);
        click(loginBtn);
    }


}
