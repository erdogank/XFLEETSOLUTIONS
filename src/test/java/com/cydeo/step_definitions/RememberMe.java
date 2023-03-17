package com.cydeo.step_definitions;

import com.cydeo.pages.HomePage;
import com.cydeo.pages.LogInPage;
import com.cydeo.utilities.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RememberMe {








    @Given("user log in the program by checking Remember me")
    public void user_log_in_the_program_by_checking_remember_me() {
        WebDriver driver =  WebDriverFactory.getDriver("chrome");


       driver.get("http://qa.xfleetsolutions.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("#login-form > fieldset > div.oro-remember-me > label > span.custom-checkbox__text")).click();
        driver.findElement(By.id("_submit")).click();
        driver.quit();

    }
    @Given("user close the program")
    public void user_close_the_program() {
        System.out.println("----------------");

    }
    @Then("user opens the program again and lands on homepage directly")
    public void user_opens_the_program_again_and_lands_on_homepage_directly() {
        WebDriver driver =  WebDriverFactory.getDriver("chrome");

        driver.get("http://qa.xfleetsolutions.com/");
        driver.findElement(By.cssSelector("#user-menu > a")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();

    }

}
