package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    public static void launch(String browserName) {
        switch (browserName) {
            case "ie": {
                driver = new InternetExplorerDriver();
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "safari": {
                driver = new SafariDriver();
                break;
            }
            default:

                throw new IllegalArgumentException("the browser: " + browserName + " does not support");

        }
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }

    }
}
