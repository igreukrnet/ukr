package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 27.02.2018.
 */
public class FirstTest extends ZeroTest{

//    public void init(){
//        super.init();
//    }

    @Test
    public void testDigest() {
//        ZeroTest.beforeClass();
        System.out.println("Message");
//        WebDriver driver = beforeClass();
        WebElement newsButton = driver.findElement(By.id("main-views-viewviewsgreenlightspage-2"));
        Assert.assertTrue(newsButton.isDisplayed(),"Digest Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),"Дайджесты","Title is 'Дайджесты'");
        newsButton.getText();
        newsButton.click();

    }
}

