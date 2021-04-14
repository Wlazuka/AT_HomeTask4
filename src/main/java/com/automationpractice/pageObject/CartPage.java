package com.automationpractice.pageObject;

import com.automationpractice.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@data-name='Subtotals']")
    public WebElement subtotalFiled;

    public CartPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }
}
