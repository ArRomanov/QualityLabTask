package pages;

import org.openqa.selenium.WebDriver;

public class AfterSendMessagePage extends Page {

    public static final String GO_TO_INBOX_BUTTON = "//a[text()='Перейти во Входящие']";
    public static final String TAB_TITLE = "Письмо отправлено - Почта Mail.Ru";

    private AfterSendMessagePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Creating of a page's object for check that message sent
     */
    public static AfterSendMessagePage getPage(WebDriver driver) {
        return new AfterSendMessagePage(driver);
    }
}
