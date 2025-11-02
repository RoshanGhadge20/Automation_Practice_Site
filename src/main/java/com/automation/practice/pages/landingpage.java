package com.automation.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {

    WebDriver driver;

    public landingpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Object Pool for storing all webelements of landing page

    @FindBy(xpath = "//h1[@class='title']")
    WebElement pageTitle;

    // Action Methods for landing page
    public String verify_title() {
        String paget_title = pageTitle.getText();
        return paget_title;
    }

}
