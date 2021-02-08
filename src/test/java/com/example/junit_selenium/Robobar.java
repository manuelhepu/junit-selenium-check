package com.example.junit_selenium;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Robobar {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        //driver = new FirefoxDriver();

        DesiredCapabilities capabilities = new  DesiredCapabilities();
        capabilities.setCapability("browserName","firefox");

        //Configuration.startMaximized =true;
        //open("about:blank");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void robobar() {
        driver.get("http://10.250.7.2:3000/");
        /*try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            //handle the exception
        }*/
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1107, 703));

        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn")).click();
        assertTrue(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText().matches("€1.25"));

        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
        assertTrue(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText().matches("€3.25"));

        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) .input-group-append > .btn")).click();
        assertTrue(driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText().matches("€6.25"));

        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        /*try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            //handle the exception
        }*/
/*
        driver.findElement(By.id("ageInput")).click();
        driver.findElement(By.id("ageInput")).sendKeys("26");

        
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            //handle the exception
        }*/

        /*driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        assertTrue(driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(3)")).getText().matches("€1.25"));
        assertTrue(driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(3)")).getText().matches("€2.00"));
        assertTrue(driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(3)")).getText().matches("€3.00"));

        driver.findElement(By.cssSelector(".btn-success")).click();
        assertTrue(driver.findElement(By.cssSelector("p")).getText().matches("Coming right up! ~bzzzt~"));*/


    }
}
