package ukr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigProperties;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by user on 27.02.2018.
 */
public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public  void beforeSuite() throws Exception {
        log.info("Before test suite execute this method.");
    }

    @BeforeClass
    public void beforeClass() {
        log.info("Before class execute this method.");
    }

    @BeforeMethod
    public  WebDriver beforeMethod(){
        log.info("Before Method is open browser and navigate to EP");
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
        return driver;    }

    @AfterMethod
    public void afterMethod() {
        log.info("After Method is close browser");
        driver.quit();
    }

    @AfterClass
    public  void afterClass() {
        log.info("After class execute this method.");
    }

    @AfterSuite
    public  void afterSuite() {
        log.info("After test suite execute this method.");
    }

    public void waitForElement(WebElement element) {
        int maxAttempt = 5;
        int count = 1;
        do {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        } while (count < maxAttempt && !element.isDisplayed());
    }

    public static Logger log;
    static {
        InputStream stream = TestBase.class.getClassLoader().getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
            log= Logger.getLogger(TestBase.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
