package com.n11.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends PageUtils {

    By resultText = By.cssSelector(".resultText > h1");
    By breadCrumb = By.cssSelector("#breadCrumb li[itemprop='itemListElement'] > a");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getBreadCrumb() {
        return getText(breadCrumb).toLowerCase();
    }

    public String getResultText() {
        return getText(resultText).toLowerCase();
    }

    public WebElement addFirstProductToFavorites() {
        WebElement followBtn = driver.findElements(By.className("followBtn")).get(0);
        click(followBtn);

        return followBtn;
    }
}
