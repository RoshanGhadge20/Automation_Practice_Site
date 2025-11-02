package com.automation.practice.configurations;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class browserConfigurations {

    public static ChromeOptions chromeoptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        HashMap<String, Object> pref = new HashMap<>();
        pref.put("download.default_directory", System.getProperty("user.dir") + "\\downloads");
        pref.put("credentials_enable_service", false);
        pref.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", pref);

        return options;
    }

    public static FirefoxOptions firefoxoptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        return options;

    }
}
