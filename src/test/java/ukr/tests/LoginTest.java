package ukr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ukr.TestBase;
import ukr.pages.LoginPage;
import ukr.pages.MailPage;

import java.util.ArrayList;

import static utils.ConfigProperties.*;

/**
 * Created by user on 02.03.2018.
 */
public class LoginTest extends TestBase{
    String login= getTestProperty("login");
    String pass= getTestProperty("pass");

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickLoginButton();
        sleep(1000);
        Assert.assertTrue(loginPage.logoutButton.isDisplayed(),"Logout button is displayed");
    }

    @Test
    public void mailTest(){
        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage= new MailPage(driver);
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickLoginButton();
        sleep(1000);
        loginPage.clickMailButton();
        sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        mailPage.clickNewMailButton();
        sleep(3000);

    }
}
