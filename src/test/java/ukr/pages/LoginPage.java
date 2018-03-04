package ukr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 02.03.2018.
 */
public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(name = "Login")
    public WebElement loginField;

    @FindBy(name = "Password")
    public WebElement passwordField;

    @FindBy(className = "login-block__submit-but")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@href='javascript:User.logout();']")
    public WebElement logoutButton;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}