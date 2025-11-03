package com.automation.practice.utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownElements {

    Select sc;

    public List<String> fetchOptionsFromDropdown(WebElement dropdownfield) {
        sc = new Select(dropdownfield);
        List<WebElement> dropdown_options = sc.getOptions();
        List<String> options = dropdown_options.stream().map(WebElement::getText).collect(Collectors.toList());
        return options;
    }

}
