package com.automationpractice.pageObject;

import com.automationpractice.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = PropertyManager.getProperty("homepage.url");
    private static final String PAGE_TITLE = PropertyManager.getProperty("homepage.title");

    @FindBy(xpath = "//input[@id='search_query_top']")
    public static WebElement searchField;

    @FindBy(xpath = "//button[@name='submit_search']")
    public static WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    public static WebElement signInLink;

    @FindBy(xpath = "//div[@id='contact-link']")
    public static WebElement contactLink;

    @FindBy(xpath = "//a[contains(text(),'Your Account')]")
    public static WebElement myAccountLink;


    public HomePage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public HomePage open() {
        openWebPage(HOME_PAGE_URL);
        checkPageTitle(PAGE_TITLE);
        return this;
    }

    public HomePage searchProduct(String item) {
        enterTextIntoField(searchField, item);
        clickOnElement(searchButton);
        return this;
    }

    public HomePage goToContactPage() {
        clickOnElement(contactLink);
        return this;
    }

    public HomePage signIn() {
        clickOnElement(signInLink);
        return this;
    }
}

