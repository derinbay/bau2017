package com.n11.bau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageUtils {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By searchBar = By.id("searchData");
    By searchButton = By.className("searchBtn");
    By userName = By.className("username");
    By loginButton = By.className("btnSignIn");

    public LoginPage clickLogin() {
        click(loginButton);
        return new LoginPage(driver);
    }

    public String getUserName() {
        return getText(userName);
    }

    public SearchResultPage search(String keyword) {
        type(searchBar, keyword);
        click(searchButton);

        return new SearchResultPage(driver);
    }
}
