package com.n11.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLogin() {
        WebElement loginButton = driver.findElement(By.className("btnSignIn"));
        loginButton.click();

        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public String getUserName() {
        return driver.findElement(By.className("username")).getText();
    }

    public SearchResultPage search(String keyword) {
        type(By.id("searchData"), keyword);
        click(By.className("searchBtn"));

        return new SearchResultPage(driver);
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
}
