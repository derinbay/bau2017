package com.n11.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        waitForElement(byLocator, 10);
        scrollTo(byLocator);
        driver.findElement(byLocator).clear();
        driver.findElement(byLocator).sendKeys(keyword);
    }

    public void click(WebElement element) {
        waitForElement(element, 10);
        scrollTo(element);
        element.click();
    }

    public void click(By byLocator) {
        waitForElement(byLocator, 10);
        scrollTo(byLocator);
        driver.findElement(byLocator).click();
    }

    public void waitForElement(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        scrollTo(element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement(By byLocator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }

    public String getText(By byLocator) {
        waitForElement(byLocator, 10);
        scrollTo(byLocator);
        return driver.findElement(byLocator).getText();
    }

    public Object js(String script) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        return jse.executeScript(script);
    }

    public void scrollTo(WebElement element) {
        int yCoord = element.getLocation().getY() - 200;
        String script = "scrollTo(" + element.getLocation().x + ", " + yCoord  + ")";
        js(script);
//        String script2 = "arguments[0].scrollIntoView(true)";
//        ((JavascriptExecutor) driver).executeScript(script2, element);
    }

    public void scrollTo(By byLocator) {
        scrollTo(driver.findElement(byLocator));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
