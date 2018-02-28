package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by user on 27.02.2018.
 */
public class FirstTest extends TestBase{

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test Digest");
    }

    @Test(dataProvider = "myProvider")
    public void testDigest(String title, String locator) throws IOException {
        System.out.println("In testing");
        WebElement newsButton = driver.findElement(By.id(locator));
        Assert.assertTrue(newsButton.isDisplayed(),"Digest Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),title,"Title is "+title);
        newsButton.getText();
        newsButton.click();

    }
}

