package com.automation.practice.pages;

import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    WebDriverWait wait;

    public landingpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        drpElement = new DropdownElements();
        calenderControls = new WorkingwithCalenderControls();
        windowHandles = new WindowHandleControl();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

    // Dynamic Web Table
    @FindBy(xpath = "//table[@id='taskTable']/thead/tr/th")
    List<WebElement> dynamicTableHeadingField;

    @FindBy(xpath = "//tbody[@id='rows']/tr")
    List<WebElement> dynamicTableHeadingRowField;

    // Pagination Web Table
    @FindBy(xpath = "//ul[@id='pagination']/li")
    List<WebElement> paginationNumberField;

    @FindBy(xpath = "//table[@id='productTable']/thead/tr/th")
    List<WebElement> tableHeadingRowField;

    @FindBy(xpath = "//table[@id='productTable']/tbody/tr")
    List<WebElement> tableRowField;

    @FindBy(xpath = "//table[@id='productTable']/tbody/tr/td")
    List<WebElement> tableCellField;

    // Form Section
    @FindBy(css = "input#input1")
    WebElement section1InputField;

    @FindBy(css = "button#btn1")
    WebElement submit1ButtonField;

    @FindBy(css = "input#input2")
    WebElement section2InputField;

    @FindBy(css = "button#btn2")
    WebElement submit2ButtonField;

    @FindBy(css = "input#input3")
    WebElement section3InputField;

    @FindBy(css = "button#btn3")
    WebElement submit3ButtonField;

    // Footer Section Links
    @FindBy(css = "div#PageList1 div ul li a")
    List<WebElement> footerSectionLinksField;

    // Tab Section
    @FindBy(id = "Wikipedia1_wikipedia-search-input")
    WebElement searchBoxField;

    @FindBy(css = "input.wikipedia-search-button")
    WebElement searchButtonField;

    @FindBy(id = "Wikipedia1_wikipedia-search-results-header")
    WebElement searchResultText;

    @FindBy(css = "div#Wikipedia1_wikipedia-search-results div a")
    List<WebElement> searchResults;

    @FindBy(css = "div#Wikipedia1_wikipedia-search-results")
    WebElement NoResultFound;

    @FindBy(css = "div#Wikipedia1_wikipedia-search-more")
    WebElement moreSearchResultButton;

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

    public void staticTableSection() {
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

    public void dynamicTableSection() {

        // Printing all the values from dynamic of table
        for (WebElement webelement : dynamicTableHeadingField) {
            System.out.print(webelement.getText() + "\t");
        }
        System.out.println();
        for (int i = 2; i < dynamicTableHeadingRowField.size(); i++) {
            List<WebElement> celldata = driver.findElements(By.xpath("//tbody[@id='rows']/tr[" + i + "]/td"));
            for (WebElement element : celldata) {
                System.out.print(element.getText() + "\t");
            }
            System.out.println();
        }
    }

    public void fetchBrowserDetails(String browsername) {
        // Printing only specified of cell data
        for (int i = 2; i < dynamicTableHeadingRowField.size(); i++) {
            WebElement browsercolumnname = driver.findElement(By.xpath("//tbody[@id='rows']/tr[" + i + "]/td[1]"));

            if (browsername.equalsIgnoreCase(browsercolumnname.getText())) {
                // Fetch each column value
                String cpu = driver.findElement(
                        By.xpath("//tbody[@id='rows']/tr[" + i + "]/td[2]")).getText();

                String memory = driver.findElement(
                        By.xpath("//tbody[@id='rows']/tr[" + i + "]/td[3]")).getText();

                String network = driver.findElement(
                        By.xpath("//tbody[@id='rows']/tr[" + i + "]/td[4]")).getText();

                String disk = driver.findElement(
                        By.xpath("//tbody[@id='rows']/tr[" + i + "]/td[5]")).getText();

                System.out.println("Browser: " + browsername);
                System.out.println("CPU (%) : " + cpu);
                System.out.println("Memory  : " + memory);
                System.out.println("Network : " + network);
                System.out.println("Disk    : " + disk);

                break;
            }
        }
    }

    public void paginationWebTable() throws InterruptedException {
        // working with web table

        for (WebElement we : tableHeadingRowField) {
            System.out.print(we.getText() + "\t");
        }
        System.out.println();

        int paginationNumber = paginationNumberField.size();
        for (int i = 1; i <= paginationNumber; i++) {
            WebElement page = driver.findElement(By.xpath("//ul[@id='pagination']/li[" + i + "]"));
            page.click();
            Thread.sleep(1000);

            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
            for (int j = 1; j <= rows.size(); j++) {
                List<WebElement> cells = driver
                        .findElements(By.xpath("//table[@id='productTable']/tbody/tr[" + j + "]/td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + "\t");
                    // WebElement data = driver
                    // .findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + j +
                    // "]/td[2]"));
                    // if ((data.getText()).equalsIgnoreCase("Soundbar")) {
                    // System.out.println("---- Match Found ---");
                    // }

                }
                System.out.println();
            }
            System.out.println(" ------  End of Page ------ ");
        }
    }

    public void formSection() {
        if (section1InputField.isEnabled()) {
            section1InputField.sendKeys("Roshan Ghadge");
            submit1ButtonField.click();
        }

        if (section2InputField.isEnabled()) {
            section2InputField.sendKeys("Roshan Ghadge Roshan Ghadge");
            submit2ButtonField.click();
        }

        if (section3InputField.isEnabled()) {
            section3InputField.sendKeys("Roshan Ghadge Roshan Ghadge Roshan Ghadge ");
            submit3ButtonField.click();
        }
    }

    public void footerSectionLinks() {
        System.out.println("Total Number of links in footer section are :- " + footerSectionLinksField.size());
        for (int i = 0; i < footerSectionLinksField.size(); i++) {
            String URL = footerSectionLinksField.get(i).getAttribute("href");
            System.out.println("URL" + i + URL);
        }
    }

    public void tabSection() throws InterruptedException {
        searchBoxField.sendKeys("abcd");
        searchButtonField.click();
        wait.until(ExpectedConditions.visibilityOf(searchResultText));
        if (searchResults.size() == 0) {
            System.out.println(NoResultFound.getText());
        } else if (searchResults.size() > 0) {
            for (WebElement ele : searchResults) {
                System.out.println(ele.getText());
            }
        }
        wait.until(ExpectedConditions.visibilityOf(moreSearchResultButton));
        String parent_win = windowHandles.getParentWindow(driver);

        if (moreSearchResultButton.isDisplayed()) {
            moreSearchResultButton.click();
            windowHandles.getOnlyChildWindows(driver);
        }
        driver.switchTo().window(parent_win);
    }
}