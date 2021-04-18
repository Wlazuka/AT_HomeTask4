package com.automationpractice.pageObject;

import com.automationpractice.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='email_create']")
    public static WebElement createAccountEmailField;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    public static WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='email']")
    public static WebElement signInEmailField;

    @FindBy(xpath = "//input[@id='passwd']")
    public static WebElement passwordField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    public static WebElement signInButton;

    @FindBy(xpath = "//div[@id='create_account_error']")
    public static WebElement alertField;

    public SignInPage(WebDriver driver, PropertyManager propertyManager) {
        super(driver, propertyManager);
    }

    public SignInPage createAccount(String text) {
        enterTextIntoField(createAccountEmailField, text);
        createAccountButton.click();
        return this;
    }

    public SignInPage provideEmail(String email) {
        enterTextIntoField(signInEmailField, email);
        return this;
    }

    public SignInPage providePassword(String password) {
        enterTextIntoField(passwordField, password);
        return this;
    }

    public SignInPage pressSingInButton() {
        clickOnElement(signInButton);
        return this;
    }

    public SignInPage alertText(){
        alertField.getText();
        return this;
    }

    public SignInPage signIn(String email, String password){
        provideEmail(email);
        providePassword(password);
        pressSingInButton();
        return this;
    }
}
