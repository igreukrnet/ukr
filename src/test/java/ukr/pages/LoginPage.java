package ukr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ukr.TestBase;

/**
 * Created by user on 02.03.2018.
 */
public class LoginPage extends TestBase{
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(name = "login")
    public WebElement loginField;

    @FindBy(name = "Password")
    public WebElement passwordField;

    @FindBy(className = "login-block__submit-but")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@href='javascript:User.logout();']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[@href='https://mail.ukr.net/q/start#msglist']")
    public WebElement mailButton;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickMailButton() {
        waitForElement(mailButton);
        mailButton.click();
    }
}
