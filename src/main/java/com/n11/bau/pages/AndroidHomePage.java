package com.n11.bau.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AndroidHomePage extends PageUtils {

    By closeBtn = MobileBy.id("com.dmall.mfandroid:id/closeBtn");

    public AndroidHomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String keyword) {
        clickMobile(closeBtn);
        clickMobile(By.id("com.dmall.mfandroid:id/mainHeaderSearchBox"));
        typeMobile(By.id("com.dmall.mfandroid:id/clearable_edit"), keyword);
        clickMobile(MobileBy.id("com.dmall.mfandroid:id/keywordTV"));
    }

    public void closeTooltip() {
        clickMobile(MobileBy.id("com.dmall.mfandroid:id/tooltipCloseImage"));
    }
}
