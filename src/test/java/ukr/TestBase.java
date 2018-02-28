package ukr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 27.02.2018.
 */
public class TestBase {

    Properties property = new Properties();

    public static WebDriver driver;
    public static final String url="https://petrimazepa.com/";

    @BeforeSuite
    public static void beforeSuite() throws Exception {
        System.out.println("Before test suite execute this method.");
    }

    @BeforeClass
    public static WebDriver beforeClass() {
        System.out.println("Before class is open browser and navigate to EP");
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }


    @AfterClass
    public static void afterClass() {
        System.out.println("After class is close browser");
        driver.quit();
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("After test suite execute this method.");
    }

}