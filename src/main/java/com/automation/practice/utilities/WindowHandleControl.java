package com.automation.practice.utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandleControl {

    public String getParentWindow(WebDriver driver) {
        String parentWindow = driver.getWindowHandle();
        return parentWindow;
    }

    public Set<String> getAllWindows(WebDriver driver) {
        Set<String> allWindows = driver.getWindowHandles();
        return allWindows;
    }

    public void switchToWindow(WebDriver driver, String switchwindow) {
        driver.switchTo().window(switchwindow);
    }

    public void getOnlyChildWindows(WebDriver driver) {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        allWindows.remove(parentWindow);
    }

}
