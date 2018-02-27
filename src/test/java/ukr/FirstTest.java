package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 27.02.2018.
 */
public class FirstTest extends ZeroTest{

    protected FirstTest init(){
        return this;
    }

    @Test
    public void userLogin() {
//        ZeroTest.beforeClass();
        System.out.println("Message");
//        WebDriver driver=ZeroTest.getDriver();

        WebElement newsButton = ZeroTest.getDriver().findElement(By.id("main-views-viewviewsnews-vievspage-1"));
        Assert.assertFalse(newsButton.isDisplayed(),"News Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),"Новости","Title is ''Новости");
        newsButton.getText();
        newsButton.click();

    }
}

