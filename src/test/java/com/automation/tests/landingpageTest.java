package com.automation.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.practice.baseTest.BaseTest;
import com.automation.practice.pages.landingpage;

public class landingpageTest extends BaseTest {

    landingpage lp;

    @BeforeMethod
    public void setuppage() {
        lp = new landingpage(driver);
    }

    @Test(priority = 1)
    public void verify_page_title() {
        String actual_page_title = lp.verify_title();
        Assert.assertEquals(actual_page_title, "Automation Testing Practice");
    }

    @Test(priority = 2)
    public void verify_widget_header() {
        List<String> actual_header_option = lp.widget_header();
        List<String> expected_header_option = Arrays.asList("Home", "Udemy Courses", "Online Trainings", "Blog",
                "PlaywrightPractice");

        Assert.assertEquals(actual_header_option, expected_header_option,
                "Widget Options are does not matched correctly");
        for (String option : actual_header_option) {
            System.out.println("Header Options :- " + option);
        }
    }

    @Test(priority = 3)
    public void verify_gui_section() throws InterruptedException {
        List<String> actual_dropdown_options = lp.gui_section();
        List<String> expected_dropdown_options = Arrays.asList("United States", "Canada", "United Kingdom", "Germany",
                "France", "Australia", "Japan", "China", "Brazil", "India");
        Assert.assertEquals(actual_dropdown_options, expected_dropdown_options,
                "Dropdown Options does not match correctly");
        System.out.println("Test Executed Completely for GUI Section");
    }

    @Test(priority = 4)
    public void verify_homeSection() throws InterruptedException {
        lp.homeSection();
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void verify_uploadFileSection() throws InterruptedException {
        lp.uploadFilesSection();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void verify_staticTableSection() throws InterruptedException {
        lp.staticTableSection();
    }

    @Test(priority = 7)
    public void verify_dynamicTableSection() {
        lp.dynamicTableSection();
    }

    @Test(priority = 8)
    public void verify_paginationWebTable() throws InterruptedException {
        lp.paginationWebTable();
    }

    @Test(priority = 9)
    public void verify_formSection() {
        lp.formSection();
    }
}
