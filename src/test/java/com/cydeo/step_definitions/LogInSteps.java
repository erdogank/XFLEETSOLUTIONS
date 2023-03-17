package com.cydeo.step_definitions;

import com.cydeo.pages.HomePage;
import com.cydeo.pages.LogInPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LogInSteps {

    HomePage homePage=new HomePage();
    LogInPage logInPage=new LogInPage();

    @Given("The user is on the log in page")
    public void the_user_is_on_the_log_in_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enters his or her {string} and {string}")
    public void user_enters_his_or_her_and(String username, String password) {
        logInPage.logIn.sendKeys(username);
        logInPage.passWord.sendKeys(password);
    }

    @When("clicks the LogIn button")
    public void clicks_the_log_in_button() {
       logInPage.logInButton.click();
    }

    @Then("she or he should lands on the {string}")
    public void she_or_he_should_lands_on_the(String string) {
        Assert.assertEquals(string, homePage.dashBoard.getText());

    }

    @Then("she or he gets {string} message")
    public void she_or_he_gets_message(String expectedMessage) {
       Assert.assertEquals(expectedMessage,logInPage.errorMessage.getText());
    }

    @Then("she or he gets {string} message from Username field")
    public void she_or_he_gets_message_from_username_field(String message) {
        String actualMessage =logInPage.logIn.getAttribute("validationMessage");
       Assert.assertEquals(message,actualMessage);
    }

    @When("user enters his or her username like {string}")
    public void user_enters_his_or_her_username_like(String string) {
        logInPage.logIn.sendKeys(string);
    }

    @Then("she or he get {string} message from Password field")
    public void she_or_he_get_message_from_password_field(String string) {
        Assert.assertEquals(string,logInPage.passWord.getAttribute("validationMessage"));
    }

    @When("user clicks on the Forgot your password? link")
    public void user_clicks_on_the_forgot_your_password_link() {
        logInPage.forgotLink.click();
    }

    @Then("she or he lands on {string} page")
    public void she_or_he_lands_on_page(String string) {
        Assert.assertEquals(string,Driver.getDriver().getTitle());
    }

    @Then("while entering password, user should not see his password instead he should see masked password")
    public void while_entering_password_user_should_not_see_his_password_instead_he_should_see_masked_password() {

        Assert.assertTrue(logInPage.passWord.getAttribute("type").equals("password"));

    }


    @Then("user should see and click on Remember me link")
    public void user_should_see_and_click_on_remember_me_link() throws InterruptedException {
       Assert.assertTrue(logInPage.rememberMe.isDisplayed());
        Assert.assertTrue(logInPage.rememberMe.isEnabled());
        logInPage.logIn.sendKeys("user");
        logInPage.passWord.sendKeys("UserUser123");
        logInPage.rememberMe.click();
        logInPage.logInButton.click();
        Driver.closeDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Thread.sleep(3000);
        System.out.println(Driver.getDriver().getTitle());
    }
    @When("user types his or her {string} and {string}")
    public void user_types_his_or_her_and(String username, String password) {
        logInPage.logIn.sendKeys(username);
        logInPage.passWord.sendKeys(password);
    }
    @When("user press enter key")
    public void user_press_enter_key() {
       logInPage.passWord.sendKeys(Keys.ENTER);
    }
    @Then("user should land on {string} dashboard.")
    public void user_should_land_on_dashboard(String dashboard) {
        Assert.assertEquals(dashboard,homePage.dashBoard.getText());
    }
    @Then("user should see his or her {string} in the profile menu")
    public void user_should_see_his_or_her_in_the_profile_menu(String username) {
        Assert.assertEquals(username,homePage.profileMenu.getText());

    }





}
