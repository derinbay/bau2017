package com.n11.bau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyFavoritesPage {

    WebDriver driver;
    String url = "https://www.n11.com/hesabim/favorilerim";

    public MyFavoritesPage(WebDriver driver) {
        this.driver = driver;
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
