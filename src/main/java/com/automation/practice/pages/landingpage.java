package com.automation.practice.pages;

import java.util.List;
import java.util.stream.Collectors;

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

    // Header Section
    @FindBy(xpath = "//h1[@class='title']")
    private WebElement pageTitle;

    @FindBy(css = "div#crosscol div.widget-content ul li")
    private List<WebElement> widgetOptions;

    // GUI Element Sections
    @FindBy(css = "input#name")
    private WebElement nameField;

    @FindBy(css = "input#email")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneField;

    @FindBy(css = "div.form-group textarea.form-control")
    private WebElement addressField;

    @FindBy(xpath = "//div[@class='form-group']/div/input[@id='male']")
    private WebElement genderField;

    // Action Methods for landing page
    public String verify_title() {
        String paget_title = pageTitle.getText();
        return paget_title;
    }

    public List<String> widget_header() {
        List<String> header_options = widgetOptions.stream().map(WebElement::getText).collect(Collectors.toList());
        return header_options;
    }

    public void gui_section() {
        nameField.sendKeys("Roshan");
        emailField.sendKeys("roshanghadge20@gmail.com");
        phoneField.sendKeys("8767003565");
        addressField.sendKeys("Sample Text is adding it into the textarea for testing purpose");
        genderField.click();
    }
}
