import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    @Test
    public void myFirstTest() {
//        System.setProperty("webdriver.chrome.driver", "/Users/taylan/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.n11.com");

        WebElement searchBar = driver.findElement(By.id("searchData"));
        searchBar.sendKeys("samsung");

        WebElement searchButton = driver.findElement(By.className("iconSearch"));
        searchButton.click();

        driver.close();
    }

    @Test
    public void shouldLogin() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.n11.com");

        String keyword = "Samsung";

        WebElement loginButton = driver.findElement(By.className("btnSignIn"));
        loginButton.click();

        driver.findElement(By.id("email")).sendKeys("bau@bau.com");
        driver.findElement(By.id("password")).sendKeys("123qwe");
        driver.findElement(By.id("loginButton")).click();

        String userName = driver.findElement(By.className("username")).getText();
        assertThat("When a buyer logged in", userName, equalTo("Test Bau"));

        driver.findElement(By.id("searchData")).sendKeys(keyword);
        driver.findElement(By.className("searchBtn")).click();

        String breadCrumbText = driver.findElement(By.cssSelector("#breadCrumb li[itemprop=\"itemListElement\"] > a")).getText();
        assertTrue(breadCrumbText.equals(keyword));

        String resultText = driver.findElement(By.cssSelector(".resultText > h1")).getText();
        String text = driver.findElement(By.xpath("//*[@class='resultText']/h1")).getText();
        driver.findElement(By.xpath("//*[@class='group setGroup keywordBannerGroup']//li[1]/a"));
        assertTrue(resultText.equals(keyword));

        driver.close();
    }
}
