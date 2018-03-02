package ukr.tests;

import org.testng.annotations.Test;
import ukr.TestBase;
import ukr.pages.LoginPage;

/**
 * Created by user on 02.03.2018.
 */
public class LoginTest extends TestBase{
    public static LoginPage loginPage;

    @Test
    public void loginTest(){
        loginPage.inputLogin(login);
        loginPage.inputPassword(pass);
        loginPage.clickLoginButton();
    }
}
