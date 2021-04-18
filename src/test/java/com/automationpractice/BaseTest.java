package com.automationpractice;

import com.automationpractice.drivers.DriverManager;
import com.automationpractice.pageObject.*;
import com.automationpractice.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected PropertyManager propertyManager;
    protected DriverManager driverManager;

    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected CreateAccountPage createAccountPage;
    protected SignInPage signInPage;
    protected MyAccountPage myAccountPage;

    @Parameters({"browserName", "testDataFileName"})
    @BeforeClass
    public void setup(String browserName, String testDataFileName) {
        driverManager = new DriverManager();
        driver.set(driverManager.getDriver(browserName, "Grid"));
        propertyManager = new PropertyManager();

        homePage = new HomePage(driver.get(), propertyManager);
        searchResultsPage = new SearchResultsPage(driver.get(), propertyManager);
        signInPage = new SignInPage(driver.get(), propertyManager);
        createAccountPage = new CreateAccountPage(driver.get(), propertyManager);
        myAccountPage = new MyAccountPage(driver.get(), propertyManager);
    }

    @AfterMethod
    public void browserReset(){
        driver.get().manage().deleteAllCookies();
    }

    @AfterClass
    public void cleanUp(){
        driver.get().quit();
        driver.remove();
    }
}
