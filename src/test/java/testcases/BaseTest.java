package testcases;

import browsers.Browser;
import org.testng.annotations.*;

public class BaseTest {

    @Parameters({"browserName"})
    @BeforeClass
    void setup(String browserName){
        Browser.launch(browserName);
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
