package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//div[@class='pull-left']")
    public WebElement dashBoard;
    @FindBy(css = "#user-menu > a")
    public WebElement profileMenu;

    @FindBy(css = "#user-menu > ul > li.last > a")
    public WebElement profileMenuLink;

    @FindBy(linkText = "Logout")
    public WebElement logOut;
}
