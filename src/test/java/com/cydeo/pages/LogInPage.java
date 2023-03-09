package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    public LogInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement logIn;
    @FindBy(id="prependedInput2")
    public WebElement passWord;

    @FindBy(id = "_submit")
    public WebElement logInButton;

    @FindBy(css = ".alert.alert-error")
    public WebElement errorMessage;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotLink;

    @FindBy(css = ".custom-checkbox__text")
    public WebElement rememberMe;

}
