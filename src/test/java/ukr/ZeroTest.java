package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 27.02.2018.
 */
public class ZeroTest {

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

    @Test
    public void testNews() {
        System.out.println("In testing");
        WebElement newsButton = driver.findElement(By.id("main-views-viewviewsnews-vievspage-1"));
        Assert.assertTrue(newsButton.isDisplayed(),"News Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),"Новости","Title is ''Новости");
        newsButton.click();

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
