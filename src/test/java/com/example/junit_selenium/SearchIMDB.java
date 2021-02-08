package com.example.junit_selenium;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchIMDB {
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
    public void imdb() {
        driver.get("https://www.imdb.com/");
        driver.manage().window().setSize(new Dimension(1107, 692));
         /*driver.findElement(By.id("suggestion-search")).click();
        driver.findElement(By.id("suggestion-search")).sendKeys("wandavision");
       //Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            //handle the exception
        }

        driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);
        /*try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            //handle the exception
        }
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.linkText("WandaVision")).click();*/
    }
}
