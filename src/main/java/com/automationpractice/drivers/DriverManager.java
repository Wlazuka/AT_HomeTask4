package com.automationpractice.drivers;


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

    static final String CHROME_DRIVER_PATH = "drivers/chromedriver";
    static final String FIREFOX_DRIVER_PATH = "drivers/geckodriver";
    static final String OPERA_DRIVER_PATH = "drivers/operadriver";


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
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver(CapabilityManager.getChromeOptions());
    }
    private WebDriver getLocalFirefox(){
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        return new FirefoxDriver(CapabilityManager.getFirefoxOptions());
    }

    private WebDriver getLocalOpera(){
        System.setProperty("webdriver.opera.driver", OPERA_DRIVER_PATH);
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
