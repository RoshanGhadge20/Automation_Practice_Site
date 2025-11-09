package com.automation.practice.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.practice.utilities.DropdownElements;
import com.automation.practice.utilities.WindowHandleControl;
import com.automation.practice.utilities.WorkingwithCalenderControls;

public class landingpage {

    WebDriver driver;
    DropdownElements drpElement;
    WorkingwithCalenderControls calenderControls;
    WindowHandleControl windowHandles;
    JavascriptExecutor js;

    public landingpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        drpElement = new DropdownElements();
        calenderControls = new WorkingwithCalenderControls();
        windowHandles = new WindowHandleControl();
        js = (JavascriptExecutor) driver;
    }

    /*---- Object Pool for storing all webelements of landing page ----*/

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

    @FindBy(xpath = "//input[@id='sunday']")
    private WebElement sundayField;

    @FindBy(xpath = "//input[contains(@id,'monday')]")
    private WebElement mondayField;

    @FindBy(css = "select#country")
    private WebElement dropdownField;

    @FindBy(css = "select#colors")
    private WebElement colorDropDownField;

    @FindBy(css = "select.form-control[id='animals']")
    private WebElement sortedsListSectionField;

    @FindBy(css = "select.form-control[id='animals'] option")
    private List<WebElement> sortedListField;

    @FindBy(xpath = "//input[@id='datepicker']")
    private WebElement datepicker1Field;

    @FindBy(css = "input#txtDate")
    private WebElement datepicker2Field;

    @FindBy(css = "input#start-date")
    private WebElement datepicker3StartDateField;

    @FindBy(css = "input#end-date")
    private WebElement datepicker3EndDateField;

    // Home Section
    @FindBy(css = "div#blog-pager a")
    private WebElement homeSectionField;

    @FindBy(css = "div.feed-links a")
    private WebElement subscribeToField;

    // Upload Files Sections
    @FindBy(css = "#singleFileInput")
    WebElement uploadSingleFileField;

    @FindBy(css = "form#singleFileForm button")
    WebElement uploadSingleFileButtonField;

    @FindBy(css = "form#multipleFilesForm input")
    WebElement uploadMultipleFileField;

    @FindBy(css = "form#multipleFilesForm button")
    WebElement uploadMultipleFileButtonField;

    // Static Web Table
    @FindBy(xpath = "//table[@name='BookTable']/tbody/tr/th")
    List<WebElement> staticTableHeadingField;

    @FindBy(xpath = "//table[@name='BookTable']/tbody/tr")
    List<WebElement> staticTableHeadingRowField;

    @FindBy(xpath = "//table[@name='BookTable']/tbody/tr/td")
    List<WebElement> staticTableDataField;

    /*---- Action Methods for landing page  ---*/
    public String verify_title() {
        String paget_title = pageTitle.getText();
        return paget_title;
    }

    public List<String> widget_header() {
        List<String> header_options = widgetOptions.stream().map(WebElement::getText).collect(Collectors.toList());
        return header_options;
    }

    public List<String> gui_section() {
        // working with textfields
        nameField.sendKeys("Roshan");
        emailField.sendKeys("roshanghadge20@gmail.com");
        phoneField.sendKeys("8767003565");

        // working with textareas
        addressField.sendKeys("Sample Text is adding it into the textarea for testing purpose");

        // working with toggle buttons
        genderField.click();

        // Clicking on two checkboxs
        sundayField.click();
        mondayField.click();

        // working with select dropdown options
        List<String> dropdown_options = drpElement.fetchOptionsFromDropdown(dropdownField);
        drpElement.selectByDropdownVisibleText(dropdownField, "India");

        // Working with color dropdown field
        drpElement.selectMultipleValues(colorDropDownField, "Red", "Green");

        // working with sorted list element
        List<String> actualList = sortedListField.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> expectedSortedList = new ArrayList<>(actualList);
        Collections.sort(expectedSortedList);
        Assert.assertEquals(actualList, expectedSortedList, "List are not sorted");

        // Working with datepicker1 > From calender icon
        calenderControls.selectDateFromCalender(driver, datepicker1Field, "26", "November", "2026");

        // Working with datepicker2 > with the help of javascriptexecutor
        js.executeScript("arguments[0].value='01/01/2025';", datepicker2Field);

        // Working with datepicker3 > selecting the date range (start date & end date)
        datepicker3StartDateField.sendKeys("01/01/2025");
        datepicker3EndDateField.sendKeys("10/10/2025");

        return dropdown_options;
    }

    public void homeSection() {
        // Clicking on home section
        homeSectionField.click();

        // Subscribe to section
        String parentWindow = windowHandles.getParentWindow(driver);
        subscribeToField.click();
        driver.switchTo().window(parentWindow);
    }

    public void uploadFilesSection() throws InterruptedException {
        // Working with the file uploads
        if (uploadSingleFileField.isEnabled()) {

            uploadSingleFileField.sendKeys(
                    "E:\\Automation Testing Practice\\automationtet\\src\\test\\java\\com\\automation\\resources\\TestData\\SampleTest.pdf");
            uploadSingleFileButtonField.click();
            Thread.sleep(3000);
        }

        if (uploadMultipleFileField.isEnabled()) {
            uploadMultipleFileField.sendKeys(
                    "E:\\Automation Testing Practice\\automationtet\\src\\test\\java\\com\\automation\\resources\\TestData\\SampleTest.pdf\n"
                            + "E:\\Automation Testing Practice\\automationtet\\src\\test\\java\\com\\automation\\resources\\TestData\\SampleTest.pdf");
            uploadSingleFileButtonField.click();
            Thread.sleep(3000);
        }
    }

    public void staticTableSection() throws InterruptedException {
        // Firstly Iterate through the table to fetch all the values from it
        for (WebElement we : staticTableHeadingField) {
            System.out.print(we.getText() + "\t");
        }
        System.out.println();

        for (int i = 2; i < staticTableHeadingRowField.size(); i++) {

            List<WebElement> rowCells = driver.findElements(
                    By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td"));
            for (WebElement cell : rowCells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }

    }
}
