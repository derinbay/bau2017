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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class FirstTest {

    WebDriver driver;
    String keyword = "samsung";

    @Before
    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/taylan/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.n11.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void myFirstTest() {
        WebElement searchBar = driver.findElement(By.id("searchData"));
        searchBar.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.className("iconSearch"));
        searchButton.click();
    }

    @Test
    public void shouldLogin() {
        login();

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
    }

    private void login() {
        WebElement loginButton = driver.findElement(By.className("btnSignIn"));
        loginButton.click();

        driver.findElement(By.id("email")).sendKeys("bau@bau.com");
        driver.findElement(By.id("password")).sendKeys("123qwe");
        driver.findElement(By.id("loginButton")).click();
    }

    @Test
    public void shouldLoginAndSearch() {
        login();

        String userName = driver.findElement(By.className("username")).getText();
        assertThat("When a buyer logged in", userName, equalTo("Test Bau"));

        WebElement searchBar = driver.findElement(By.id("searchData"));
        searchBar.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.className("iconSearch"));
        searchButton.click();

        List<WebElement> productList = driver.findElements(By.cssSelector("#view .productName"));
        List<WebElement> productList1 = driver.findElements(By.xpath("//*[@id='view']//*[contains(@class, 'productName')]"));

        for (WebElement product : productList) {
            String productTitle = product.getText().toLowerCase();
            System.out.println("Asserting: " + productTitle);
            assertTrue(productTitle.contains(keyword));
        }

//        for (int i=0; i < productList.size(); i++) {
//            assertTrue(productList.get(i).getText().toLowerCase().contains(keyword));
//        }
    }
}
