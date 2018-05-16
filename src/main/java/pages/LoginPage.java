package pages;

import org.openqa.selenium.WebDriver;

import static helpers.Urls.MAIN_URL;

/**
 * Page of authorization
 */
public class LoginPage extends Page {

    public static final String DOMAIN_MAIL_RU = "@mail.ru";
    public static final String DOMAIN_BK_RU = "@bk.ru";

    public static final String LOGIN_FIELD_XPATH = "//input[@name='login']";
    public static final String PSWD_FIELD_XPATH = "//input[@name='password']";
    public static final String DROPDOWN_DOMAIN_XPATH = "//select[@id='mailbox:domain']";
    public static final String AUTH_BUTTON_XPATH = "//input[@value='Войти']";

    private LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Creating of a page's object for authorization
     */
    public static LoginPage getPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    /**
     * Opening of a page for auth
     */
    public LoginPage openPage() {
        super.driver.get(MAIN_URL);
        return this;
    }

    /**
     * Authorization in mail
     *
     * @param login    - user's login
     * @param password - user's password
     * @param domain   - mail's domain (You can use constants from this class)
     */
    public InboxEmailPage getAuthorization(String login, String password, String domain) {
        super
                .setTextInField(LOGIN_FIELD_XPATH, login)
                .setTextInField(PSWD_FIELD_XPATH, password)
                .selectDropDown(DROPDOWN_DOMAIN_XPATH, domain)
                .clickLMB(AUTH_BUTTON_XPATH);
        return InboxEmailPage.getPage(super.driver);
    }

    /**
     * Waiting for any element (overridden method from parent page)
     *
     * @param elementXpath - element's xpath
     * @param seconds      - count of seconds for waiting for
     */
    @Override
    public LoginPage waitForAnyElement(String elementXpath, int seconds) {
        super.waitForAnyElement(elementXpath, seconds);
        return this;
    }
}
