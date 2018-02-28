package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by user on 28.02.2018.
 */
public class ZeroTest extends TestBase {
    @BeforeTest
    public String locator(){
        String locator="main-views-viewviewsnews-vievspage-1";
        return locator;
    }

    @Test
    public void testNews() {
        System.out.println("In testing");
        WebElement newsButton = driver.findElement(By.id(locator()));
        Assert.assertTrue(newsButton.isDisplayed(),"News Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),"Новости","Title is ''Новости");
        newsButton.click();

    }

}
