package com.n11.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        driver.findElement(By.id("searchData")).sendKeys(keyword);
        driver.findElement(By.className("searchBtn")).click();

        return new SearchResultPage(driver);
    }
}
