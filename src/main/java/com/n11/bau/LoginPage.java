package com.n11.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By email = By.id("email");
    By password = By.id("password");
    By loginButton = By.id("loginButton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(Buyer buyer) {
        driver.findElement(email).sendKeys(buyer.getEmail());
        driver.findElement(password).sendKeys(buyer.getPassword());
        driver.findElement(loginButton).click();

        return new HomePage(driver);
    }
}
