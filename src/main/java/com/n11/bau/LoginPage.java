package com.n11.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login() {
        driver.findElement(By.id("email")).sendKeys("bau@bau.com");
        driver.findElement(By.id("password")).sendKeys("123qwe");
        driver.findElement(By.id("loginButton")).click();

        return new HomePage(driver);
    }
}
