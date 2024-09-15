package com.kent.testCase;

import com.kent.utilities.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class BaseClass {
    ReadProperties rp = new ReadProperties();
    public static WebDriver driver;
    public String baseURL =rp.getApplicationURL();
    public String userName =rp.getUserName();
    public String password =rp.getPassword();
    @Parameters("browser")
    @BeforeClass
    public void launchBrowser(String browser)
    {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.get(baseURL);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String captureScreen(String tcName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+tcName+'_'+currentDate()+".png";
        File target = new File(targetFilePath);
        //FileUtils.copyFile(source,target);
        source.renameTo(target);
        System.out.println("Screenshot captured");
        return targetFilePath;
    }

    public static String currentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }

    public void waitT(WebElement webElement)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
