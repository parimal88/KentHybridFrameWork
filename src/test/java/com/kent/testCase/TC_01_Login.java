package com.kent.testCase;

import com.kent.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class TC_01_Login extends BaseClass{
    public HomePage hp;
    @Test
    public void loginTest() throws IOException {
        hp = new HomePage(driver);
        hp.clickAccount();
        hp.setUserName(userName);
        hp.setPassword(password);
        hp.signIn();
        waitT(hp.txtAccountDashboard);
        String pageTitle= driver.getTitle();
        if (pageTitle.equalsIgnoreCase("My Account | Kent Building Supplies"))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
}
