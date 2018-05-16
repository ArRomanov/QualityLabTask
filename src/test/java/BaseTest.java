import helpers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

/**
 * The parent class for all test classes
 * with common methods
 */
public class BaseTest {

    public WebDriver driver;

    /**
     * Getting web driver from factory
     */
    @BeforeMethod
    public void initWebDriver() {
        driver = WebDriverFactory.getWebDriver("chrome");
    }

    /**
     * Closing web driver
     */
    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
