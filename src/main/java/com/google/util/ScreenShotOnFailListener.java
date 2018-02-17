package com.google.util;

import com.google.common.io.Files;
import com.google.core.WebDriverTestBase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailListener implements ITestListener {
    private  WebDriver driver;
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure  (ITestResult iTestResult) {
         driver = ((WebDriverTestBase) iTestResult.getInstance()).driver;
            saveScreenshot( iTestResult.getMethod().getQualifiedName() );
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveScreenshot(String qualifiedName) {
        return ((TakesScreenshot) driver).getScreenshotAs( OutputType.BYTES);
    }
}