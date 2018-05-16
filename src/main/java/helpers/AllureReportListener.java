package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static helpers.Data.CURRENT_BROWSER;

public class AllureReportListener implements ITestListener {

    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        driver = WebDriverFactory.getWebDriver(CURRENT_BROWSER);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        // Don't use
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            attachScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // Don't use
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // Don't use
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // Don't use
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // Don't use
    }

    @Attachment(value = "SCREENSHOT", type = "image/png")
    public byte[] attachScreenshot() throws IOException {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}

