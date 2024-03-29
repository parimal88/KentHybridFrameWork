package com.kent.testCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseClass {
    public static WebDriver driver;
    @BeforeSuite
    public void setUpBrowser()
    {
        String browserName = System.getenv("browserName");
        //String browserName = "chrome";
        if (browserName.toLowerCase().contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        }
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
