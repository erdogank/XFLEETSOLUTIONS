package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//div[@class='pull-left pull-left-extra']/div")
    public WebElement dashBoard;
    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement profileMenu;
}
