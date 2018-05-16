import helpers.Email;
import org.testng.annotations.Test;
import pages.LoginPage;

import static helpers.Data.*;
import static pages.AfterSendMessagePage.GO_TO_INBOX_BUTTON;
import static pages.AfterSendMessagePage.TAB_TITLE;
import static pages.InboxEmailPage.NEW_MESSAGE_BUTTON;
import static pages.LoginPage.DOMAIN_MAIL_RU;
import static pages.LoginPage.LOGIN_FIELD_XPATH;

/**
 * Tests are for sending messages
 */
public class SendMailTests extends BaseTest {

    /**
     * Positive test is for sending message
     */
    @Test
    public void sendNewEmail() {
        LoginPage
                .getPage(driver)
                .openPage()
                .waitForAnyElement(LOGIN_FIELD_XPATH, 3)
                .getAuthorization(USER_LOGIN, USER_SECRET, DOMAIN_MAIL_RU)
                .waitForAnyElement(NEW_MESSAGE_BUTTON, 3)
                .goToNewEmail()
                .sendNewEmail(
                        new Email()
                                .setEmailAddress(CURRENT_USER_EMAIL_ADDRESS)
                                .setSubject("Subject for message")
                                .setBody("Body for message")
                )
                .waitForAnyElement(GO_TO_INBOX_BUTTON, 3)
                .checkTitle(TAB_TITLE);
    }
}
