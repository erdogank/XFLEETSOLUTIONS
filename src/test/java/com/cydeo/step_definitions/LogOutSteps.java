package com.cydeo.step_definitions;

import com.cydeo.pages.HomePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class LogOutSteps {
    HomePage homePage = new HomePage();
    Set<String> WindowIds;
    String xFleetId;

    @When("she or he clicks on profile name")
    public void she_or_he_clicks_on_profile_name()  {
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.profileMenu));
        //Actions actions = new Actions(Driver.getDriver());
        //actions.moveToElement(homePage.profileMenu).click().perform();
       //homePage.profileMenu.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",homePage.profileMenu);

    }
    @When("clicks on Logout")
    public void clicks_on_logout() {
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.logOut));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();",homePage.logOut);
        //Actions actions = new Actions(Driver.getDriver());
        //actions.moveToElement(homePage.logOut).click().perform();

       //homePage.logOut.click();

    }
    @Then("he or she should land on Login page")
    public void he_or_she_should_land_on_login_page() {

        Assert.assertEquals("Login",Driver.getDriver().getTitle());

    }

    @When("he or she clicks back button")
    public void he_clicks_back_button() {
       Driver.getDriver().navigate().back();
    }
    @Then("he or she can not go homepage again")
    public void he_or_she_can_not_go_homepage_again() {
        Assert.assertFalse(Driver.getDriver().getTitle().equals("Dashboard"));
    }

    @When("he or she does not touch the keyboard and mouse for {int} minutes")
    public void he_or_she_does_not_touch_the_keyboard_and_mouse_for_minutes(Integer int1) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),190);
        wait.until(ExpectedConditions.titleContains("Login"));
    }
    @Then("he or she must be logged out")
    public void he_or_she_must_be_logged_out() {
        //Driver.getDriver().navigate().refresh();
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Login"));
    }

    @When("he or she opens a new window")
    public void he_or_she_opens_a_new_window() {

        //Windows Id of the XFleet
        xFleetId = Driver.getDriver().getWindowHandle();
        //new blank page
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('about:blank','_blank');");

        //All open windows Id's
        WindowIds = Driver.getDriver().getWindowHandles();
        //switch to XFleet window
        Driver.getDriver().switchTo().window(xFleetId);


    }
    @When("he or she closes the program window")
    public void he_or_she_closes_the_program_window() {
        Driver.getDriver().close();
    }
    @When("he or she opens program in the second window")
    public void he_or_she_opens_program_in_the_second_window() {


        for (String windowId : WindowIds) {
            if(!(windowId.equals(xFleetId))){
                Driver.getDriver().switchTo().window(windowId);
            }

        }
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));


    }

    @Then("he or she should not be on the homepage")
    public void he_or_she_should_not_be_on_the_homepage() {
        Assert.assertEquals("Login",Driver.getDriver().getTitle());
    }




}
