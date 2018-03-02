package ukr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by user on 27.02.2018.
 */
public class TestBase {

    Properties property = new Properties();

    public static WebDriver driver;
    public static final String locatorNews="main-views-viewviewsnews-vievspage-1";
    public static final String locatorDigest="main-views-viewviewsgreenlightspage-2";

    @BeforeSuite
    public static void beforeSuite() throws Exception {
        System.out.println("Before test suite execute this method.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class execute this method.");
    }

    @BeforeTest
    public static WebDriver beforeTest(){
        System.out.println("Before test is open browser and navigate to EP");
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
        return driver;
    }

    @AfterTest
    public static void afterTest() {
        System.out.println("After class is close browser");
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class execute this method.");
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("After test suite execute this method.");
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
