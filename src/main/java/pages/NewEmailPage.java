package pages;

import helpers.Email;
import org.openqa.selenium.WebDriver;

/**
 * The page is for writing of a new message
 */
public class NewEmailPage extends Page {

    public static final String ADDRESS_FIELD_XPATH = "//textarea[@data-original-name='To']";
    public static final String SUBJECT_FIELD_XPATH = "//input[@name='Subject']";
    public static final String BODY_FIELD_IN_IFRAME_XPATH = "//*[@id='tinymce']";
    public static final String SEND_BUTTON = "//span[text()='Отправить']";


    private NewEmailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Creating of a page's object for view all mail
     */
    public static NewEmailPage getPage(WebDriver driver) {
        return new NewEmailPage(driver);
    }

    /**
     * Sending new email
     *
     * @param email - email object - new message (Email.class)
     */
    public AfterSendMessagePage sendNewEmail(Email email) {
        super
                .setTextInField(ADDRESS_FIELD_XPATH, email.getEmailAddress())
                .setTextInField(SUBJECT_FIELD_XPATH, email.getSubject())
                .switchToFrame(0)
                .setTextInField(BODY_FIELD_IN_IFRAME_XPATH, email.getBody())
                .switchToDefaultFrame()
                .clickLMB(SEND_BUTTON);
        return AfterSendMessagePage.getPage(super.driver);
    }
}
