import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HistoryPage {
    private WebDriver driver;

    public void checkHistoryTest() {
        try {
            // Navigate to page 1
            String page1Url = "https://www.bandolierstyle.com/collections/all";
            navigateToUrl(page1Url);

            // Navigate to page 2
            String page2Url = "https://www.bandolierstyle.com/collections/matching-sets";
            navigateToUrl(page2Url);

            // Navigate back to page 1
            navigateBack();

            // Verify if we are on page 1
            String currentUrl = getCurrentUrl();
            if (currentUrl.equals(page1Url)) {
                System.out.println("History test passed!");
            } else {
                System.out.println("History test failed!");
            }
        } catch (Exception e) {
            // Handle the exception
            System.out.println("Exception occurred during history test: " + e.getMessage());
        }
    }

    private void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    private void navigateBack() {
        driver.navigate().back();
    }

    private String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}