package com.n11.bau;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    public static String BROWSER_NAME;
    public static boolean REMOTE;

    static {
        REMOTE = isRemote();
        BROWSER_NAME = getBrowserName();
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void startUp() throws MalformedURLException {
        System.out.println(testName.getMethodName());
        if (!REMOTE) {
            if (BROWSER_NAME.equals("chrome")) {
//        System.setProperty("webdriver.chrome.driver", "/Users/taylan/Downloads/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("http://www.n11.com");
            } else if (BROWSER_NAME.equals("firefox")) {
//        System.setProperty("webdriver.gecko.driver", "/Users/taylan/Downloads/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get("http://www.n11.com");
            } else if (BROWSER_NAME.equals("android")) {
                driver = new AndroidDriver(getCapabilities());
            }
        } else {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        }
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.VERSION, "7.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/taylan/Downloads/n11.apk");
        capabilities.setCapability("appActivity", "com.dmall.mfandroid.activity.base.NHomeActivity");
        capabilities.setCapability("newCommandTimeout", 30000);

        return capabilities;
    }

    @After
    public void tearDown() {
        driver.close();
    }

    private static boolean isRemote() {
        String remoteValue = System.getProperties().getProperty("remote");
        return Boolean.parseBoolean(remoteValue);
    }

    private static String getBrowserName() {
        return System.getProperties().getProperty("browser");
    }
}
