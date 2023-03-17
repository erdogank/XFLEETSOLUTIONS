package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver getDriver(String browser){

        WebDriver driver = null;

        if(browser.equalsIgnoreCase("chrome")){
            //1-set up web driver manager
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=c:/temp/");

            //2-create instance of the chrome driver
            driver = new ChromeDriver(options);

        }
        else if(browser.equalsIgnoreCase("firefox")){
            //1-set up web driver manager
            WebDriverManager.firefoxdriver().setup();

            //2-create instance of the chrome driver
            driver = new FirefoxDriver();


        }
        else{
            System.err.println("Given browser type does not exist/or is not currently supported");
            System.err.println("Driver= null");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;





    }
}
