package com.kent.testCase;

import com.kent.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC_01_Login extends BaseClass{
    public HomePage hp;
    @Test
    public void loginTest(){
        driver.get("https://b2c.mcstaging3.kent.ca/");
        hp = new HomePage(driver);
        hp.clickAccount();
        hp.setUserName("automationtestsc1@yopmail.com");
        hp.setPassword("Test@123");
        hp.signIn();
        if (driver.getTitle().equalsIgnoreCase("My Account | Kent Building Supplies"))
            Assert.assertTrue(true);
        else
            Assert.assertTrue(false);
    }


}
