package com.automation.practice.utilities;

import org.openqa.selenium.Alert;

import com.automation.practice.baseTest.BaseTest;

public class Alerts extends BaseTest {

    Alert alert = driver.switchTo().alert();

    public String getAlertMessage() {
        String alert_message = alert.getText();
        return alert_message;
    }

    public void acceptAlert() {
        alert.accept();
    }

    public void confirmationAlertAccept() {
        alert.accept();
    }

    public void confirmationAlertDismiss() {
        alert.dismiss();
    }

    public void promptAlertAccept(String inputText) {
        alert.sendKeys(inputText);
        alert.accept();
    }

    public void dismissAlert() {
        alert.dismiss();
    }

}
