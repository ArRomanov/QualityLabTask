package pages;

import helpers.Urls;
import org.openqa.selenium.WebDriver;

/**
 * Page of authorization
 */
public class LoginPage extends Page {

    public static final String USER_LOGIN = "testovyjy";
    public static final String USER_SECRET = "Password0";

    public static final String DOMAIN_MAIL_RU = "@mail.ru";
    public static final String DOMAIN_BK_RU = "@bk.ru";

    private String loginFieldXpath = "//input[@id='mailbox:login']";
    private String secretFieldXpath = "//input[@id='mailbox:password']";
    private String dropDownDomainXpath = "//select[@id='mailbox:domain']";
    private String authButtonXpath = "//input[@value='Войти']";

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
        super.driver.get(Urls.MAIN_URL);
        return this;
    }

    /**
     * Authorization in mail
     * @param login - user's login
     * @param password - user's password
     * @param domain - mail's domain (You can use constants from this class)
     */
    public InboxEmailPage getAuthorization(String login, String password, String domain) {
        super
                .setTextInField(loginFieldXpath, login)
                .setTextInField(secretFieldXpath, password)
                .selectDropDown(dropDownDomainXpath, domain)
                .clickLMB(authButtonXpath);
        return new InboxEmailPage(driver);
    }


}
