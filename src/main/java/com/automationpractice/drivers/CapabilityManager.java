package com.automationpractice.drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.opera.OperaOptions;

public class CapabilityManager {

    private CapabilityManager(){}

    private static final String ACCEPT_INSECURE_CERTS = "acceptInsecureCerts";

    public static ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(ACCEPT_INSECURE_CERTS, true);
        chromeOptions.setCapability("platform", "Linux");
        chromeOptions.addArguments("--remote-debugging-port=9225");
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        ProfilesIni init = new ProfilesIni();
        FirefoxProfile testProfile = init.getProfile("default-release");
        testProfile.setAcceptUntrustedCertificates(true);
        testProfile.setPreference("network.proxy.type", 0);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(testProfile);
        firefoxOptions.setHeadless(true);
        firefoxOptions.setCapability(ACCEPT_INSECURE_CERTS, true);
        return firefoxOptions;
    }

    public static OperaOptions getOperaOptions(){
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.setCapability(ACCEPT_INSECURE_CERTS, true);
        operaOptions.addArguments("start-maximized");
        return operaOptions;
    }
}

