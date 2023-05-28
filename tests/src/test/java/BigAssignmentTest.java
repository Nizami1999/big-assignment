import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BigAssignmentTest {
    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu"); // Disable GPU acceleration
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();
    }

    // @Test
    public void testMainPage() {
        MainPage mainPage = new MainPage(driver);
        System.out.println(mainPage.getFooterText());
        Assert.assertTrue(mainPage.getFooterText().contains("ABOUT US"));

        // Subscribe to news and products
        mainPage.subscribeNews();
    }



    @Test
    public void loginAndLogoutTest() {
        // Login Page
        LoginPage loginPage = new LoginPage(driver);

        // Closing the opened modal
        loginPage.clickCloseModal();

        loginPage.setEmail("tafaj62942@farebus.com");
        loginPage.setPassword("Nizami620");
        loginPage.clickSubmit();

        // Logout from page
        UserPage user = new UserPage(driver);
        user.logoutButton();
    }

    @Test
    public void multiplePageTest() {
        MultiplePages multiplePageTest = new MultiplePages(driver);
        multiplePageTest.testMultiple();
    }

    @Test
    public void testHistoryPage() {
         // History class
        HistoryPage history = new HistoryPage();
        history.checkHistoryTest();
    }


    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    
}
