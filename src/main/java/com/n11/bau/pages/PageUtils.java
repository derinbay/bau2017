package com.n11.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void type(By byLocator, String keyword) {
        driver.findElement(byLocator).clear();
        driver.findElement(byLocator).sendKeys(keyword);
    }

    public void click(WebElement element) {
        waitForElement(element, 10);
        element.click();
    }

    public void click(By byLocator) {
        waitForElement(driver.findElement(byLocator), 10);
        driver.findElement(byLocator).click();
    }

    public void waitForElement(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getText(By byLocator) {
        return driver.findElement(byLocator).getText();
    }
}
