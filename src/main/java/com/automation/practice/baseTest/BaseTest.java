package com.automation.practice.baseTest;

import com.automation.practice.configurations.browserConfigurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public Properties prop;
    public WebDriver driver;

    @BeforeTest
    public void Initialize_Driver() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(
                "src\\main\\java\\com\\automation\\practice\\properties\\browserProperties.properties");
        prop = new Properties();
        prop.load(fis);

        String browser_name = (String) prop.get("Browser");
        String testURL = (String) prop.get("URL");
        try {
            if (browser_name.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(browserConfigurations.chromeoptions());
                driver.get(testURL);
                driver.manage().window().maximize();
            } else if (browser_name.equalsIgnoreCase("firefox")) {
                FirefoxDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(browserConfigurations.firefoxoptions());
                driver.get(testURL);
                driver.manage().window().maximize();
            }
        } catch (Exception e) {
            System.out.println("Exception Caught while initializing the driver object :- " + e.getMessage());
        } finally {
            fis.close();
        }
    }

    @AfterTest
    public void deactivate_driver() {
        try {
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Exception caught while deactivating driver object :- " + e.getMessage());
        }
    }

}
