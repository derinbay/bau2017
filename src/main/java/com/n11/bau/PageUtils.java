package com.n11.bau;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class PageUtils {

    WebDriver driver;

    public PageUtils(WebDriver driver) {
        this.driver = driver;
    }

    public String getAttributes(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public void goTo(String url) {
        driver.get(url);
    }
}
