package com.n11.bau.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.n11.bau.Config.WAITFORELEMENT;
import static com.n11.bau.Config.WAITFORSTATIC;

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
        waitForAjax();
    }

    public void type(By byLocator, String keyword) {
        waitForElement(byLocator, WAITFORELEMENT);
        scrollTo(byLocator);
        driver.findElement(byLocator).clear();
        driver.findElement(byLocator).sendKeys(keyword);
        waitForAjax();
    }

    public void click(WebElement element) {
        waitForElement(element, WAITFORELEMENT);
        scrollTo(element);
        element.click();
        waitForAjax();
    }

    public void click(By byLocator) {
        waitForElement(byLocator, WAITFORELEMENT);
        scrollTo(byLocator);
        driver.findElement(byLocator).click();
        waitForAjax();
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
        waitForElement(byLocator, WAITFORELEMENT);
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
        waitForAjax();
//        String script2 = "arguments[0].scrollIntoView(true)";
//        ((JavascriptExecutor) driver).executeScript(script2, element);
    }

    private void waitForAjax() {
        WebDriverWait wait = new WebDriverWait(driver, WAITFORELEMENT);
        ExpectedCondition<Boolean> check = input -> {
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            boolean ajaxIsRunning = (Boolean) jsDriver
                    .executeScript("return window.jQuery != undefined && jQuery.active != 0");
            return !ajaxIsRunning;
        };

        wait.until(check);
    }

    public void scrollTo(By byLocator) {
        scrollTo(driver.findElement(byLocator));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickMobile(By by) {
        driver.findElement(by).click();
        waitFor(WAITFORSTATIC);
    }

    public void typeMobile(By by, String keyword) {
        driver.findElement(by).sendKeys(keyword);
        waitFor(WAITFORSTATIC);
    }

    public void waitFor(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
