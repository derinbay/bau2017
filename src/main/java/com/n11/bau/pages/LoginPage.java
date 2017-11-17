package com.n11.bau.pages;

import com.n11.bau.Buyer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageUtils {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By email = By.id("email");
    By password = By.id("password");
    By loginButton = By.id("loginButton");

    public HomePage login(Buyer buyer) {
        type(email, buyer.getEmail());
        type(password, buyer.getPassword());
        click(loginButton);

        return new HomePage(driver);
    }
}
