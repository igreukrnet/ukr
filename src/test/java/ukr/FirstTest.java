package ukr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by user on 27.02.2018.
 */
public class FirstTest extends TestBase{

    @Test(dataProvider = "myProvider")
    public void testDigest(String title, String locator) throws IOException {
        LOGGER.fine("Logging an WARN-level message");
        System.out.println("In testing");
        WebElement newsButton = driver.findElement(By.id(locator));
        Assert.assertTrue(newsButton.isDisplayed(),"Digest Button isDisplayed");
        Assert.assertEquals(newsButton.getText(),title,"Title is "+title);
        newsButton.getText();
        newsButton.click();

    }
}

