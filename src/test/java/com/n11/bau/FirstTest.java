package com.n11.bau;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class FirstTest extends BaseTest {

    String keyword = "samsung";

    @Test
    public void myFirstTest() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.search(keyword);

        assertTrue(searchResultPage.getBreadCrumb().equals(keyword));
    }

    @Test
    public void shouldLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login();

        assertThat("When a buyer logged in", homePage.getUserName(), equalTo("Test Bau"));

        SearchResultPage searchResultPage = homePage.search(keyword);

        assertTrue(searchResultPage.getBreadCrumb().equals(keyword));

        assertTrue(searchResultPage.getResultText().equals(keyword));
    }

    @Test
    public void shouldLoginAndSearch() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login();

        assertThat("When a buyer logged in", homePage.getUserName(), equalTo("Test Bau"));

        homePage.search(keyword);

        List<WebElement> productList = driver.findElements(By.cssSelector("#view .productName"))

        for (WebElement product : productList) {
            String productTitle = product.getText().toLowerCase();
            System.out.println("Asserting: " + productTitle);
            assertTrue(productTitle.contains(keyword));
        }
    }

    @Test
    public void shouldAddToFavorites() {
        String keyword = "adidas";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        homePage = loginPage.login();

        homePage.search(keyword);

        WebElement followBtn = driver.findElement(By.className("followBtn"));
        followBtn.click();
//        driver.findElements(By.className("followBtn")).get(0).click();
//        driver.findElement(By.xpath("//*[@class='textImg followBtn']")).click();
//        driver.findElement(By.xpath("//*[contains(@class, 'followBtn'])")).click();
//        driver.findElement(By.cssSelector("#view .column .followBtn")).click();
        String classAttributes = followBtn.getAttribute("class");
        assertTrue(classAttributes.contains("ok"));

        driver.get("https://www.n11.com/hesabim/favorilerim");
        List<WebElement> products = driver.findElements(By.cssSelector("#view .column .productName"));

        Boolean isProductExist = false;
        for (WebElement product : products) {
            isProductExist = product.getText().contains(keyword);
            if (isProductExist) {
                break;
            }
        }

        assertTrue("When a buyer adds a product to favorites", isProductExist);
    }
}
