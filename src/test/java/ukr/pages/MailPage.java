package ukr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {
    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@class='default compose']")
    public WebElement newMailButton;

    @FindBy(xpath = "//*[@class='default send']")
    public WebElement sendMailButton;

    public void clickNewMailButton() {
        newMailButton.click();
    }

    public void clickSendMailButton() {
        sendMailButton.click();
    }

}
