package com.automation.practice.baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automation.practice.configurations.browserConfigurations;
import com.automation.practice.utilities.Log;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

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
        Log.info("Fetched Properties & configuration from properties file");
        try {
            if (browser_name.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(browserConfigurations.chromeoptions());
                Log.info("Chrome Browser Invoked");
                driver.get(testURL);
                driver.manage().window().maximize();
            } else if (browser_name.equalsIgnoreCase("firefox")) {
                FirefoxDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(browserConfigurations.firefoxoptions());
                Log.info("Firefox Browser Invoked");
                driver.get(testURL);
                driver.manage().window().maximize();
            }
        } catch (Exception e) {
            Log.error("Exception caught while initializing the browser in baseTest");
            System.out.println("Exception Caught while initializing the driver object :- " + e.getMessage());
        } finally {
            fis.close();
            Log.info("properties file connection gets closed.");
        }
    }

    @AfterTest
    public void deactivate_driver() {
        try {
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                Log.info("All browser windows gets quited with clearing all cookies");
            }
        } catch (Exception e) {
            Log.info("Exception caught while deactivating brwoser object");
            System.out.println("Exception caught while deactivating driver object :- " + e.getMessage());
        }
    }

}
