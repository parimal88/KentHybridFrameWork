package com.kent.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver ldriver;
    public HomePage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }
    @FindBy(css = "#header-links li.header-account-container a")
    public static WebElement lnkAccount;
    @FindBy(css = "#email")
    public static WebElement userName;
    @FindBy(css = "input[name=\"login[password]\"]")
    public static WebElement password;
    @FindBy(css = ".action.login.primary")
    public static WebElement btnSignIn;
    public void clickAccount(){
        lnkAccount.click();
    }
    public void setUserName(String uname){
        userName.sendKeys(uname);
    }
    public void setPassword(String pass){
        password.sendKeys(pass);
    }
    public void signIn(){
        btnSignIn.click();
    }
}
