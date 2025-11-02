package com.automation.tests;

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

}
