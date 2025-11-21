package com.automation.practice.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.practice.baseTest.BaseTest;

public class TakeScreenShot extends BaseTest {

    TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
    File desFile = new File("E://Automation Testing Practice//automationtet//Reports//screenShots");

    public void captureScreenShot() throws FileNotFoundException, IOException {
        File scrFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, desFile);
        System.out.println("ScreenShot captured and saved to folder");
    }

}
