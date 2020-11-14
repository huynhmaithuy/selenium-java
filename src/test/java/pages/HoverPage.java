package pages;

public class HoverPage extends BasePage{

    @Override
    public void open(){
        driver.get("https://the-internet.herokuapp.com/hovers");
    }


}
