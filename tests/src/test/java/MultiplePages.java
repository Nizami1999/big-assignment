import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class MultiplePages extends BasePage {
    String[] urls = {"https://www.bandolierstyle.com/collections/all", "https://www.bandolierstyle.com/collections/matching-sets"};
 
    public MultiplePages(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.bandolierstyle.com/");
    }

    public void testMultiple() {
        for (String pageUrl : urls) {
            try {
                driver.get(pageUrl);
                // Example: Assert page title contains specific text
                String pageTitle = driver.getTitle();
                if (pageUrl.equals("https://www.bandolierstyle.com/collections/all")) {
                    Assert.assertTrue(pageTitle.contains("Shop All"));
                } else if (pageUrl.equals("hhttps://www.bandolierstyle.com/collections/matching-sets")) {
                    Assert.assertTrue(pageTitle.contains("Matching Sets"));
                }else {
                    // Default assertions/tests if the page URL doesn't match any specific condition
                    Assert.fail("Invalid page URL: " + pageUrl);
                }
            }catch (Exception e) {
                // Handle the exception here (e.g., log the error)
                System.out.println("Error happened while change to other page: " + pageUrl);
                e.printStackTrace();
            }
        }
    }


}