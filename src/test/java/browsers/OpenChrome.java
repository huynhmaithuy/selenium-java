package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenChrome {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        //WebDriverManager .chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //driver.get("https://google.com.vn");
        driver.navigate().to("https://google.com.vn");
        driver.manage().window().maximize();
        driver.close();
        //driver.quit();
    }
}
