package com.n11.bau;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/taylan/Downloads/chromedriver");
        System.out.println(testName.getMethodName());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.n11.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
