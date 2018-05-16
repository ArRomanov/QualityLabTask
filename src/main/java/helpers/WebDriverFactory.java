package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * WebDriver factory
 */
public class WebDriverFactory {

    private static WebDriver chromeDriver;
    private static WebDriver fireFoxDriver;

    private static String pathToChromeDriverLinux = "src/test/resources/Drivers/chromedriver";
    private static String pathToChromeDriverWindows = "src/test/resources/Drivers/chromedriver.exe";
    private static String pathToFirefoxDriverLinux = "src/test/resources/Drivers/geckodriver";
    private static String pathToFirefoxDriverWindows = "src/test/resources/Drivers/geckodriver.exe";


    /**
     * Get web driver by a browser name
     * @param browserName - name of a browser which we will run (e.g. 'chrome', 'firefox')
     */
    public static WebDriver getWebDriver(String browserName) {
        initPropertiesForWebDriver();
        switch (browserName) {
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getFireFosDriver();
            default:
                return getFireFosDriver();
        }
    }

    /**
     * Singleton for ChromeDriver
     */
    private static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
            return new ChromeDriver();
        } else return chromeDriver;
    }

    /**
     * Singleton for GeckoDriver
     */
    private static WebDriver getFireFosDriver() {
        if (fireFoxDriver == null) {
            return new FirefoxDriver();
        } else return fireFoxDriver;
    }

    /**
     * Setting properties PATH_TO_DRIVER for different OS (Linux, Windows)
     */
    private static void initPropertiesForWebDriver() {
        String osName = "";
        osName = System.getProperty("os.name");
        if (osName.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", pathToChromeDriverLinux);
            System.setProperty("webdriver.gecko.driver", pathToFirefoxDriverLinux);
        } else if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", pathToChromeDriverWindows);
            System.setProperty("webdriver.gecko.driver", pathToFirefoxDriverWindows);
        }
    }
}
