package com.n11.bau;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

        List<WebElement> productList = driver.findElements(By.cssSelector("#view .productName"));

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

        SearchResultPage searchResultPage = homePage.search(keyword);
        WebElement followBtn = searchResultPage.addFirstProductToFavorites();

        PageUtils utils = new PageUtils(driver);
        String classAttributes = utils.getAttributes(followBtn, "class");
        assertTrue(classAttributes.contains("ok"));

        MyFavoritesPage favoritesPage = new MyFavoritesPage(driver);
        utils.goTo(favoritesPage.url);


        List<WebElement> products = favoritesPage.getProducts();
        Boolean isProductExist = favoritesPage.isProductExist(keyword, products);

        assertTrue("When a buyer adds a product to favorites", isProductExist);
    }
}
