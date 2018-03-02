package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 28.02.2018.
 */
public class ZeroTest extends TestBase {

    @Test
    public void testNews() {
        LOGGER.info("In testing");
        WebElement newsButton = driver.findElement(By.id(locatorNews));
        Assert.assertTrue(newsButton.isDisplayed(),"News Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),"Новости","Title is ''Новости");
        newsButton.click();

    }

}
