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
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(driver.get() == null){
            driver.set(new ChromeDriver());
        }
            return driver.get();
    }
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

    @BeforeMethod
    public static WebDriver beforeTest(){
        System.out.println("Before Method is open browser and navigate to EP");
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
        getDriver();
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get().get(ConfigProperties.getTestProperty("url"));
        return driver.get();
    }

    @AfterMethod
    public static void afterTest() {
        System.out.println("After Method is close browser");
        driver.get().quit();
        driver.set(null);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class execute this method.");
    }

    @AfterSuite
    public static void afterSuite() {
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
