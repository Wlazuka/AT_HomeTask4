package com.automationpractice;

import com.automationpractice.drivers.DriverManager;
import com.automationpractice.pageObject.*;
import com.automationpractice.utils.PropertyManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public abstract class BaseTest {


    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected PropertyManager propertyManager;
    protected DriverManager driverManager;

    protected JavascriptExecutor js;

    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected CreateAccountPage createAccountPage;
    protected SignInPage signInPage;
    protected ProductDetailsPage productDetailsPage;
    protected SubTotalPage subTotalPage;
    protected CartPage cartPage;

    @Parameters({"browserName","testDataFileName"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browserName
                , @Optional("default.properties") String testDataFileName){
        driverManager = new DriverManager();
        driver.set(driverManager.getDriver(browserName, "Grid"));
        propertyManager = new PropertyManager();


        js = (JavascriptExecutor) driver;

        homePage = new HomePage(driver.get(), propertyManager);
        searchResultsPage = new SearchResultsPage(driver.get(), propertyManager);
        signInPage = new SignInPage(driver.get(), propertyManager);
        createAccountPage = new CreateAccountPage(driver.get(), propertyManager);
        productDetailsPage = new ProductDetailsPage(driver.get(), propertyManager);
        subTotalPage = new SubTotalPage(driver.get(), propertyManager);
        cartPage = new CartPage(driver.get(), propertyManager);
    }

//    @AfterMethod
//    public void browserReset(){
//        driver.get().manage().deleteAllCookies();
//    }

    @AfterClass
    public void cleanUp(){
        driver.get().quit();
        driver.remove();
    }
}
