import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendMailTests {

    public WebDriver driver;

    @BeforeMethod
    public void initWebDriver(){
        driver = WebDriverFactory.getWebDriver("chrome");
    }

    @Test
    public void sendNewEmail(){
    }
}
