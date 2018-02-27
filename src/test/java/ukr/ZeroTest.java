package ukr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 27.02.2018.
 */
public class ZeroTest {
    private static WebDriver driver;

    public ZeroTest() {
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        System.out.println("Before test suite execute this method.");
    }

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get("https://mail.ukr.net/desktop/login");
    }

    @Test
    public void userLogin() {
        System.out.println("Message");
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @AfterSuite
    public static void afterSuite() {
        System.out.println("After test suite execute this method.");
    }
}
