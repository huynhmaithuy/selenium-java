package pages;

import browsers.OpenChrome;

public class BasicAuthenticationPage extends BasePage{
    @Override
    public void open(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

}
