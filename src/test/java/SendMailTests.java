import org.testng.annotations.Test;
import pages.InboxEmailPage;
import pages.LoginPage;

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
                .getAuthorization(LoginPage.USER_LOGIN, LoginPage.USER_SECRET, LoginPage.DOMAIN_MAIL_RU)
                .waitForAnyElement(InboxEmailPage.newMessageButton, 4);
    }
}
