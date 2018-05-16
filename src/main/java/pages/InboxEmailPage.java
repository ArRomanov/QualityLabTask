package pages;

import org.openqa.selenium.WebDriver;

/**
 * The page is for view all of mail
 */
public class InboxEmailPage extends Page {

    public static String newMessageButton = "//span[text()='Написать письмо']";

    public InboxEmailPage(WebDriver driver) {
        super(driver);
    }

}
