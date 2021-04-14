package com.automationpractice.utils;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;

public class DriverManager {

    public WebDriver getDriver(String driverType){
        return getDriver(driverType, "LOCAL");
    }

    public WebDriver getDriver(String driverType, String gridMode){

        WebDriver requestedDriver = null;
        switch (driverType.toUpperCase(Locale.ROOT)) {
            case "CHROME" :
                if (gridMode.toUpperCase(Locale.ROOT).equals("GRID"))
                    requestedDriver = getRemoteDriver(CapabilityManager.getChromeOptions());
                else requestedDriver = getLocalChrome();
            case "FIREFOX" :
                if (gridMode.toUpperCase(Locale.ROOT).equals("GRID"))
                        requestedDriver = getRemoteDriver(CapabilityManager.getFirefoxOptions());
                else requestedDriver = getLocalFirefox();
            case "OPERA" :
                if (gridMode.toUpperCase(Locale.ROOT).equals("GRID"))
                        requestedDriver = getRemoteDriver(CapabilityManager.getOperaOptions());
                else requestedDriver = getLocalOpera();

            default: requestedDriver = getLocalChrome();
        }
        return requestedDriver;
    }

    private WebDriver getLocalChrome(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("driver.path") + "/chromedriver");
        return new ChromeDriver(CapabilityManager.getChromeOptions());
    }
    private WebDriver getLocalFirefox(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("driver.path") + "/geckodriver");
        return new FirefoxDriver(CapabilityManager.getFirefoxOptions());
    }

    private WebDriver getLocalOpera(){
        System.setProperty("webdriver.opera.driver", System.getProperty("driver.path") + "/operadriver");
        return new OperaDriver(CapabilityManager.getOperaOptions());
    }

    private WebDriver getRemoteDriver(Capabilities capabilities){
        WebDriver requestedDriver = null;
        try{
            requestedDriver = new RemoteWebDriver(new URL(System.getProperty("selenium.grid.url")), capabilities);
        } catch (MalformedURLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return requestedDriver;
    }
}
