package ukr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ukr.TestBase;
import ukr.pages.LoginPage;
import ukr.pages.MailPage;

import java.util.ArrayList;
import java.util.List;

import static utils.ConfigProperties.getTestProperty;

/**
 * Created by user on 02.03.2018.
 */
public class SomeTest extends TestBase{
    String login= getTestProperty("login");
    String pass= getTestProperty("pass");

    @Test
    public void loginTest(){
        LOGGER.info("Login");
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

        LOGGER.info("Login");
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickLoginButton();
        sleep(1000);

        LOGGER.info("Go to mailbox");
        loginPage.clickMailButton();
        sleep(1000);
        List<String> tabsNew = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsNew.get(1));

        LOGGER.info("Try to create new mail");
        mailPage.clickNewMailButton();
        Assert.assertTrue(mailPage.sendMailButton.isDisplayed(),"Send Mail Button is displayed");

    }
}
