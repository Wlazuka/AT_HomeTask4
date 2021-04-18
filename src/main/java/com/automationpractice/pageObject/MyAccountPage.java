package com.automationpractice.pageObject;

import com.automationpractice.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    @FindBy(xpath = "//p[contains(text(),'Welcome to your account. Here you can manage all o')]")
    public static WebElement welcomeMsg;

    public boolean welcomeMsgIsDisplayed(){
        return welcomeMsg.isDisplayed();
    }

}
