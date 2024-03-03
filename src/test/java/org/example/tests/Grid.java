package org.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Grid {

    String gridUrl = "http://192.168.0.167:4444";
    String baseUrl = "https://dnipro-m.ua/";
    String title = "Hello world!";

    @Test
    public void testChrome() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver chromeDriver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
        chromeDriver.get(baseUrl);
        Assert.assertEquals(chromeDriver.getTitle(), title, "It isn't");
        chromeDriver.quit();
    }

    @Test
    public void testFirefox() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver firefoxDriver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
        firefoxDriver.get(baseUrl);
        Assert.assertEquals(firefoxDriver.getTitle(), title, "It isn't");
        firefoxDriver.quit();
    }

    }

