package com.n11.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyFavoritesPage extends PageUtils {

    public String getUrl() {
        return url;
    }

    String url = "https://www.n11.com/hesabim/favorilerim";

    public MyFavoritesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProducts() {
        return driver.findElements(By.cssSelector("#view .column .productName"));
    }

    public Boolean isProductExist(String keyword, List<WebElement> products) {
        Boolean isProductExist = false;
        for (WebElement product : products) {
            isProductExist = product.getText().contains(keyword);
            if (isProductExist) {
                break;
            }
        }
        return isProductExist;
    }
}
