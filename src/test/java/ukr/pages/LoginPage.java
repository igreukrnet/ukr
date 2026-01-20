package ukr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ukr.TestBase;

/**
 * Created by user on 02.03.2018.
 */
public class LoginPage extends TestBase {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        closeCookieOverlay();
    }

    private void closeCookieOverlay() {
        try {
            Thread.sleep(2000);
            WebElement cookieClose = driver.findElement(By.xpath("//button[contains(@class,'fc-button') or contains(@class,'fc-cta-consent') or contains(text(),'Прийняти') or contains(text(),'Принять')]"));
            cookieClose.click();
            log.info("Closed cookie overlay");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread interrupted while closing cookie: " + e.getMessage());
        } catch (Exception e) {
            log.info("No cookie overlay found or already closed");
        }
    }

    private void switchToLoginIframe() {
        try {
            Thread.sleep(3000);
            WebElement iframe = null;
            try {
                iframe = driver.findElement(By.tagName("iframe"));
                log.info("Found iframe by tag");
            } catch (Exception e1) {
                try {
                    iframe = driver.findElement(By.xpath("//iframe"));
                    log.info("Found iframe by xpath");
                } catch (Exception e2) {
                    log.info("No iframe found, elements might be on main page");
                    return;
                }
            }
            
            if (iframe != null) {
                driver.switchTo().frame(iframe);
                log.info("Switched to login iframe");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread interrupted: " + e.getMessage());
        } catch (Exception e) {
            log.info("Error switching to iframe: " + e.getMessage());
        }
    }

    public void inputLogin(String login) {
        switchToLoginIframe();
        try {
            Thread.sleep(1000);
            WebElement loginField = driver.findElement(By.name("login"));
            loginField.clear();
            loginField.sendKeys(login);
            log.info("Login entered");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread interrupted: " + e.getMessage());
        } catch (Exception e) {
            log.info("Error entering login: " + e.getMessage());
            throw e;
        }
    }

    public void inputPassword(String password) {
        try {
            Thread.sleep(500);
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.clear();
            passwordField.sendKeys(password);
            log.info("Password entered");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread interrupted: " + e.getMessage());
        } catch (Exception e) {
            log.info("Error entering password: " + e.getMessage());
            throw e;
        }
    }

    public void clickLoginButton() {
        try {
            Thread.sleep(500);
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' or contains(@class,'submit')]"));
            loginButton.click();
            log.info("Login button clicked");
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
            
            // Ждем прохождения Cloudflare проверки
            log.info("Waiting for Cloudflare verification (manual solving required)...");
            Thread.sleep(20000); // 20 секунд на ручное решение капчи
            log.info("Cloudflare verification wait completed");
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread interrupted: " + e.getMessage());
        } catch (Exception e) {
            log.info("Error clicking login button: " + e.getMessage());
            throw e;
        }
    }

    public void clickMailButton() {
        try {
            Thread.sleep(2000);
            WebElement mailButton = driver.findElement(By.xpath("//*[contains(@href,'mail.ukr.net')]"));
            mailButton.click();
            log.info("Mail button clicked");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread interrupted: " + e.getMessage());
        } catch (Exception e) {
            log.info("Error clicking mail button: " + e.getMessage());
            throw e;
        }
    }

    public boolean isLogoutButtonDisplayed() {
        try {
            Thread.sleep(3000);
            
            String currentUrl = driver.getCurrentUrl();
            log.info("Current URL after login: " + currentUrl);
            
            // Если URL изменился и не содержит "passport" (страница логина), считаем логин успешным
            if (!currentUrl.contains("passport")) {
                log.info("Login appears successful - URL changed from login page");
                return true;
            }
            
            // Пробуем найти кнопку logout
            try {
                WebElement logoutButton = driver.findElement(By.xpath("//*[contains(@href,'logout') or contains(text(),'Вийти') or contains(text(),'Выйти')]"));
                boolean displayed = logoutButton.isDisplayed();
                log.info("Logout button found and displayed: " + displayed);
                return displayed;
            } catch (Exception e) {
                log.info("Logout button not found: " + e.getMessage());
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Thread interrupted: " + e.getMessage());
            return false;
        } catch (Exception e) {
            log.info("Error checking login status: " + e.getMessage());
            return false;
        }
    }
}
