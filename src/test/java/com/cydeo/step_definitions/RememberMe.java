package com.cydeo.step_definitions;

import com.cydeo.pages.HomePage;
import com.cydeo.pages.LogInPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RememberMe {
    HomePage homepage = new HomePage();
    LogInPage login = new LogInPage();








    @Given("user log in the program by checking Remember me")
    public void user_log_in_the_program_by_checking_remember_me() {
        Driver.getDriver().get("http://qa.xfleetsolutions.com/");
        login.logIn.sendKeys("user1");
        login.passWord.sendKeys("UserUser123");
        login.rememberToClick.click();
        login.logInButton.click();

  Driver.closeDriver();





        //driver.findElement(By.id("prependedInput")).sendKeys("user1");
        //driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        //driver.findElement(By.cssSelector("#login-form > fieldset > div.oro-remember-me > label > span.custom-checkbox__text")).click();
        //driver.findElement(By.id("_submit")).click();
        //driver.quit();

    }

    @Then("user opens the program again and lands on homepage directly")
    public void user_opens_the_program_again_and_lands_on_homepage_directly() {
//        WebDriverManager.chromedriver().setup();
//        //WebDriver driver =  WebDriverFactory.getDriver("chrome");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("user-data-dir=c:/temp/");
//        WebDriver driver = new ChromeDriver(options);

        Driver.getDriver().get("http://qa.xfleetsolutions.com/");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        Assert.assertEquals("Dashboard",Driver.getDriver().getTitle());

        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("arguments[0].click();",homepage.profileMenu);
        //homepage.profileMenu.click();


        //wait.until(ExpectedConditions.elementToBeClickable(homepage.logOut));
        //js.executeScript("arguments[0].click();",homepage.logOut);
        //homepage.logOut.click();


        Driver.getDriver().findElement(By.cssSelector("#user-menu > a")).click();
        Driver.getDriver().findElement(By.linkText("Logout")).click();
        Assert.assertEquals("Login",Driver.getDriver().getTitle());
        //Driver.closeDriver();

    }

}
