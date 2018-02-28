package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by user on 27.02.2018.
 */
public class FirstTest extends TestBase{

    @BeforeTest
    public String locator(){
        String locator="main-views-viewviewsgreenlightspage-2";
        return locator;
    }

    @Test
    public void testDigest() {
        System.out.println("In testing");
        WebElement newsButton = driver.findElement(By.id(locator()));
        Assert.assertTrue(newsButton.isDisplayed(),"Digest Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),"Дайджесты","Title is 'Дайджесты'");
        newsButton.getText();
        newsButton.click();

    }
}

