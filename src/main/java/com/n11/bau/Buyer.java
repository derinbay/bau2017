package com.n11.bau;

import com.n11.bau.pages.HomePage;
import com.n11.bau.pages.LoginPage;
import com.n11.bau.pages.MyFavoritesPage;
import com.n11.bau.pages.PageUtils;
import org.openqa.selenium.WebDriver;

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

    public void clearMyFavorites(WebDriver driver) {
        MyFavoritesPage favoritesPage = new MyFavoritesPage(driver);
        PageUtils pageUtils = new PageUtils(driver);
        pageUtils.goTo(favoritesPage.getUrl());
        favoritesPage.deleteAllProducts();
    }
}
