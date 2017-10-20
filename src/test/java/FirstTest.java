import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
