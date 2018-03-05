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

    @FindBy(className = "default compose")
    public WebElement newMailButton;

//    @FindBy(xpath = "//*[@href='https://mail.ukr.net/q/start#msglist']")
//    public WebElement mailButton;

//    public void inputLogin(String login) {
//        loginField.sendKeys(login);
//    }

    public void clickNewMailButton() {
        newMailButton.click();
    }

}
