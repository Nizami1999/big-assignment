import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class UserPage extends BasePage {
    public UserPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.bandolierstyle.com/account");
    }

    public void logoutButton() {

        // Perform logout action
        WebElement logoutBtn = waitAndReturnElement(By.xpath("(//a[@aria-label='Log out from your account'])[1]"));
        logoutBtn.click();

        // Verify successful logout by checking the page title
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.titleContains("BANDOILER"));
            String pageTitle = driver.getTitle();
            if (pageTitle.contains("BANDOILER")) {
                System.out.println("Logout test passed successfully!");
            } else {
                System.out.println("Logout test failed!");
            }
        } catch (TimeoutException e) {
            System.out.println("Timeout: Login page title not found.");
        }

}

}