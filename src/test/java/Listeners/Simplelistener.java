package Listeners;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import scripts.BaseTest;

import java.io.File;
import java.io.IOException;

public class Simplelistener implements ITestListener {
    public void onTestStart(org.testng.ITestResult result) { /* compiled code */ }
    public void onTestSuccess(org.testng.ITestResult result) { /* compiled code
     */ }
    public void onTestFailure(org.testng.ITestResult result) {
        System.out.println("Screenshot captured for test case: " + result.getName());
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String filePath = "." + File.separator + "screenshots" + File.separator + result.getName() + ".png";
            File destFile = new File(filePath);
            //destFile.getParentFile().mkdirs();

            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void onTestSkipped(org.testng.ITestResult result) { /* compiled code */
    }
}
