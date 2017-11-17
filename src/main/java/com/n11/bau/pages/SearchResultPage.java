package com.n11.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public WebElement addFirstProductToFavorites() {
        WebElement followBtn = driver.findElements(By.className("followBtn")).get(0);
        followBtn.click();

        return followBtn;
    }
}
