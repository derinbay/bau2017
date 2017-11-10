package com.n11.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBreadCrumb() {
        return driver.findElement(By.cssSelector("#breadCrumb li[itemprop='itemListElement'] > a")).getText().toLowerCase();
    }

    public String getResultText() {
        return driver.findElement(By.cssSelector(".resultText > h1")).getText().toLowerCase();
    }
}
