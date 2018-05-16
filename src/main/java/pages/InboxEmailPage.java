package pages;

import org.openqa.selenium.WebDriver;

/**
 * The page is for view all of mail
 */
public class InboxEmailPage extends Page {

    public static final String NEW_MESSAGE_BUTTON = "//span[text()='Написать письмо']";

    private InboxEmailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Creating of a page's object for view all mail
     */
    public static InboxEmailPage getPage(WebDriver driver) {
        return new InboxEmailPage(driver);
    }

    /**
     * Waiting for any element (overridden method from parent page)
     *
     * @param elementXpath - element's xpath
     * @param seconds - count of seconds for waiting for
     */
    @Override
    public InboxEmailPage waitForAnyElement(String elementXpath, int seconds){
        super.waitForAnyElement(elementXpath, seconds);
        return this;
    }

    /**
     * Moving on a page for a new message
     */
    public NewEmailPage goToNewEmail() {
        super.clickLMB(NEW_MESSAGE_BUTTON);
        return NewEmailPage.getPage(super.driver);
    }

}
