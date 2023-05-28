import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class LoginPage extends BasePage {
    private final By loginButton = By.xpath("//button[@type='submit' and contains(@class, 'bordered white-on-black') and @data-uw-rm-form='submit']");
    private final By emailField = By.xpath("//input[@id='CustomerEmail']");
    private final By passwordField =By.xpath("//input[@id='CustomerPassword']");
    private final By modalClose =By.xpath("//button[@class='recommendation-modal__button' and text()='Continue']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.bandolierstyle.com/account/login");
    }

    public void setEmail(String email) {
        WebElement emailElement = waitAndReturnElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordElement = waitAndReturnElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    public void clickCloseModal() {
        WebElement continueElement = waitAndReturnElement(modalClose);
        continueElement.click();
    }

    public void clickSubmit() {
        WebElement submitElement = waitAndReturnElement(loginButton);
        submitElement.click();
    }


}