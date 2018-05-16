package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.By.xpath;

/**
 * The parent page class for all pages
 */
public class Page {

    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click by left mouse's button
     *
     * @param elementXpath - element's xpath for a click
     */
    public Page clickLMB(String elementXpath) {
        driver
                .findElement(xpath(elementXpath))
                .click();
        return this;
    }

    /**
     * Setting any text in any field
     *
     * @param fieldXpath - field's xpath
     * @param text       - text for insert
     */
    public Page setTextInField(String fieldXpath, String text) {
        WebElement textField = driver.findElement(xpath(fieldXpath));
        textField.clear();
        textField.sendKeys(text);
        return this;
    }

    /**
     * Select item from dropdown
     *
     * @param dropDownXpath - dropdown's xpath
     * @param text          - text of item for a choice
     */
    public Page selectDropDown(String dropDownXpath, String text) {
        Select dropdown = new Select(driver.findElement(xpath(dropDownXpath)));
        dropdown.selectByVisibleText(text);
        return this;
    }

    /**
     * Waiting for any element
     *
     * @param elementXpath - element's xpath
     * @param seconds - count of seconds for waiting for
     */
    public Page waitForAnyElement(String elementXpath, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(elementXpath)));
        return this;
    }

    /**
     * Checking of displayed any element
     *
     * @param elementXpath - element's xpath
     */
    public Page checkDisplayedOfElement(String elementXpath) {
        WebElement element = driver.findElement(xpath(elementXpath));
        if (!element.isDisplayed()) {
            Assert.fail("Element " + elementXpath + " not found");
        }
        return this;
    }


}
