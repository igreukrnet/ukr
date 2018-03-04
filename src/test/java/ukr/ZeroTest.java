package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 28.02.2018.
 */
public class ZeroTest extends TestBase {
    public static final String loginLocator="Login";
    public static final String passLocator="Password";
    public static final String loginButLocator="login-block__submit-but";

    @Test
    public void testNews() {
        LOGGER.info("In testing");
        WebElement loginField = driver.findElement(By.name(loginLocator));
        WebElement passField = driver.findElement(By.name(passLocator));
        WebElement loginBut = driver.findElement(By.className(loginButLocator));
        Assert.assertTrue(loginField.isDisplayed(),"Login field  is displayed");
//        loginField.sendKeys(login);
//        passField.sendKeys(pass);
        loginBut.click();
        loginBut.click();

    }

}
