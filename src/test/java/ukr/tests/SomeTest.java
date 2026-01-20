package ukr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ukr.TestBase;
import ukr.pages.LoginPage;
import ukr.pages.MailPage;

import static utils.ConfigProperties.getTestProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 02.03.2018.
 */

public class SomeTest extends TestBase{
    String login = getTestProperty("login");
    String pass = getTestProperty("pass"); 

    @Test
    public void loginTest(){
        log.info("loginTest starts:");
        LoginPage loginPage = new LoginPage(driver);

        log.info("Login");
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickLoginButton();
        // waitForElement(loginPage.logoutButton);
        // Assert.assertTrue(loginPage.logoutButton.isDisplayed(),"Logout button is displayed");
        
    }
        @Test
    public void mailTest(){
        log.info("mailTest starts:");
        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage= new MailPage(driver);

        log.info("Login");
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickLoginButton();

        log.info("Go to mailbox");
        loginPage.clickMailButton();
        List<String> tabsNew = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsNew.get(1));

        log.info("Try to create new mail");
        mailPage.clickNewMailButton();
        Assert.assertTrue(mailPage.sendMailButton.isDisplayed(),"Send Mail Button is displayed");

    }
}
