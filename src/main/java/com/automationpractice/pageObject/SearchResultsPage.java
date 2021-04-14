package com.automationpractice.pageObject;

import com.automationpractice.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {


    @FindBy(xpath = " //span[@class='heading-counter']")
    public static WebElement searchCounter;

    @FindBy(xpath = "//div[@class='product-container']//a[@class='product-name']")
    public static List<WebElement> resultList;


    public SearchResultsPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }
}
