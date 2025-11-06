package com.automation.practice.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingwithCalenderControls {

    public void selectDateFromCalender(WebDriver driver, WebElement calendericon, String exDate, String exMonth,
            String exYear) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        calendericon.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#ui-datepicker-div")));

        while (true) {
            String currentMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
            String acMonth = currentMonthYear.split(" ")[0];
            String acYear = currentMonthYear.split(" ")[1];

            if (acMonth.equalsIgnoreCase(exMonth) && acYear.equals(exYear))
                break;

            driver.findElement(By.xpath("//a[@data-handler='next']")).click();
        }

        driver.findElement(By.xpath("//a[normalize-space()='" + exDate + "']")).click();
    }

}
