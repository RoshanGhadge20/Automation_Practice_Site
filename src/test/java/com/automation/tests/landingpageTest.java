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

}
