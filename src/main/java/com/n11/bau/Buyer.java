package com.n11.bau;

import com.n11.bau.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buyer {

    String email;
    String password;
    String name;

    public Buyer(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HomePage login(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();
        return loginPage.login(this);
    }

    public void searchAndroid(WebDriver driver, String keyword) {
        AndroidHomePage androidHomePage = new AndroidHomePage(driver);
        androidHomePage.search(keyword);
        androidHomePage.closeTooltip();
    }

    public void clearMyFavorites(WebDriver driver) {
        MyFavoritesPage favoritesPage = new MyFavoritesPage(driver);
        PageUtils pageUtils = new PageUtils(driver);
        pageUtils.goTo(favoritesPage.getUrl());
        favoritesPage.deleteAllProducts();
    }
}
