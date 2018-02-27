package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 27.02.2018.
 */
public class ZeroTest {

//    public void init() {
//    }

    public static WebDriver driver;

    @BeforeSuite
    public static void beforeSuite() throws Exception {
        System.out.println("Before test suite execute this method.");
    }

    @BeforeClass
    public static WebDriver beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get("https://petrimazepa.com/");
        return driver;
    }

//    public static WebDriver getDriver() {
//        driver = new ChromeDriver();
//        return driver;
//    }

    @Test
    public void testNews() {
        System.out.println("Message");
        WebElement newsButton = driver.findElement(By.id("main-views-viewviewsnews-vievspage-1"));
        Assert.assertTrue(newsButton.isDisplayed(),"News Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),"Новости","Title is ''Новости");
        newsButton.click();

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
