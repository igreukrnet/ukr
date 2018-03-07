package ukr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by user on 27.02.2018.
 */
public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public  void beforeSuite() throws Exception {
        LOGGER.info("Before test suite execute this method.");
    }

    @BeforeClass
    public void beforeClass() {
        LOGGER.info("Before class execute this method.");
    }

    @BeforeMethod
    public  WebDriver beforeMethod(){
        LOGGER.info("Before Method is open browser and navigate to EP");
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
        return driver;    }

    @AfterMethod
    public void afterMethod() {
        LOGGER.info("After Method is close browser");
        driver.quit();
    }

    @AfterClass
    public  void afterClass() {
        LOGGER.info("After class execute this method.");
    }

    @AfterSuite
    public  void afterSuite() {
        LOGGER.info("After test suite execute this method.");
    }

    public void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

        @DataProvider(name = "myProvider")
    public static Object[][] parameters() {
        return new Object[][]{
                { "Дайджесты", "main-views-viewviewsgreenlightspage-2"},
                { "Новости", "main-views-viewviewsnews-vievspage-1"}
        };
    }

    public final static Logger LOGGER = Logger.getLogger(TestBase.class.getName());
}
