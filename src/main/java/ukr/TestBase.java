package ukr;

import org.openqa.selenium.WebDriver;
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
        System.out.println("Before test suite execute this method.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class execute this method.");
    }

    @BeforeMethod
    public  WebDriver beforeMethod(){
        System.out.println("Before Method is open browser and navigate to EP");
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
        return driver;    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method is close browser");
        driver.quit();
    }

    @AfterClass
    public  void afterClass() {
        System.out.println("After class execute this method.");
    }

    @AfterSuite
    public  void afterSuite() {
        System.out.println("After test suite execute this method.");
    }

    public void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
