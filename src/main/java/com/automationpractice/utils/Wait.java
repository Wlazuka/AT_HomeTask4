package com.automationpractice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    private final WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

//    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
//        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
//    }

    private void waitUntilCondition(ExpectedCondition<Object> condition, long time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(condition);
    }

    public void forPageToLoad(long time){
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        waitUntilCondition(condition, time);
    }
}
