package com.kent.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#header-links li.header-account-container a")
    public static WebElement lnkAccount;
    @FindBy(css = "#email")
    public static WebElement userName;
    @FindBy(css = "input[name=\"login[password]\"]")
    public static WebElement password;
    @FindBy(css = ".action.login.primary")
    public static WebElement btnSignIn;

    // Below component is the account dashboard page
    @FindBy(xpath = "//div[@class='show-for-desktop']//span[@class='base']")
    public static WebElement txtAccountDashboard;
    public void clickAccount(){
        lnkAccount.click();
    }
    public void setUserName(String uname){
        userName.sendKeys(uname);
    }
    public static void setPassword(String pass){
        password.sendKeys(pass);
    }
    public static void signIn(){
        btnSignIn.click();
    }
}
