import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class MainPage extends BasePage {
    private WebDriver driver;
 
    private final By footerLocator = By.xpath("//footer");
    private final By subscribeLocator = By.xpath("//input[@id='newsletter-email']");
    private final By submitButton = By.xpath("//button[contains(text(),'Get my discount')]");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.bandolierstyle.com/");
    }

    public String getFooterText() {
        WebElement footerElement = waitAndReturnElement(footerLocator);
        return footerElement.getText();
    }

    public void subscribeNews() {
        WebElement subscribeInput = waitAndReturnElement(subscribeLocator);
        subscribeInput.click();
        subscribeInput.sendKeys("testuser8845114444@gmail.com");

        WebElement submitElement = waitAndReturnElement(submitButton);
        submitElement.click();

    }


}