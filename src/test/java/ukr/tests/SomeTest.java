package ukr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ukr.TestBase;
import ukr.pages.LoginPage;
import ukr.pages.MailPage;

import java.util.ArrayList;

import static utils.ConfigProperties.getTestProperty;

/**
 * Created by user on 02.03.2018.
 */
public class SomeTest extends TestBase{
    String login= getTestProperty("login");
    String pass= getTestProperty("pass");

    @Test
    public void loginTest(){
        log.info("loginTest starts:");
        LoginPage loginPage = new LoginPage(getDriver());

        log.info("Login");
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickLoginButton();
        sleep(1000);
        Assert.assertTrue(loginPage.logoutButton.isDisplayed(),"Logout button is displayed");
    }

    @Test
    public void mailTest(){
        log.info("mailTest starts:");
        LoginPage loginPage = new LoginPage(getDriver());
        MailPage mailPage= new MailPage(getDriver());

        log.info("Login");
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickLoginButton();

        log.info("Go to mailbox");
        loginPage.clickMailButton();
        ArrayList<String> tabsNew = new ArrayList<>(getDriver().getWindowHandles());
        int index=0;
        for (int count=0;count<tabsNew.size() ; count++){
            getDriver().switchTo().window(tabsNew.get(count));
            if (getDriver().getTitle().contains(getTestProperty("mailTabTitle"))) {
                index=count;
            }
        }
        getDriver().switchTo().window(tabsNew.get(index));

        log.info("Try to create new mail");
        mailPage.clickNewMailButton();
        Assert.assertTrue(mailPage.sendMailButton.isDisplayed(),"Send Mail Button is displayed");

    }
}
