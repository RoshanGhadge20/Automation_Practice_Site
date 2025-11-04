package com.automation.practice.utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownElements {

    Select sc;

    // Public method to fetchalloptions from dropdown
    public List<String> fetchOptionsFromDropdown(WebElement dropdownfield) {
        sc = new Select(dropdownfield);
        List<WebElement> dropdown_options = sc.getOptions();
        List<String> options = dropdown_options.stream().map(WebElement::getText).collect(Collectors.toList());
        return options;
    }

    // Public method to fetch selectedoptions from dropdown
    public List<String> fetchSelectedOptionsFromDropdown(WebElement dropdownfield) {
        sc = new Select(dropdownfield);
        List<WebElement> selected_options = sc.getAllSelectedOptions();
        List<String> options = selected_options.stream().map(WebElement::getText).collect(Collectors.toList());
        return options;
    }

    // Public method to select option from value
    public void selectByDropdownValue(WebElement dropdownfield, String value) {
        sc = new Select(dropdownfield);
        sc.selectByValue(value);
    }

    // Public method to select option from index
    public void selectByDropdownIndex(WebElement dropdownfield, int index) {
        sc = new Select(dropdownfield);
        sc.selectByIndex(index);
    }

    // Public method to select option from select by visible text
    public void selectByDropdownVisibleText(WebElement dropdownfield, String VisibleText) {
        sc = new Select(dropdownfield);
        sc.selectByContainsVisibleText(VisibleText);
    }
}
