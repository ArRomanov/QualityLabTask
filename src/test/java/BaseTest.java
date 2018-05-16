import helpers.AllureReportListener;
import helpers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static helpers.Data.CURRENT_BROWSER;

/**
 * The parent class for all test classes
 * with common methods
 */
@Listeners(AllureReportListener.class)
public class BaseTest {

    public WebDriver driver;

    /**
     * Getting web driver from factory
     */
    @BeforeMethod
    public void initWebDriver() {
        driver = WebDriverFactory.getWebDriver(CURRENT_BROWSER);
    }

    /**
     * Closing web driver
     */
    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
