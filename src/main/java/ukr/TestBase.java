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
        
        // Stealth настройки ChromeOptions
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        
        // Отключаем флаги автоматизации
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        
        // Добавляем аргументы для обхода детекции
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        
        // Устанавливаем user-agent как у обычного браузера
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/143.0.0.0 Safari/537.36");
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        // Сначала открываем пустую страницу и применяем stealth
        driver.get("about:blank");
        applyStealth(driver);
        
        // Теперь переходим на целевую страницу
        driver.get(ConfigProperties.getTestProperty("url"));
        
        return driver;
    }
    
    private void applyStealth(WebDriver driver) {
        try {
            // Скрываем webdriver флаг
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
            );
            
            // Переопределяем navigator.plugins
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'plugins', {get: () => [1, 2, 3, 4, 5]})"
            );
            
            // Переопределяем navigator.languages
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'languages', {get: () => ['uk-UA', 'uk', 'en-US', 'en']})"
            );
            
            // Добавляем chrome объект
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "window.chrome = {runtime: {}};"
            );
            
            log.info("Stealth scripts applied successfully");
        } catch (Exception e) {
            log.info("Error applying stealth scripts: " + e.getMessage());
        }
    }

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
